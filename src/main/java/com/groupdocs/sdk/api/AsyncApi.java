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
import com.groupdocs.sdk.model.GetJobResponse;
import com.groupdocs.sdk.model.JobInfo;
import com.groupdocs.sdk.model.GetJobDocumentsResponse;
import com.groupdocs.sdk.model.AddJobDocumentResponse;
import com.groupdocs.sdk.model.GetJobResourcesResponse;
import com.groupdocs.sdk.model.ConvertResponse;
import com.groupdocs.sdk.model.DeleteResponse;
import com.groupdocs.sdk.model.CreateJobResponse;
import com.groupdocs.sdk.model.UpdateJobResponse;
import com.groupdocs.sdk.model.DeleteResult;
import com.groupdocs.sdk.model.GetJobsDocumentsResponse;
import com.groupdocs.sdk.model.GetJobsResponse;
import java.util.*;

public class AsyncApi {
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

  public GetJobResponse GetJob (String userId, String jobId) throws ApiException {
    // verify required params are set
    if(userId == null || jobId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/async/{userId}/jobs/{jobId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetJobResponse) ApiInvoker.deserialize(response, "", GetJobResponse.class);
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
  public GetJobResponse GetJobJson (String userId, String jobId) throws ApiException {
    // verify required params are set
    if(userId == null || jobId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/async/{userId}/jobs/{jobId}?format=json".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetJobResponse) ApiInvoker.deserialize(response, "", GetJobResponse.class);
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
  public GetJobResourcesResponse GetJobResources (String userId, String statusIds, String actions, String excludedActions) throws ApiException {
    // verify required params are set
    if(userId == null || statusIds == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/async/{userId}/jobs/resources?statusIds={statusIds}&actions={actions}&excluded_actions={excludedActions}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(statusIds)))
      queryParams.put("statusIds", String.valueOf(statusIds));
    if(!"null".equals(String.valueOf(actions)))
      queryParams.put("actions", String.valueOf(actions));
    if(!"null".equals(String.valueOf(excludedActions)))
      queryParams.put("excluded_actions", String.valueOf(excludedActions));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetJobResourcesResponse) ApiInvoker.deserialize(response, "", GetJobResourcesResponse.class);
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
  public GetJobDocumentsResponse GetJobDocuments (String userId, String jobId, String format) throws ApiException {
    // verify required params are set
    if(userId == null || jobId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/async/{userId}/jobs/{jobId}/documents?format={format}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(format)))
      queryParams.put("format", String.valueOf(format));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetJobDocumentsResponse) ApiInvoker.deserialize(response, "", GetJobDocumentsResponse.class);
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
  public CreateJobResponse CreateJob (String userId, JobInfo body) throws ApiException {
    // verify required params are set
    if(userId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/async/{userId}/jobs".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (CreateJobResponse) ApiInvoker.deserialize(response, "", CreateJobResponse.class);
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
  public DeleteResult DeleteJob (String userId, String jobGuid) throws ApiException {
    // verify required params are set
    if(userId == null || jobGuid == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/async/{userId}/jobs/{jobGuid}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobGuid" + "}", String.valueOf(jobGuid));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (DeleteResult) ApiInvoker.deserialize(response, "", DeleteResult.class);
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
  public AddJobDocumentResponse AddJobDocument (String userId, String jobId, String fileId, Boolean checkOwnership, String formats) throws ApiException {
    // verify required params are set
    if(userId == null || jobId == null || fileId == null || checkOwnership == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/async/{userId}/jobs/{jobId}/files/{fileId}?check_ownership={checkOwnership}&out_formats={formats}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(checkOwnership)))
      queryParams.put("check_ownership", String.valueOf(checkOwnership));
    if(!"null".equals(String.valueOf(formats)))
      queryParams.put("out_formats", String.valueOf(formats));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (AddJobDocumentResponse) ApiInvoker.deserialize(response, "", AddJobDocumentResponse.class);
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
  public DeleteResponse DeleteJobDocument (String userId, String jobGuid, String documentId) throws ApiException {
    // verify required params are set
    if(userId == null || jobGuid == null || documentId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/async/{userId}/jobs/{jobGuid}/documents/{documentId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobGuid" + "}", String.valueOf(jobGuid)).replace("{" + "documentId" + "}", String.valueOf(documentId));

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
  public AddJobDocumentResponse AddJobDocumentUrl (String userId, String jobId, String absoluteUrl, String formats) throws ApiException {
    // verify required params are set
    if(userId == null || jobId == null || absoluteUrl == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/async/{userId}/jobs/{jobId}/urls?absolute_url={absoluteUrl}&out_formats={formats}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(absoluteUrl)))
      queryParams.put("absolute_url", String.valueOf(absoluteUrl));
    if(!"null".equals(String.valueOf(formats)))
      queryParams.put("out_formats", String.valueOf(formats));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (AddJobDocumentResponse) ApiInvoker.deserialize(response, "", AddJobDocumentResponse.class);
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
  public UpdateJobResponse UpdateJob (String userId, String jobId, JobInfo body) throws ApiException {
    // verify required params are set
    if(userId == null || jobId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/async/{userId}/jobs/{jobId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (UpdateJobResponse) ApiInvoker.deserialize(response, "", UpdateJobResponse.class);
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
  public GetJobsResponse GetJobs (String userId, String pageIndex, String pageSize, String date, String statusIds, String actions, String excludedActions) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/async/{userId}/jobs?page={pageIndex}&count={pageSize}&date={date}&statusIds={statusIds}&actions={actions}&excluded_actions={excludedActions}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(pageIndex)))
      queryParams.put("page", String.valueOf(pageIndex));
    if(!"null".equals(String.valueOf(pageSize)))
      queryParams.put("count", String.valueOf(pageSize));
    if(!"null".equals(String.valueOf(date)))
      queryParams.put("date", String.valueOf(date));
    if(!"null".equals(String.valueOf(statusIds)))
      queryParams.put("statusIds", String.valueOf(statusIds));
    if(!"null".equals(String.valueOf(actions)))
      queryParams.put("actions", String.valueOf(actions));
    if(!"null".equals(String.valueOf(excludedActions)))
      queryParams.put("excluded_actions", String.valueOf(excludedActions));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetJobsResponse) ApiInvoker.deserialize(response, "", GetJobsResponse.class);
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
  public GetJobsDocumentsResponse GetJobsDocuments (String userId, String pageIndex, String pageSize, String actions, String excludedActions, String orderBy, Boolean orderAsc) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/async/{userId}/jobs/documents?page={pageIndex}&count={pageSize}&actions={actions}&excluded_actions={excludedActions}&order_by={orderBy}&order_asc={orderAsc}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(pageIndex)))
      queryParams.put("page", String.valueOf(pageIndex));
    if(!"null".equals(String.valueOf(pageSize)))
      queryParams.put("count", String.valueOf(pageSize));
    if(!"null".equals(String.valueOf(actions)))
      queryParams.put("actions", String.valueOf(actions));
    if(!"null".equals(String.valueOf(excludedActions)))
      queryParams.put("excluded_actions", String.valueOf(excludedActions));
    if(!"null".equals(String.valueOf(orderBy)))
      queryParams.put("order_by", String.valueOf(orderBy));
    if(!"null".equals(String.valueOf(orderAsc)))
      queryParams.put("order_asc", String.valueOf(orderAsc));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetJobsDocumentsResponse) ApiInvoker.deserialize(response, "", GetJobsDocumentsResponse.class);
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
  public ConvertResponse Convert (String userId, String fileId, String targetType, String emailResults, String description, Boolean printScript, String callbackUrl, Boolean checkDocumentOwnership) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/async/{userId}/files/{fileId}?new_type={targetType}&email_results={emailResults}&new_description={description}&print_script={printScript}&callback={callbackUrl}&checkDocumentOwnership={checkDocumentOwnership}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(targetType)))
      queryParams.put("new_type", String.valueOf(targetType));
    if(!"null".equals(String.valueOf(emailResults)))
      queryParams.put("email_results", String.valueOf(emailResults));
    if(!"null".equals(String.valueOf(description)))
      queryParams.put("new_description", String.valueOf(description));
    if(!"null".equals(String.valueOf(printScript)))
      queryParams.put("print_script", String.valueOf(printScript));
    if(!"null".equals(String.valueOf(callbackUrl)))
      queryParams.put("callback", String.valueOf(callbackUrl));
    if(!"null".equals(String.valueOf(checkDocumentOwnership)))
      queryParams.put("checkDocumentOwnership", String.valueOf(checkDocumentOwnership));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (ConvertResponse) ApiInvoker.deserialize(response, "", ConvertResponse.class);
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

