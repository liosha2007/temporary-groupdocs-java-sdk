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
import com.groupdocs.sdk.model.TextFieldInfo;
import com.groupdocs.sdk.model.AddCollaboratorResponse;
import com.groupdocs.sdk.model.SaveAnnotationTextResponse;
import com.groupdocs.sdk.model.AnnotationInfo;
import com.groupdocs.sdk.model.GetSharedLinkAccessRightsResponse;
import com.groupdocs.sdk.model.Point;
import com.groupdocs.sdk.model.GetReviewerContactsResponse;
import com.groupdocs.sdk.model.DeleteReplyResponse;
import com.groupdocs.sdk.model.DeleteAnnotationResponse;
import com.groupdocs.sdk.model.CreateAnnotationResponse;
import com.groupdocs.sdk.model.EditReplyResponse;
import com.groupdocs.sdk.model.SetCollaboratorsResponse;
import com.groupdocs.sdk.model.SetSharedLinkAccessRightsResponse;
import com.groupdocs.sdk.model.SetSessionCallbackUrlResponse;
import com.groupdocs.sdk.model.SetAnnotationAccessResponse;
import com.groupdocs.sdk.model.ReviewerContactInfo;
import com.groupdocs.sdk.model.MoveAnnotationResponse;
import com.groupdocs.sdk.model.SetReviewerRightsResponse;
import com.groupdocs.sdk.model.ListAnnotationsResponse;
import com.groupdocs.sdk.model.GetCollaboratorsResponse;
import com.groupdocs.sdk.model.ReviewerInfo;
import com.groupdocs.sdk.model.AnnotationReplyInfo;
import com.groupdocs.sdk.model.ListRepliesResponse;
import com.groupdocs.sdk.model.AddReplyResponse;
import java.util.*;

public class AntApi {
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

