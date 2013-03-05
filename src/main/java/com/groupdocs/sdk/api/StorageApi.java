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
import com.groupdocs.sdk.model.CreateFolderResponse;
import com.groupdocs.sdk.model.FileMoveResponse;
import com.groupdocs.sdk.model.ListEntitiesResponse;
import com.groupdocs.sdk.model.CompressResponse;
import com.groupdocs.sdk.model.StorageInfoResponse;
import com.groupdocs.sdk.model.UploadResponse;
import com.groupdocs.sdk.model.DeleteResponse;
import com.groupdocs.sdk.model.FolderMoveResponse;
import com.groupdocs.sdk.model.CreatePackageResponse;
import java.util.*;

public class StorageApi {
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

  public StorageInfoResponse GetStorageInfo (String userId) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (StorageInfoResponse) ApiInvoker.deserialize(response, "", StorageInfoResponse.class);
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
  public ListEntitiesResponse ListEntities (String userId, String path, Integer pageIndex, Integer pageSize, String orderBy, Boolean orderAsc, String filter, String fileTypes, Boolean extended) throws ApiException {
    // verify required params are set
    if(userId == null || path == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/folders/{*path}?page={pageIndex}&count={pageSize}&order_by={orderBy}&order_asc={orderAsc}&filter={filter}&file_types={fileTypes}&extended={extended}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(pageIndex)))
      queryParams.put("page", String.valueOf(pageIndex));
    if(!"null".equals(String.valueOf(pageSize)))
      queryParams.put("count", String.valueOf(pageSize));
    if(!"null".equals(String.valueOf(orderBy)))
      queryParams.put("order_by", String.valueOf(orderBy));
    if(!"null".equals(String.valueOf(orderAsc)))
      queryParams.put("order_asc", String.valueOf(orderAsc));
    if(!"null".equals(String.valueOf(filter)))
      queryParams.put("filter", String.valueOf(filter));
    if(!"null".equals(String.valueOf(fileTypes)))
      queryParams.put("file_types", String.valueOf(fileTypes));
    if(!"null".equals(String.valueOf(extended)))
      queryParams.put("extended", String.valueOf(extended));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (ListEntitiesResponse) ApiInvoker.deserialize(response, "", ListEntitiesResponse.class);
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
  public FileStream GetFile (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/files/{fileId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

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
  public FileStream GetSharedFile (String userEmail, String filePath) throws ApiException {
    // verify required params are set
    if(userEmail == null || filePath == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/shared/{userEmail}/{*filePath}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userEmail" + "}", String.valueOf(userEmail)).replace("{" + "filePath" + "}", String.valueOf(filePath));

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
  public UploadResponse Upload (String userId, String path, String description, FileStream body) throws ApiException {
    // verify required params are set
    if(userId == null || path == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/folders/{*path}?description={description}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(description)))
      queryParams.put("description", String.valueOf(description));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (UploadResponse) ApiInvoker.deserialize(response, "", UploadResponse.class);
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
  public UploadResponse Decompress (String userId, String path, String description, String archiveType, FileStream body) throws ApiException {
    // verify required params are set
    if(userId == null || path == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/decompress/{*path}?description={description}&archiveType={archiveType}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(description)))
      queryParams.put("description", String.valueOf(description));
    if(!"null".equals(String.valueOf(archiveType)))
      queryParams.put("archiveType", String.valueOf(archiveType));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (UploadResponse) ApiInvoker.deserialize(response, "", UploadResponse.class);
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
  public UploadResponse UploadWeb (String userId, String url) throws ApiException {
    // verify required params are set
    if(userId == null || url == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/urls?url={url}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(url)))
      queryParams.put("url", String.valueOf(url));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (UploadResponse) ApiInvoker.deserialize(response, "", UploadResponse.class);
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
  public UploadResponse UploadGoogle (String userId, String path, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || path == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/google/files/{*path}?file_id={fileId}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(fileId)))
      queryParams.put("file_id", String.valueOf(fileId));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (UploadResponse) ApiInvoker.deserialize(response, "", UploadResponse.class);
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
  public DeleteResponse Delete (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/files/{fileId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
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
  public DeleteResponse DeleteFromFolder (String userId, String path) throws ApiException {
    // verify required params are set
    if(userId == null || path == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/folders/{*path}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
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
  public FileMoveResponse MoveFile (String userId, String path, String mode, String Groupdocs_Copy, String Groupdocs_Move) throws ApiException {
    // verify required params are set
    if(userId == null || path == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/files/{*path}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(mode)))
      queryParams.put("mode", String.valueOf(mode));
    headerParams.put("Groupdocs-Copy", Groupdocs_Copy);
    headerParams.put("Groupdocs-Move", Groupdocs_Move);
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (FileMoveResponse) ApiInvoker.deserialize(response, "", FileMoveResponse.class);
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
  public FolderMoveResponse MoveFolder (String userId, String path, String mode, String Groupdocs_Move, String Groupdocs_Copy) throws ApiException {
    // verify required params are set
    if(userId == null || path == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/folders/{*path}?override_mode={mode}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(mode)))
      queryParams.put("override_mode", String.valueOf(mode));
    headerParams.put("Groupdocs-Move", Groupdocs_Move);
    headerParams.put("Groupdocs-Copy", Groupdocs_Copy);
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (FolderMoveResponse) ApiInvoker.deserialize(response, "", FolderMoveResponse.class);
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
  public CreateFolderResponse Create (String userId, String path) throws ApiException {
    // verify required params are set
    if(userId == null || path == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/paths/{*path}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (CreateFolderResponse) ApiInvoker.deserialize(response, "", CreateFolderResponse.class);
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
  public CompressResponse Compress (String userId, String fileId, String archiveType) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || archiveType == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/files/{fileId}/archive/{archiveType}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "archiveType" + "}", String.valueOf(archiveType));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

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
  public CreatePackageResponse CreatePackage (String userId, String packageName, Boolean storeRelativePath, List<String> body) throws ApiException {
    // verify required params are set
    if(userId == null || packageName == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/packages/{packageName}?storeRelativePath={storeRelativePath}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "packageName" + "}", String.valueOf(packageName));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(storeRelativePath)))
      queryParams.put("storeRelativePath", String.valueOf(storeRelativePath));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (CreatePackageResponse) ApiInvoker.deserialize(response, "", CreatePackageResponse.class);
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
  public FolderMoveResponse MoveToTrash (String userId, String path) throws ApiException {
    // verify required params are set
    if(userId == null || path == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/trash/{*path}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (FolderMoveResponse) ApiInvoker.deserialize(response, "", FolderMoveResponse.class);
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
  public DeleteResponse RestoreFromTrash (String userId, String path) throws ApiException {
    // verify required params are set
    if(userId == null || path == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/storage/{userId}/trash/{*path}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
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
  }

