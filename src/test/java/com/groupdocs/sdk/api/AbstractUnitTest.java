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
package com.groupdocs.sdk.api;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.skyscreamer.jsonassert.JSONAssert;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.NumberSerializer;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;
import com.groupdocs.sdk.common.RequestSigner;
import com.wordnik.swagger.core.util.JsonUtil;

public abstract class AbstractUnitTest {
	public static ObjectMapper jsonMapper = JsonUtil.getJsonMapper();
	protected static String userId;
	private static final Boolean enableLogging;
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(ApiInvoker.DATE_FORMAT);
	@Rule public TestName name = new TestName();
	
	static {
		String clientKey = System.getProperty("clientKey", "CLIENT_ID");
		String privateKey = System.getProperty("privateKey", "PRIVATE_KEY");
		RequestSigner signer = new GroupDocsRequestSigner(privateKey);
		ApiInvoker.getInstance().setRequestSigner(signer);
		userId = clientKey;
		enableLogging = Boolean.valueOf(System.getProperty("enableLogging", "true"));
		
		// some GroupDocs models define ints as doubles
		jsonMapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS);
		jsonMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		SimpleModule m = new SimpleModule(ApiInvoker.PACKAGE_NAME, Version.unknownVersion());
		m.addSerializer(new StdScalarSerializer<Date>(Date.class){
			
			@Override
			public void serialize(Date value, JsonGenerator jgen,
					SerializerProvider provider) throws IOException,
					JsonProcessingException {
				jgen.writeString(dateFormat.format(value));
			}
		});
		m.addSerializer(new StdScalarSerializer<Number>(Number.class){

			@Override
			public void serialize(Number value, JsonGenerator jgen,
					SerializerProvider provider) throws IOException,
					JsonGenerationException {
				if (value instanceof Double) {
	            	if(value.toString().endsWith(".0")) {
	            		jgen.writeNumber(value.intValue());
	            	} else {
	            		jgen.writeNumber(value.doubleValue());
	            	}
	            } else if (value instanceof Float) {
	            	if(value.toString().endsWith(".0")) {
	            		jgen.writeNumber(value.intValue());
	            	} else {
	            		jgen.writeNumber(value.floatValue());
	            	}
	            } else {
	            	NumberSerializer.instance.serialize(value, jgen, provider);
	            }
			}
			
			@Override
			public JsonNode getSchema(SerializerProvider provider, Type typeHint)
					throws JsonMappingException {
				return NumberSerializer.instance.getSchema(provider, typeHint);
			}
			
		});
		jsonMapper.registerModule(m);
	}

	public static void log(Object msg){
		if(enableLogging){
			System.out.println(msg);
		}
	}
	
	public String getSampleResponse(String fileName) throws Exception {
		return readFileToString("responses/" + fileName);
	}
	
	public <T> T getSampleRequest(String fileName, final TypeReference<T> type) throws Exception {
		return jsonMapper.readValue(readFileToString("requests/" + fileName), type);
	}
	
	public String readFileToString(String filepath) throws Exception {
		URL resource = AbstractUnitTest.class.getClassLoader().getResource(filepath);
		if(resource == null){
			log("WARNING: File " + filepath + " doesn't exist. Ignoring " + name.getMethodName());
		}
		org.junit.Assume.assumeNotNull(resource);
		File jsonFile = new File(resource.toURI());
		return FileUtils.readFileToString(jsonFile);
	}
	
	public static void assertSameJson(String expectedJson, Object actualJson) throws Exception {
//		assertThat(jsonMapper.readTree(expectedJson), 
//				equalTo(jsonMapper.readTree(jsonMapper.writeValueAsString(actualJson))));
		JSONAssert.assertEquals(jsonMapper.writeValueAsString(actualJson), expectedJson, false);
//        JSONCompareResult result = JSONCompare.compareJSON(jsonMapper.writeValueAsString(actualJson), expectedJson, JSONCompareMode.STRICT_ORDER);
//        if (result.failed()) {
//            throw new AssertionError(result.getMessage());
//        }
	}
	
}
