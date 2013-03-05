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

import com.groupdocs.sdk.common.ApiException;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.FileStream;
import java.util.*;

public class SharedApi {
  String basePath = "https://api.groupdocs.com/v2.0";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }
  
  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }
  
  public String getBasePath() {
    return basePath;
  }

  public FileStream Download (String guid, String fileName, Boolean render) throws ApiException {
    // verify required params are set
    if(guid == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/shared/files/{guid}?filename={fileName}&render={render}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "guid" + "}", String.valueOf(guid));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(fileName)))
      queryParams.put("filename", String.valueOf(fileName));
    if(!"null".equals(String.valueOf(render)))
      queryParams.put("render", String.valueOf(render));
    try {
      return apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, FileStream.class);
      } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public FileStream GetXml (String guid) throws ApiException {
    // verify required params are set
    if(guid == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/shared/files/{guid}/xml".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "guid" + "}", String.valueOf(guid));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      return apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, FileStream.class);
      } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public FileStream GetPackage (String path) throws ApiException {
    // verify required params are set
    if(path == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/shared/packages/{*path}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "path" + "}", String.valueOf(path));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      return apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, FileStream.class);
      } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  }

