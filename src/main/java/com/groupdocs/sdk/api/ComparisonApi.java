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
import com.groupdocs.sdk.model.CompareResponse;
import com.groupdocs.sdk.model.ChangesResponse;
import com.groupdocs.sdk.model.ChangeInfo;
import com.groupdocs.sdk.model.DocumentDetailsResponse;
import java.util.*;

public class ComparisonApi {
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

  public FileStream DownloadResult (String userId, String resultFileId, String format) throws ApiException {
    // verify required params are set
    if(userId == null || resultFileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/comparison/{userId}/comparison/download?resultFileId={resultFileId}&format={format}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(resultFileId)))
      queryParams.put("resultFileId", String.valueOf(resultFileId));
    if(!"null".equals(String.valueOf(format)))
      queryParams.put("format", String.valueOf(format));
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
  public CompareResponse Compare (String userId, String sourceFileId, String targetFileId, String callbackUrl) throws ApiException {
    // verify required params are set
    if(userId == null || sourceFileId == null || targetFileId == null || callbackUrl == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/comparison/{userId}/comparison/compare?source={sourceFileId}&target={targetFileId}&callback={callbackUrl}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(sourceFileId)))
      queryParams.put("source", String.valueOf(sourceFileId));
    if(!"null".equals(String.valueOf(targetFileId)))
      queryParams.put("target", String.valueOf(targetFileId));
    if(!"null".equals(String.valueOf(callbackUrl)))
      queryParams.put("callback", String.valueOf(callbackUrl));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (CompareResponse) ApiInvoker.deserialize(response, "", CompareResponse.class);
      }
      else {
        return null;
      }
      } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public ChangesResponse GetChanges (String userId, String resultFileId) throws ApiException {
    // verify required params are set
    if(userId == null || resultFileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/comparison/{userId}/comparison/changes?resultFileId={resultFileId}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(resultFileId)))
      queryParams.put("resultFileId", String.valueOf(resultFileId));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (ChangesResponse) ApiInvoker.deserialize(response, "", ChangesResponse.class);
      }
      else {
        return null;
      }
      } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public ChangesResponse UpdateChanges (String userId, String resultFileId, List<ChangeInfo> body) throws ApiException {
    // verify required params are set
    if(userId == null || resultFileId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/comparison/{userId}/comparison/changes?resultFileId={resultFileId}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(resultFileId)))
      queryParams.put("resultFileId", String.valueOf(resultFileId));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (ChangesResponse) ApiInvoker.deserialize(response, "", ChangesResponse.class);
      }
      else {
        return null;
      }
      } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public DocumentDetailsResponse GetDocumentDetails (String userId, String guid) throws ApiException {
    // verify required params are set
    if(userId == null || guid == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/comparison/{userId}/comparison/document?guid={guid}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(guid)))
      queryParams.put("guid", String.valueOf(guid));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (DocumentDetailsResponse) ApiInvoker.deserialize(response, "", DocumentDetailsResponse.class);
      }
      else {
        return null;
      }
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

