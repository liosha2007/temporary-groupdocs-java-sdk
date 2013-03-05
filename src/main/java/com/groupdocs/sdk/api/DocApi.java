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
import com.groupdocs.sdk.model.SharedUsersResponse;
import com.groupdocs.sdk.model.GetDocumentForeignTypesResponse;
import com.groupdocs.sdk.model.GetDocumentInfoResponse;
import com.groupdocs.sdk.model.DocumentAccessInfoResponse;
import com.groupdocs.sdk.model.SetTagsResponse;
import com.groupdocs.sdk.model.DocumentViewsResponse;
import com.groupdocs.sdk.model.SharedDocumentsResponse;
import com.groupdocs.sdk.model.RemoveEditLockResponse;
import com.groupdocs.sdk.model.TemplateFieldsResponse;
import com.groupdocs.sdk.model.ViewDocumentResponse;
import com.groupdocs.sdk.model.GetEditLockResponse;
import com.groupdocs.sdk.model.DocumentUserStatusResponse;
import com.groupdocs.sdk.model.GetTagsResponse;
import com.groupdocs.sdk.model.RemoveTagsResponse;
import com.groupdocs.sdk.model.GetImageUrlsResponse;
import java.util.*;

public class DocApi {
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

  public ViewDocumentResponse ViewDocument (String userId, String fileId, String pageNumber, String pageCount, String width, String quality, String usePdf) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/thumbnails?page_number={pageNumber}&page_count={pageCount}&width={width}&quality={quality}&use_pdf={usePdf}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(pageNumber)))
      queryParams.put("page_number", String.valueOf(pageNumber));
    if(!"null".equals(String.valueOf(pageCount)))
      queryParams.put("page_count", String.valueOf(pageCount));
    if(!"null".equals(String.valueOf(width)))
      queryParams.put("width", String.valueOf(width));
    if(!"null".equals(String.valueOf(quality)))
      queryParams.put("quality", String.valueOf(quality));
    if(!"null".equals(String.valueOf(usePdf)))
      queryParams.put("use_pdf", String.valueOf(usePdf));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (ViewDocumentResponse) ApiInvoker.deserialize(response, "", ViewDocumentResponse.class);
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
  public ViewDocumentResponse ViewDocumentAsHtml (String userId, String fileId, String pageNumber, String pageCount) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/htmlRepresentations?page_number={pageNumber}&page_count={pageCount}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(pageNumber)))
      queryParams.put("page_number", String.valueOf(pageNumber));
    if(!"null".equals(String.valueOf(pageCount)))
      queryParams.put("page_count", String.valueOf(pageCount));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (ViewDocumentResponse) ApiInvoker.deserialize(response, "", ViewDocumentResponse.class);
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
  public DocumentViewsResponse GetDocumentViews (String userId, String startIndex, String pageSize) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/views?page_index={startIndex}&page_size={pageSize}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(startIndex)))
      queryParams.put("page_index", String.valueOf(startIndex));
    if(!"null".equals(String.valueOf(pageSize)))
      queryParams.put("page_size", String.valueOf(pageSize));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (DocumentViewsResponse) ApiInvoker.deserialize(response, "", DocumentViewsResponse.class);
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
  public SharedUsersResponse ShareDocument (String userId, String fileId, List<String> body) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/sharers".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SharedUsersResponse) ApiInvoker.deserialize(response, "", SharedUsersResponse.class);
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
  public SharedUsersResponse UnshareDocument (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/sharers".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SharedUsersResponse) ApiInvoker.deserialize(response, "", SharedUsersResponse.class);
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
  public SharedUsersResponse GetFolderSharers (String userId, String folderId) throws ApiException {
    // verify required params are set
    if(userId == null || folderId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/folders/{folderId}/sharers".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "folderId" + "}", String.valueOf(folderId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SharedUsersResponse) ApiInvoker.deserialize(response, "", SharedUsersResponse.class);
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
  public SharedUsersResponse ShareFolder (String userId, String folderId, List<String> body) throws ApiException {
    // verify required params are set
    if(userId == null || folderId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/folders/{folderId}/sharers".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "folderId" + "}", String.valueOf(folderId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SharedUsersResponse) ApiInvoker.deserialize(response, "", SharedUsersResponse.class);
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
  public SharedUsersResponse UnshareFolder (String userId, String folderId) throws ApiException {
    // verify required params are set
    if(userId == null || folderId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/folders/{folderId}/sharers".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "folderId" + "}", String.valueOf(folderId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SharedUsersResponse) ApiInvoker.deserialize(response, "", SharedUsersResponse.class);
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
  public DocumentAccessInfoResponse SetDocumentAccessMode (String userId, String fileId, String mode) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/accessinfo?mode={mode}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(mode)))
      queryParams.put("mode", String.valueOf(mode));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (DocumentAccessInfoResponse) ApiInvoker.deserialize(response, "", DocumentAccessInfoResponse.class);
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
  public DocumentAccessInfoResponse GetDocumentAccessInfo (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/accessinfo".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (DocumentAccessInfoResponse) ApiInvoker.deserialize(response, "", DocumentAccessInfoResponse.class);
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
  public GetDocumentInfoResponse GetDocumentMetadata (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/metadata".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetDocumentInfoResponse) ApiInvoker.deserialize(response, "", GetDocumentInfoResponse.class);
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
  public GetDocumentInfoResponse GetDocumentMetadataByPath (String userId, String path) throws ApiException {
    // verify required params are set
    if(userId == null || path == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{*path}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetDocumentInfoResponse) ApiInvoker.deserialize(response, "", GetDocumentInfoResponse.class);
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
  public DocumentUserStatusResponse SetDocumentUserStatus (String userId, String fileId, String status) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || status == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/sharer".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(status)))
      queryParams.put("status", String.valueOf(status));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (DocumentUserStatusResponse) ApiInvoker.deserialize(response, "", DocumentUserStatusResponse.class);
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
  public SharedDocumentsResponse GetSharedDocuments (String userId, String sharesTypes, String pageIndex, String pageSize, String orderBy, Boolean orderAsc) throws ApiException {
    // verify required params are set
    if(userId == null || sharesTypes == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/shares/{sharesTypes}?page_index={pageIndex}&page_size={pageSize}&order_by={orderBy}&order_asc={orderAsc}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "sharesTypes" + "}", String.valueOf(sharesTypes));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(pageIndex)))
      queryParams.put("page_index", String.valueOf(pageIndex));
    if(!"null".equals(String.valueOf(pageSize)))
      queryParams.put("page_size", String.valueOf(pageSize));
    if(!"null".equals(String.valueOf(orderBy)))
      queryParams.put("order_by", String.valueOf(orderBy));
    if(!"null".equals(String.valueOf(orderAsc)))
      queryParams.put("order_asc", String.valueOf(orderAsc));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SharedDocumentsResponse) ApiInvoker.deserialize(response, "", SharedDocumentsResponse.class);
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
  public TemplateFieldsResponse GetTemplateFields (String userId, String fileId, Boolean includeGeometry) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/fields?include_geometry={includeGeometry}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(includeGeometry)))
      queryParams.put("include_geometry", String.valueOf(includeGeometry));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (TemplateFieldsResponse) ApiInvoker.deserialize(response, "", TemplateFieldsResponse.class);
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
  public GetDocumentForeignTypesResponse GetDocumentFormats (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/formats".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetDocumentForeignTypesResponse) ApiInvoker.deserialize(response, "", GetDocumentForeignTypesResponse.class);
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
  public FileStream GetDocumentPageImage (String userId, String fileId, Integer pageNumber, String dimension, Integer quality, Boolean usePdf, Boolean expiresOn) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || pageNumber == null || dimension == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/pages/{pageNumber}/images/{dimension}?quality={quality}&use_pdf={usePdf}&expires={expiresOn}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "pageNumber" + "}", String.valueOf(pageNumber)).replace("{" + "dimension" + "}", String.valueOf(dimension));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(quality)))
      queryParams.put("quality", String.valueOf(quality));
    if(!"null".equals(String.valueOf(usePdf)))
      queryParams.put("use_pdf", String.valueOf(usePdf));
    if(!"null".equals(String.valueOf(expiresOn)))
      queryParams.put("expires", String.valueOf(expiresOn));
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
  public FileStream GetDocumentPageHtml (String userId, String fileId, Integer pageNumber, Boolean expiresOn) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || pageNumber == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/pages/{pageNumber}/htmlRepresentations?expires={expiresOn}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "pageNumber" + "}", String.valueOf(pageNumber));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(expiresOn)))
      queryParams.put("expires", String.valueOf(expiresOn));
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
  public GetImageUrlsResponse GetDocumentPagesImageUrls (String userId, String fileId, Integer firstPage, Integer pageCount, String dimension, Integer quality, Boolean usePdf, String token) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || dimension == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/pages/images/{dimension}/urls?first_page={firstPage}&page_count={pageCount}&quality={quality}&use_pdf={usePdf}&token={token}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "dimension" + "}", String.valueOf(dimension));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(firstPage)))
      queryParams.put("first_page", String.valueOf(firstPage));
    if(!"null".equals(String.valueOf(pageCount)))
      queryParams.put("page_count", String.valueOf(pageCount));
    if(!"null".equals(String.valueOf(quality)))
      queryParams.put("quality", String.valueOf(quality));
    if(!"null".equals(String.valueOf(usePdf)))
      queryParams.put("use_pdf", String.valueOf(usePdf));
    if(!"null".equals(String.valueOf(token)))
      queryParams.put("token", String.valueOf(token));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetImageUrlsResponse) ApiInvoker.deserialize(response, "", GetImageUrlsResponse.class);
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
  public GetImageUrlsResponse GetDocumentPagesHtmlUrls (String userId, String fileId, Integer firstPage, Integer pageCount) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/pages/htmlRepresentationUrls?first_page={firstPage}&page_count={pageCount}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(firstPage)))
      queryParams.put("first_page", String.valueOf(firstPage));
    if(!"null".equals(String.valueOf(pageCount)))
      queryParams.put("page_count", String.valueOf(pageCount));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetImageUrlsResponse) ApiInvoker.deserialize(response, "", GetImageUrlsResponse.class);
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
  public GetEditLockResponse GetEditLock (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/editlock".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetEditLockResponse) ApiInvoker.deserialize(response, "", GetEditLockResponse.class);
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
  public RemoveEditLockResponse RemoveEditLock (String userId, String fileId, String lockId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || lockId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/editlock".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(lockId)))
      queryParams.put("lockId", String.valueOf(lockId));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (RemoveEditLockResponse) ApiInvoker.deserialize(response, "", RemoveEditLockResponse.class);
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
  public GetTagsResponse GetDocumentTags (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/tags".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetTagsResponse) ApiInvoker.deserialize(response, "", GetTagsResponse.class);
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
  public SetTagsResponse SetDocumentTags (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/tags".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SetTagsResponse) ApiInvoker.deserialize(response, "", SetTagsResponse.class);
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
  public RemoveTagsResponse RemoveDocumentTags (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/doc/{userId}/files/{fileId}/tags".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (RemoveTagsResponse) ApiInvoker.deserialize(response, "", RemoveTagsResponse.class);
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

