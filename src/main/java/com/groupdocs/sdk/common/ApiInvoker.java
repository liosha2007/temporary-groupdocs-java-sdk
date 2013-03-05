/**
 *  Copyright 2012 GroupDocs.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.groupdocs.sdk.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.client.apache4.ApacheHttpClient4;
import com.sun.jersey.client.apache4.config.DefaultApacheHttpClient4Config;
import com.sun.jersey.core.header.MediaTypes;
import com.wordnik.swagger.core.util.JsonUtil;

public class ApiInvoker {
  public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  private static ApiInvoker INSTANCE = new ApiInvoker();
  private Map<String, Client> hostMap = new HashMap<String, Client>();
  private Map<String, String> defaultHeaderMap = new HashMap<String, String>();
  private static final String ENC = "UTF-8";
  private RequestSigner signer;
  private boolean isDebug;

  public static final String PACKAGE_NAME;
  public static final String PACKAGE_VERSION;
    
  static {
	Properties prop = new Properties();
    InputStream in = ApiInvoker.class.getResourceAsStream("/META-INF/application.properties");
	if(in != null){
	    try {
			prop.load(in);
		} catch (IOException e) {
		} finally {
			try {
				in.close();
			} catch (IOException e) {
			}
		}
	}
	PACKAGE_NAME = prop.getProperty("application.name", "groupdocs-java");
	PACKAGE_VERSION = prop.getProperty("application.version", "unknown");
  }
  
  public static class CustomDateDeserializer extends DateDeserializer {
	  public CustomDateDeserializer(DateDeserializer base){
		  super(base, new SimpleDateFormat(DATE_FORMAT), DATE_FORMAT);
	  }
  }
  
  public static ApiInvoker getInstance() {
    return INSTANCE;
  }
  
  public void setDebug(boolean flag){
	  this.isDebug = flag;
  }

  public void setRequestSigner(RequestSigner signer){
	  this.signer = signer;
  }
  
  public void addDefaultHeader(String key, String value) {
	   defaultHeaderMap.put(key, value);
  }

  public String escapeString(String str) {
	  return encodeURIComponent(str);
  }

  public static String encodeURI(String uri) {
	  return encodeURIComponent(uri)
			  .replace("%3B", ";")
			  .replace("%2C", ",")
			  .replace("%2F", "/")
			  .replace("%3F", "?")
			  .replace("%3A", ":")
			  .replace("%40", "@")
			  .replace("%26", "&")
			  .replace("%3D", "=")
			  //.replace("%2B", "+")
			  .replace("%24", "$")
			  .replace("%25", "%")
			  .replace("%23", "#");
  }

  public static String encodeURIComponent(String str) {
	  try {
		  return URLEncoder.encode(str, ENC)
	              .replace("+", "%20")
	              .replace("%21", "!")
	              .replace("%27", "'")
	              .replace("%28", "(")
	              .replace("%29", ")")
	              .replace("%7E", "~");
	  } catch(UnsupportedEncodingException e){
    	  return str;
	  }
  }

  public static Object deserialize(String json, String containerType, Class cls) throws ApiException {
    try{
      ObjectMapper mapper = JsonUtil.getJsonMapper();
	  SimpleModule m = new SimpleModule(PACKAGE_NAME, Version.unknownVersion());
	  m.addDeserializer(Date.class, new CustomDateDeserializer(new DateDeserializer()));
	  mapper.registerModule(m);
      
      if("List".equals(containerType)) {
        JavaType typeInfo = mapper.getTypeFactory().constructCollectionType(List.class, cls);
        List response = (List<?>) mapper.readValue(json, typeInfo);
        return response;
      }
      else if(String.class.equals(cls)) {
        return json;
      }
      else {
        return mapper.readValue(json, cls);
      }
    }
    catch (IOException e) {
      throw new ApiException(500, e.getMessage());
    }
  }

  public static String serialize(Object obj) throws ApiException {
    try {
      if (obj != null) {
    	ObjectMapper jsonMapper = JsonUtil.getJsonMapper();
    	jsonMapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
		return jsonMapper.writeValueAsString(obj);
      }
      else return "";
    }
    catch (Exception e) {
      throw new ApiException(500, e.getMessage());
    }
  }

  public <T> T invokeAPI(String host, String path, String method, Map<String, String> queryParams, Object body, Map<String, String> headerParams, Class<T> returnType) throws ApiException {
    Client client = getClient(host);

    StringBuilder b = new StringBuilder();
    
    for(String key : queryParams.keySet()) {
    	String value = queryParams.get(key);
    	if (value != null){
    		if(b.toString().length() == 0) b.append("?");
    		else b.append("&");
    		b.append(escapeString(key)).append("=").append(escapeString(value));
    	}
    }
    String querystring = b.toString();

    boolean isFileUpload = false;
    MediaType contentType;
    if(body == null) {
    	contentType = MediaType.TEXT_HTML_TYPE;
    } else {
    	contentType = MediaType.APPLICATION_JSON_TYPE;
    	if(body instanceof FileStream){
    		isFileUpload = true;
    		contentType = MediaType.APPLICATION_OCTET_STREAM_TYPE;
    	}
    }
    
    String requestUri = encodeURI(signer.signUrl(host + path + querystring)); //TODO incorrect for redirects
	Builder builder = client.resource(requestUri).accept(MediaTypes.GENERAL_ACCEPT_MEDIA_TYPE).type(contentType);
	builder.header("Groupdocs-Referer", PACKAGE_NAME + "/" + PACKAGE_VERSION);	
    for(String key : headerParams.keySet()) {
    	builder.header(key, headerParams.get(key));
    }
    
    for(String key : defaultHeaderMap.keySet()) {
    	if(!headerParams.containsKey(key)) {
    		builder.header(key, defaultHeaderMap.get(key));
    	}
    }
    ClientResponse response = null;

    if("GET".equals(method)) {
    	response = (ClientResponse) builder.get(ClientResponse.class);
    }
    else if ("POST".equals(method)) {
    	Object requestBody;
    	if(isFileUpload){
    		requestBody = ((FileStream)body).getInputStream();
    	} else {
    		requestBody = signer.signContent(serialize(body), builder);
    	}
        response = builder.post(ClientResponse.class, requestBody);
    }
    else if ("PUT".equals(method)) {
    	Object requestBody;
    	if(isFileUpload){
    		requestBody = ((FileStream)body).getInputStream();
    	} else {
    		requestBody = signer.signContent(serialize(body), builder);
    	}
        response = builder.put(ClientResponse.class, requestBody);
      }
    else if ("DELETE".equals(method)) {
        response = builder.delete(ClientResponse.class);
    }
    else {
    	throw new ApiException(500, "unknown method type " + method);
    }
    if(response.getClientResponseStatus() == ClientResponse.Status.OK
    	|| response.getClientResponseStatus() == ClientResponse.Status.CREATED
        || response.getClientResponseStatus() == ClientResponse.Status.ACCEPTED) {
    	T toReturn;
    	if(FileStream.class.equals(returnType)){
    		if(response.getHeaders().containsKey("Transfer-Encoding") || response.getLength() > 0){
    			toReturn = (T) new FileStream(requestUri, response);
    		} else {
    			toReturn = null;
    		}
    	} else {
    		toReturn = (T) response.getEntity(String.class);
    	}
    	return toReturn;
    }
    else {
    	String errMsg = response.getEntity(String.class);
    	try {
    		HashMap<String,Object> props = JsonUtil.getJsonMapper().readValue(errMsg, new TypeReference<HashMap<String,Object>>() {});
    		if(props.containsKey("error_message")){
    			errMsg = (String) props.get("error_message");
    		}
		} catch (IOException e) {
		}
    	throw new ApiException(
    	          response.getClientResponseStatus().getStatusCode(),
    	          errMsg);    	
    }
  }
  
  private Client getClient(String host) {
	if(!hostMap.containsKey(host)) {
		ClientConfig cfg = new DefaultApacheHttpClient4Config();
		int oneMb = 1024 * 1024;
		cfg.getProperties().put(DefaultApacheHttpClient4Config.PROPERTY_CHUNKED_ENCODING_SIZE, oneMb);
		Client client = ApacheHttpClient4.create(cfg);
		
		if(isDebug){
			client.addFilter(new LoggingFilter());
		}
        hostMap.put(host, client);
	}
	return hostMap.get(host);
  }
  
}
