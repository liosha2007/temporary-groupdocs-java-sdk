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
import com.groupdocs.sdk.model.CompressResponse;
import com.groupdocs.sdk.model.DeleteResponse;
import com.groupdocs.sdk.model.RenameResponse;
import java.util.*;

public class PostApi {
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

  public RenameResponse RenameByPost (String userId, String fileId, String newName) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || newName == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/post/file.rename?user_id={userId}&file_id={fileId}&new_name={newName}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(userId)))
      queryParams.put("user_id", String.valueOf(userId));
    if(!"null".equals(String.valueOf(fileId)))
      queryParams.put("file_id", String.valueOf(fileId));
    if(!"null".equals(String.valueOf(newName)))
      queryParams.put("new_name", String.valueOf(newName));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (RenameResponse) ApiInvoker.deserialize(response, "", RenameResponse.class);
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
  public DeleteResponse DeleteByPost (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/post/file.delete?user_id={userId}&file_id={fileId}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(userId)))
      queryParams.put("user_id", String.valueOf(userId));
    if(!"null".equals(String.valueOf(fileId)))
      queryParams.put("file_id", String.valueOf(fileId));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (DeleteResponse) ApiInvoker.deserialize(response, "", DeleteResponse.class);
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
  public DeleteResponse DeleteFromFolderByPost (String userId, String path) throws ApiException {
    // verify required params are set
    if(userId == null || path == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/post/file.delete.in?user_id={userId}&path={path}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(userId)))
      queryParams.put("user_id", String.valueOf(userId));
    if(!"null".equals(String.valueOf(path)))
      queryParams.put("path", String.valueOf(path));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (DeleteResponse) ApiInvoker.deserialize(response, "", DeleteResponse.class);
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
  public CompressResponse CompressByPost (String userId, String fileId, String archiveType) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || archiveType == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/post/file.compress?user_id={userId}&file_id={fileId}&archive_type={archiveType}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(userId)))
      queryParams.put("user_id", String.valueOf(userId));
    if(!"null".equals(String.valueOf(fileId)))
      queryParams.put("file_id", String.valueOf(fileId));
    if(!"null".equals(String.valueOf(archiveType)))
      queryParams.put("archive_type", String.valueOf(archiveType));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (CompressResponse) ApiInvoker.deserialize(response, "", CompressResponse.class);
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