  public CreateAnnotationResponse CreateAnnotation (String userId, String fileId, AnnotationInfo body) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/files/{fileId}/annotations".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (CreateAnnotationResponse) ApiInvoker.deserialize(response, "", CreateAnnotationResponse.class);
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
  public ListAnnotationsResponse ListAnnotations (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/files/{fileId}/annotations".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (ListAnnotationsResponse) ApiInvoker.deserialize(response, "", ListAnnotationsResponse.class);
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
  public DeleteAnnotationResponse DeleteAnnotation (String userId, String annotationId) throws ApiException {
    // verify required params are set
    if(userId == null || annotationId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/annotations/{annotationId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (DeleteAnnotationResponse) ApiInvoker.deserialize(response, "", DeleteAnnotationResponse.class);
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
  public AddReplyResponse CreateAnnotationReply (String userId, String annotationId, AnnotationReplyInfo body) throws ApiException {
    // verify required params are set
    if(userId == null || annotationId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/annotations/{annotationId}/replies".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (AddReplyResponse) ApiInvoker.deserialize(response, "", AddReplyResponse.class);
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
  public EditReplyResponse EditAnnotationReply (String userId, String replyGuid, String body) throws ApiException {
    // verify required params are set
    if(userId == null || replyGuid == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/replies/{replyGuid}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "replyGuid" + "}", String.valueOf(replyGuid));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (EditReplyResponse) ApiInvoker.deserialize(response, "", EditReplyResponse.class);
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
  public DeleteReplyResponse DeleteAnnotationReply (String userId, String replyGuid) throws ApiException {
    // verify required params are set
    if(userId == null || replyGuid == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/replies/{replyGuid}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "replyGuid" + "}", String.valueOf(replyGuid));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (DeleteReplyResponse) ApiInvoker.deserialize(response, "", DeleteReplyResponse.class);
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
  public ListRepliesResponse ListAnnotationReplies (String userId, String annotationId, Long after) throws ApiException {
    // verify required params are set
    if(userId == null || annotationId == null || after == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/annotations/{annotationId}/replies?after={after}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(after)))
      queryParams.put("after", String.valueOf(after));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (ListRepliesResponse) ApiInvoker.deserialize(response, "", ListRepliesResponse.class);
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
  public SetCollaboratorsResponse SetAnnotationCollaborators (String userId, String fileId, String version, List<String> body) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || version == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/files/{fileId}/version/{version}/collaborators".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "version" + "}", String.valueOf(version));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SetCollaboratorsResponse) ApiInvoker.deserialize(response, "", SetCollaboratorsResponse.class);
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
  public GetCollaboratorsResponse GetAnnotationCollaborators (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/files/{fileId}/collaborators".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetCollaboratorsResponse) ApiInvoker.deserialize(response, "", GetCollaboratorsResponse.class);
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
  public AddCollaboratorResponse AddAnnotationCollaborator (String userId, String fileId, ReviewerInfo body) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/files/{fileId}/collaborators".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (AddCollaboratorResponse) ApiInvoker.deserialize(response, "", AddCollaboratorResponse.class);
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
  public AddCollaboratorResponse DeleteDocumentReviewer (String userId, String fileId, String reviewerId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || reviewerId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/files/{fileId}/collaborators/{reviewerId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "reviewerId" + "}", String.valueOf(reviewerId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (AddCollaboratorResponse) ApiInvoker.deserialize(response, "", AddCollaboratorResponse.class);
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
  public GetReviewerContactsResponse GetReviewerContacts (String userId) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/contacts".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetReviewerContactsResponse) ApiInvoker.deserialize(response, "", GetReviewerContactsResponse.class);
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
  public GetReviewerContactsResponse SetReviewerContacts (String userId, List<ReviewerContactInfo> body) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/reviewerContacts".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (GetReviewerContactsResponse) ApiInvoker.deserialize(response, "", GetReviewerContactsResponse.class);
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
  public MoveAnnotationResponse MoveAnnotation (String userId, String annotationId, Point body) throws ApiException {
    // verify required params are set
    if(userId == null || annotationId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/annotations/{annotationId}/position".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (MoveAnnotationResponse) ApiInvoker.deserialize(response, "", MoveAnnotationResponse.class);
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
  public SetAnnotationAccessResponse SetAnnotationAccess (String userId, String annotationId, Integer body) throws ApiException {
    // verify required params are set
    if(userId == null || annotationId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/annotations/{annotationId}/annotationAccess".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SetAnnotationAccessResponse) ApiInvoker.deserialize(response, "", SetAnnotationAccessResponse.class);
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
  public MoveAnnotationResponse MoveAnnotationMarker (String userId, String annotationId, Point body) throws ApiException {
    // verify required params are set
    if(userId == null || annotationId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/annotations/{annotationId}/markerPosition".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (MoveAnnotationResponse) ApiInvoker.deserialize(response, "", MoveAnnotationResponse.class);
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
  public SetReviewerRightsResponse SetReviewerRights (String userId, String fileId, List<ReviewerInfo> body) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/files/{fileId}/reviewerRights".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SetReviewerRightsResponse) ApiInvoker.deserialize(response, "", SetReviewerRightsResponse.class);
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
  public GetSharedLinkAccessRightsResponse GetSharedLinkAccessRights (String userId, String fileId) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/files/{fileId}/sharedLinkAccessRights".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (GetSharedLinkAccessRightsResponse) ApiInvoker.deserialize(response, "", GetSharedLinkAccessRightsResponse.class);
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
  public SetSharedLinkAccessRightsResponse SetSharedLinkAccessRights (String userId, String fileId, Integer body) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/files/{fileId}/sharedLinkAccessRights".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SetSharedLinkAccessRightsResponse) ApiInvoker.deserialize(response, "", SetSharedLinkAccessRightsResponse.class);
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
  public SetSessionCallbackUrlResponse SetSessionCallbackUrl (String userId, String fileId, String body) throws ApiException {
    // verify required params are set
    if(userId == null || fileId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/files/{fileId}/sessionCallbackUrl".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SetSessionCallbackUrlResponse) ApiInvoker.deserialize(response, "", SetSessionCallbackUrlResponse.class);
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
  public SaveAnnotationTextResponse SaveTextField (String userId, String annotationId, TextFieldInfo body) throws ApiException {
    // verify required params are set
    if(userId == null || annotationId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/ant/{userId}/annotations/{annotationId}/textFieldInfo".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SaveAnnotationTextResponse) ApiInvoker.deserialize(response, "", SaveAnnotationTextResponse.class);
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

