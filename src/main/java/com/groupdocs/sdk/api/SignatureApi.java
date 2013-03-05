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
import com.groupdocs.sdk.model.SignatureEnvelopeResponse;
import com.groupdocs.sdk.model.SignatureStatusResponse;
import com.groupdocs.sdk.model.SignatureContactResponse;
import com.groupdocs.sdk.model.SignatureRolesResponse;
import com.groupdocs.sdk.model.SignatureEnvelopeFieldsResponse;
import com.groupdocs.sdk.model.SignatureFormDocumentsResponse;
import com.groupdocs.sdk.model.SignatureEnvelopeRecipientResponse;
import com.groupdocs.sdk.model.SignatureFormResponse;
import com.groupdocs.sdk.model.SignatureEnvelopeResourcesResponse;
import com.groupdocs.sdk.model.SignatureContactSettings;
import com.groupdocs.sdk.model.SignatureTemplatesResponse;
import com.groupdocs.sdk.model.SignatureTemplateAssignFieldSettings;
import com.groupdocs.sdk.model.SignatureFieldsResponse;
import com.groupdocs.sdk.model.SignatureEnvelopeDocumentsResponse;
import com.groupdocs.sdk.model.SignatureTemplateFieldsResponse;
import com.groupdocs.sdk.model.SignatureEnvelopeFieldResponse;
import com.groupdocs.sdk.model.SignaturePredefinedListSettings;
import com.groupdocs.sdk.model.SignatureContactsResponse;
import com.groupdocs.sdk.model.SignatureEnvelopeSettings;
import com.groupdocs.sdk.model.SignatureFormFieldLocationSettings;
import com.groupdocs.sdk.model.SignatureFormsResponse;
import com.groupdocs.sdk.model.SignatureSignatureSettings;
import com.groupdocs.sdk.model.SignatureTemplateDocumentResponse;
import com.groupdocs.sdk.model.SignatureTemplateFieldSettings;
import com.groupdocs.sdk.model.SignatureFormDocumentResponse;
import com.groupdocs.sdk.model.SignatureEnvelopeFieldSettings;
import com.groupdocs.sdk.model.SignatureFormSettings;
import com.groupdocs.sdk.model.SignatureFormFieldSettings;
import com.groupdocs.sdk.model.SignatureFormResourcesResponse;
import com.groupdocs.sdk.model.SignatureTemplateSettings;
import com.groupdocs.sdk.model.SignatureContactsImportResponse;
import com.groupdocs.sdk.model.SignatureFormFieldResponse;
import com.groupdocs.sdk.model.SignatureSignDocumentsResponse;
import com.groupdocs.sdk.model.SignatureTemplateResourcesResponse;
import com.groupdocs.sdk.model.SignatureTemplateDocumentsResponse;
import com.groupdocs.sdk.model.SignatureEnvelopeFieldLocationSettings;
import com.groupdocs.sdk.model.SignatureEnvelopeRecipientsResponse;
import com.groupdocs.sdk.model.SignatureSignatureResponse;
import com.groupdocs.sdk.model.SignatureFieldResponse;
import com.groupdocs.sdk.model.SignatureTemplateFieldResponse;
import com.groupdocs.sdk.model.SignatureTemplateFieldLocationSettings;
import com.groupdocs.sdk.model.SignatureEnvelopeAssignFieldSettings;
import com.groupdocs.sdk.model.SignatureEnvelopesResponse;
import com.groupdocs.sdk.model.SignatureFormFieldsResponse;
import com.groupdocs.sdk.model.SignatureEnvelopeDocumentResponse;
import com.groupdocs.sdk.model.SignatureFieldSettings;
import com.groupdocs.sdk.model.SignaturePredefinedListResponse;
import com.groupdocs.sdk.model.SignatureSignDocumentSettings;
import com.groupdocs.sdk.model.SignatureSignaturesResponse;
import com.groupdocs.sdk.model.SignaturePredefinedListsResponse;
import com.groupdocs.sdk.model.SignatureEnvelopeAuditLogsResponse;
import com.groupdocs.sdk.model.SignatureTemplateResponse;
import com.groupdocs.sdk.model.SignatureTemplateRecipientsResponse;
import java.util.*;

public class SignatureApi {
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

  public SignatureTemplateResourcesResponse GetSignatureTemplateResources (String userId) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/resources".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateResourcesResponse) ApiInvoker.deserialize(response, "", SignatureTemplateResourcesResponse.class);
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
  public SignatureFieldsResponse GetFieldsList (String userId, String fieldId) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/fields?id={fieldId}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(fieldId)))
      queryParams.put("id", String.valueOf(fieldId));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureFieldsResponse) ApiInvoker.deserialize(response, "", SignatureFieldsResponse.class);
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
  public SignatureFieldResponse CreateSignatureField (String userId, SignatureFieldSettings body) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/field".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureFieldResponse) ApiInvoker.deserialize(response, "", SignatureFieldResponse.class);
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
  public SignatureFieldResponse ModifySignatureField (String userId, String fieldId, SignatureFieldSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/fields/{fieldId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureFieldResponse) ApiInvoker.deserialize(response, "", SignatureFieldResponse.class);
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
  public SignatureStatusResponse DeleteSignatureField (String userId, String fieldId) throws ApiException {
    // verify required params are set
    if(userId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/fields/{fieldId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureContactsResponse GetContacts (String userId, String page, String firstName, String lastName, String email, String records) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/contacts?firstName={firstName}&lastName={lastName}&email={email}&records={count}&page={page}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(page)))
      queryParams.put("page", String.valueOf(page));
    if(!"null".equals(String.valueOf(firstName)))
      queryParams.put("firstName", String.valueOf(firstName));
    if(!"null".equals(String.valueOf(lastName)))
      queryParams.put("lastName", String.valueOf(lastName));
    if(!"null".equals(String.valueOf(email)))
      queryParams.put("email", String.valueOf(email));
    if(!"null".equals(String.valueOf(records)))
      queryParams.put("records", String.valueOf(records));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureContactsResponse) ApiInvoker.deserialize(response, "", SignatureContactsResponse.class);
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
  public SignatureContactResponse AddContact (String userId, SignatureContactSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/contact".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureContactResponse) ApiInvoker.deserialize(response, "", SignatureContactResponse.class);
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
  public SignatureContactResponse ModifyContact (String userId, String contactId, SignatureContactSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || contactId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/contacts/{contactId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "contactId" + "}", String.valueOf(contactId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureContactResponse) ApiInvoker.deserialize(response, "", SignatureContactResponse.class);
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
  public SignatureContactResponse DeleteContact (String userId, String contactId) throws ApiException {
    // verify required params are set
    if(userId == null || contactId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/contacts/{contactId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "contactId" + "}", String.valueOf(contactId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureContactResponse) ApiInvoker.deserialize(response, "", SignatureContactResponse.class);
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
  public SignatureContactsImportResponse ImportContacts (String userId, List<SignatureContactSettings> body) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/contacts".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureContactsImportResponse) ApiInvoker.deserialize(response, "", SignatureContactsImportResponse.class);
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
  public SignaturePredefinedListsResponse GetSignaturePredefinedLists (String userId) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/lists".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignaturePredefinedListsResponse) ApiInvoker.deserialize(response, "", SignaturePredefinedListsResponse.class);
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
  public SignaturePredefinedListResponse AddPredefinedList (String userId, SignaturePredefinedListSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || body == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/list".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignaturePredefinedListResponse) ApiInvoker.deserialize(response, "", SignaturePredefinedListResponse.class);
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
  public SignaturePredefinedListResponse DeletePredefinedList (String userId, String listId) throws ApiException {
    // verify required params are set
    if(userId == null || listId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/lists/{listId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "listId" + "}", String.valueOf(listId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignaturePredefinedListResponse) ApiInvoker.deserialize(response, "", SignaturePredefinedListResponse.class);
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
  public SignatureRolesResponse GetRolesList (String userId, String id) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/roles?id={roleId}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(id)))
      queryParams.put("id", String.valueOf(id));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureRolesResponse) ApiInvoker.deserialize(response, "", SignatureRolesResponse.class);
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
  public SignatureSignatureResponse CreateSignature (String userId, String name, SignatureSignatureSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || name == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/signature?name={name}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(name)))
      queryParams.put("name", String.valueOf(name));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureSignatureResponse) ApiInvoker.deserialize(response, "", SignatureSignatureResponse.class);
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
  public SignatureStatusResponse DeleteSignature (String userId, String signatureId) throws ApiException {
    // verify required params are set
    if(userId == null || signatureId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/signatures/{signatureId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "signatureId" + "}", String.valueOf(signatureId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureSignaturesResponse GetSignatures (String userId, Integer page, String name, Integer records) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/signatures?records={count}&page={page}&name={name}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(page)))
      queryParams.put("page", String.valueOf(page));
    if(!"null".equals(String.valueOf(name)))
      queryParams.put("name", String.valueOf(name));
    if(!"null".equals(String.valueOf(records)))
      queryParams.put("records", String.valueOf(records));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureSignaturesResponse) ApiInvoker.deserialize(response, "", SignatureSignaturesResponse.class);
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
  public SignatureTemplatesResponse GetSignatureTemplates (String userId, String page, String documentGuid, String recipientName, String name, String records) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates?records={count}&page={page}&documentGuid={documentGuid}&recipientName={recipientName}&name={name}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(page)))
      queryParams.put("page", String.valueOf(page));
    if(!"null".equals(String.valueOf(documentGuid)))
      queryParams.put("documentGuid", String.valueOf(documentGuid));
    if(!"null".equals(String.valueOf(recipientName)))
      queryParams.put("recipientName", String.valueOf(recipientName));
    if(!"null".equals(String.valueOf(name)))
      queryParams.put("name", String.valueOf(name));
    if(!"null".equals(String.valueOf(records)))
      queryParams.put("records", String.valueOf(records));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureTemplatesResponse) ApiInvoker.deserialize(response, "", SignatureTemplatesResponse.class);
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
  public SignatureTemplateResponse GetSignatureTemplate (String userId, String templateId) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateResponse) ApiInvoker.deserialize(response, "", SignatureTemplateResponse.class);
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
  public SignatureTemplateResponse CreateSignatureTemplate (String userId, String name, String templateId, SignatureTemplateSettings body, String envelopetId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopetId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/template?name={name}&templateId={templateId}&envelopeId={envelopeId}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(name)))
      queryParams.put("name", String.valueOf(name));
    if(!"null".equals(String.valueOf(templateId)))
      queryParams.put("templateId", String.valueOf(templateId));
    if(!"null".equals(String.valueOf(envelopetId)))
      queryParams.put("envelopetId", String.valueOf(envelopetId));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateResponse) ApiInvoker.deserialize(response, "", SignatureTemplateResponse.class);
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
  public SignatureTemplateResponse ModifySignatureTemplate (String userId, String templateId, SignatureTemplateSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateResponse) ApiInvoker.deserialize(response, "", SignatureTemplateResponse.class);
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
  public SignatureTemplateResponse RenameSignatureTemplate (String userId, String templateId, String name) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null || name == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}?name={name}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(name)))
      queryParams.put("name", String.valueOf(name));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateResponse) ApiInvoker.deserialize(response, "", SignatureTemplateResponse.class);
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
  public SignatureStatusResponse DeleteSignatureTemplate (String userId, String templateId) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureTemplateResponse AddSignatureTemplateRecipient (String userId, String templateId, String nickname, String roleId, String order) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null || nickname == null || roleId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/recipient?nickname={nickname}&role={roleId}&order={order}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(nickname)))
      queryParams.put("nickname", String.valueOf(nickname));
    if(!"null".equals(String.valueOf(roleId)))
      queryParams.put("role", String.valueOf(roleId));
    if(!"null".equals(String.valueOf(order)))
      queryParams.put("order", String.valueOf(order));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateResponse) ApiInvoker.deserialize(response, "", SignatureTemplateResponse.class);
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
  public SignatureTemplateRecipientsResponse GetSignatureTemplateRecipients (String userId, String templateId) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/recipients".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateRecipientsResponse) ApiInvoker.deserialize(response, "", SignatureTemplateRecipientsResponse.class);
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
  public SignatureStatusResponse DeleteSignatureTemplateRecipient (String userId, String templateId, String recipientId) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null || recipientId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/recipients/{recipientId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureTemplateResponse ModifySignatureTemplateRecipient (String userId, String templateId, String recipientId, String nickname, String roleId, String order) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null || recipientId == null || nickname == null || roleId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/recipient/{recipientId}?nickname={nickname}&role={roleId}&order={order}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(nickname)))
      queryParams.put("nickname", String.valueOf(nickname));
    if(!"null".equals(String.valueOf(roleId)))
      queryParams.put("role", String.valueOf(roleId));
    if(!"null".equals(String.valueOf(order)))
      queryParams.put("order", String.valueOf(order));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateResponse) ApiInvoker.deserialize(response, "", SignatureTemplateResponse.class);
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
  public SignatureTemplateDocumentResponse AddSignatureTemplateDocument (String userId, String templateId, String documentId, String order) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null || documentId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/document/{documentId}?order={order}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "documentId" + "}", String.valueOf(documentId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(order)))
      queryParams.put("order", String.valueOf(order));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateDocumentResponse) ApiInvoker.deserialize(response, "", SignatureTemplateDocumentResponse.class);
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
  public SignatureTemplateDocumentsResponse GetSignatureTemplateDocuments (String userId, String templateId) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/documents".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateDocumentsResponse) ApiInvoker.deserialize(response, "", SignatureTemplateDocumentsResponse.class);
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
  public SignatureStatusResponse DeleteSignatureTemplateDocument (String userId, String templateId, String documentId) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null || documentId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/documents/{documentId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "documentId" + "}", String.valueOf(documentId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureTemplateFieldResponse AddSignatureTemplateField (String userId, String templateId, String documentId, String recipientId, String fieldId, SignatureTemplateFieldSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null || documentId == null || recipientId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/documents/{documentId}/recipient/{recipientId}/field/{fieldId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateFieldResponse) ApiInvoker.deserialize(response, "", SignatureTemplateFieldResponse.class);
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
  public SignatureTemplateFieldResponse AssignSignatureTemplateField (String userId, String templateId, String documentId, String fieldId, SignatureTemplateAssignFieldSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null || documentId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/documents/{documentId}/field/{fieldId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateFieldResponse) ApiInvoker.deserialize(response, "", SignatureTemplateFieldResponse.class);
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
  public SignatureTemplateFieldResponse ModifySignatureTemplateField (String userId, String templateId, String documentId, String fieldId, SignatureTemplateFieldSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null || documentId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/documents/{documentId}/field/{fieldId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateFieldResponse) ApiInvoker.deserialize(response, "", SignatureTemplateFieldResponse.class);
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
  public SignatureStatusResponse DeleteSignatureTemplateFieldLocation (String userId, String templateId, String fieldId, String locationId) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null || fieldId == null || locationId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/fields/{fieldId}/locations/{locationId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId)).replace("{" + "locationId" + "}", String.valueOf(locationId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureTemplateFieldResponse ModifySignatureTemplateFieldLocation (String userId, String templateId, String documentId, String recipientId, String fieldId, String locationId, SignatureTemplateFieldLocationSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null || documentId == null || recipientId == null || fieldId == null || locationId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/documents/{documentId}/recipient/{recipientId}/fields/{fieldId}/locations/{locationId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId)).replace("{" + "locationId" + "}", String.valueOf(locationId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateFieldResponse) ApiInvoker.deserialize(response, "", SignatureTemplateFieldResponse.class);
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
  public SignatureTemplateFieldsResponse GetSignatureTemplateFields (String userId, String templateId, String documentId, String recipientId) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null || documentId == null || recipientId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/fields?document={documentId}&recipient={recipientId}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(documentId)))
      queryParams.put("document", String.valueOf(documentId));
    if(!"null".equals(String.valueOf(recipientId)))
      queryParams.put("recipient", String.valueOf(recipientId));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateFieldsResponse) ApiInvoker.deserialize(response, "", SignatureTemplateFieldsResponse.class);
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
  public SignatureTemplateResponse DeleteSignatureTemplateField (String userId, String templateId, String fieldId) throws ApiException {
    // verify required params are set
    if(userId == null || templateId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/templates/{templateId}/fields/{fieldId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureTemplateResponse) ApiInvoker.deserialize(response, "", SignatureTemplateResponse.class);
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
  public SignatureStatusResponse RestartExpiredSignatureEnvelope (String userId, String envelopeId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/restart".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureStatusResponse SignatureEnvelopeSend (String userId, String envelopeId, FileStream body) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/send".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureStatusResponse SignEnvelope (String userId, String envelopeId, String recipientId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || recipientId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipient/{recipientId}/sign".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureEnvelopesResponse GetSignatureEnvelopes (String userId, String statusId, Integer page, String date, String name, Integer records, String document, String recipient) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes?statusId={statusId}&records={count}&page={page}&document={originalDocumentMD5}&recipient={recipientEmail}&date={date}&name={name}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(statusId)))
      queryParams.put("statusId", String.valueOf(statusId));
    if(!"null".equals(String.valueOf(page)))
      queryParams.put("page", String.valueOf(page));
    if(!"null".equals(String.valueOf(date)))
      queryParams.put("date", String.valueOf(date));
    if(!"null".equals(String.valueOf(name)))
      queryParams.put("name", String.valueOf(name));
    if(!"null".equals(String.valueOf(records)))
      queryParams.put("records", String.valueOf(records));
    if(!"null".equals(String.valueOf(document)))
      queryParams.put("document", String.valueOf(document));
    if(!"null".equals(String.valueOf(recipient)))
      queryParams.put("recipient", String.valueOf(recipient));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopesResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopesResponse.class);
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
  public SignatureEnvelopeResourcesResponse GetSignatureEnvelopeResources (String userId, String statusIds) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/resources?statusIds={statusIds}".replace("*", "");
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
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeResourcesResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeResourcesResponse.class);
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
  public SignatureEnvelopesResponse GetRecipientSignatureEnvelopes (String userId, String statusId, Integer page, Integer records) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/recipient?statusId={statusId}&records={count}&page={page}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(statusId)))
      queryParams.put("statusId", String.valueOf(statusId));
    if(!"null".equals(String.valueOf(page)))
      queryParams.put("page", String.valueOf(page));
    if(!"null".equals(String.valueOf(records)))
      queryParams.put("records", String.valueOf(records));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopesResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopesResponse.class);
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
  public SignatureStatusResponse ArchiveSignatureForm (String userId, String formId) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/archive".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureStatusResponse CompleteSignatureForm (String userId, String formId) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/complete".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureFormResponse CreateSignatureForm (String userId, String name, String templateId, Integer assemblyId, SignatureFormSettings body) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/form?name={name}&templateId={templateId}&assemblyId={assemblyId}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(name)))
      queryParams.put("name", String.valueOf(name));
    if(!"null".equals(String.valueOf(templateId)))
      queryParams.put("templateId", String.valueOf(templateId));
    if(!"null".equals(String.valueOf(assemblyId)))
      queryParams.put("assemblyId", String.valueOf(assemblyId));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureFormResponse) ApiInvoker.deserialize(response, "", SignatureFormResponse.class);
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
  public SignatureStatusResponse DeleteSignatureForm (String userId, String formId) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureFormDocumentResponse AddSignatureFormDocument (String userId, String formId, String documentId, Integer order) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null || documentId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/document/{documentId}?order={order}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "documentId" + "}", String.valueOf(documentId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(order)))
      queryParams.put("order", String.valueOf(order));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureFormDocumentResponse) ApiInvoker.deserialize(response, "", SignatureFormDocumentResponse.class);
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
  public SignatureStatusResponse DeleteSignatureFormDocument (String userId, String formId, String documentId) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null || documentId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/documents/{documentId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "documentId" + "}", String.valueOf(documentId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureFormDocumentsResponse GetSignatureFormDocuments (String userId, String formId) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/documents".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureFormDocumentsResponse) ApiInvoker.deserialize(response, "", SignatureFormDocumentsResponse.class);
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
  public SignatureFormFieldResponse AddSignatureFormField (String userId, String formId, String documentId, String fieldId, SignatureFormFieldSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null || documentId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/documents/{documentId}/field/{fieldId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureFormFieldResponse) ApiInvoker.deserialize(response, "", SignatureFormFieldResponse.class);
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
  public SignatureFormFieldResponse ModifySignatureFormFieldLocation (String userId, String formId, String documentId, String fieldId, String locationId, SignatureFormFieldLocationSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null || documentId == null || fieldId == null || locationId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/documents/{documentId}/fields/{fieldId}/locations/{locationId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId)).replace("{" + "locationId" + "}", String.valueOf(locationId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureFormFieldResponse) ApiInvoker.deserialize(response, "", SignatureFormFieldResponse.class);
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
  public SignatureStatusResponse DeleteSignatureFormFieldLocation (String userId, String formId, String fieldId, String locationId) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null || fieldId == null || locationId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/fields/{fieldId}/locations/{locationId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId)).replace("{" + "locationId" + "}", String.valueOf(locationId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureFormFieldResponse ModifySignatureFormField (String userId, String formId, String documentId, String fieldId, SignatureFormFieldSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null || documentId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/documents/{documentId}/field/{fieldId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureFormFieldResponse) ApiInvoker.deserialize(response, "", SignatureFormFieldResponse.class);
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
  public SignatureStatusResponse DeleteSignatureFormField (String userId, String formId, String fieldId) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/fields/{fieldId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureFormFieldsResponse GetSignatureFormFields (String userId, String formId, String documentId) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null || documentId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/documents/{documentId}/fields".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "documentId" + "}", String.valueOf(documentId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureFormFieldsResponse) ApiInvoker.deserialize(response, "", SignatureFormFieldsResponse.class);
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
  public SignatureFormResponse GetSignatureForm (String userId, String formId) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureFormResponse) ApiInvoker.deserialize(response, "", SignatureFormResponse.class);
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
  public SignatureFormResponse ModifySignatureForm (String userId, String formId, SignatureFormSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureFormResponse) ApiInvoker.deserialize(response, "", SignatureFormResponse.class);
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
  public SignatureStatusResponse PublishSignatureForm (String userId, String formId) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/publish".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureFormResponse RenameSignatureForm (String userId, String formId, String name) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null || name == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}?new_name={name}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(name)))
      queryParams.put("new_name", String.valueOf(name));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureFormResponse) ApiInvoker.deserialize(response, "", SignatureFormResponse.class);
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
  public SignatureFormResponse UpdateSignatureFormFromTemplate (String userId, String formId, String templateId) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null || templateId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/templates/{templateId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "templateId" + "}", String.valueOf(templateId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureFormResponse) ApiInvoker.deserialize(response, "", SignatureFormResponse.class);
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
  public SignatureFormsResponse GetSignatureForms (String userId, String statusId, Integer page, String date, String name, Integer records, String documentId) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms?statusId={statusId}&records={count}&page={page}&document={originalDocumentMD5}&date={date}&name={name}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(statusId)))
      queryParams.put("statusId", String.valueOf(statusId));
    if(!"null".equals(String.valueOf(page)))
      queryParams.put("page", String.valueOf(page));
    if(!"null".equals(String.valueOf(date)))
      queryParams.put("date", String.valueOf(date));
    if(!"null".equals(String.valueOf(name)))
      queryParams.put("name", String.valueOf(name));
    if(!"null".equals(String.valueOf(records)))
      queryParams.put("records", String.valueOf(records));
    if(!"null".equals(String.valueOf(documentId)))
      queryParams.put("documentId", String.valueOf(documentId));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureFormsResponse) ApiInvoker.deserialize(response, "", SignatureFormsResponse.class);
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
  public SignatureFormResourcesResponse GetSignatureFormResources (String userId, String statusIds) throws ApiException {
    // verify required params are set
    if(userId == null || statusIds == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/resources?statusIds={statusIds}".replace("*", "");
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
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureFormResourcesResponse) ApiInvoker.deserialize(response, "", SignatureFormResourcesResponse.class);
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
  public FileStream GetSignedFormDocuments (String userId, String formId) throws ApiException {
    // verify required params are set
    if(userId == null || formId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/forms/{formId}/documents/get".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));

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
  public SignatureStatusResponse AddContactIntegration (String userId, String body) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/integration".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureSignDocumentsResponse SignDocument (String userId, SignatureSignDocumentSettings body) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/sign".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureSignDocumentsResponse) ApiInvoker.deserialize(response, "", SignatureSignDocumentsResponse.class);
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
  public SignatureStatusResponse ArchiveSignatureEnvelope (String userId, String envelopeId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/archive".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureEnvelopeAuditLogsResponse GetEnvelopeAuditLogs (String userId, String envelopeId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/logs".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeAuditLogsResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeAuditLogsResponse.class);
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
  public SignatureEnvelopeResponse CreateSignatureEnvelope (String userId, String name, SignatureEnvelopeSettings body, String templateGuid, Integer envelopeGuid) throws ApiException {
    // verify required params are set
    if(userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelope?name={name}&templateId={templateId}&envelopeId={envelopeId}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(name)))
      queryParams.put("name", String.valueOf(name));
    if(!"null".equals(String.valueOf(templateGuid)))
      queryParams.put("templateGuid", String.valueOf(templateGuid));
    if(!"null".equals(String.valueOf(envelopeGuid)))
      queryParams.put("envelopeGuid", String.valueOf(envelopeGuid));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeResponse.class);
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
  public SignatureStatusResponse DeclineEnvelope (String userId, String envelopeId, String recipientId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || recipientId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipient/{recipientId}/decline".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureStatusResponse DelegateEnvelopeRecipient (String userId, String envelopeId, String recipientId, String recipientEmail, String recipientFirstName, String recipientLastName) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || recipientId == null || recipientEmail == null || recipientFirstName == null || recipientLastName == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipient/{recipientId}/delegate?email={recipientEmail}&firstname={recipientFirstName}&lastname={recipientLastName}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(recipientEmail)))
      queryParams.put("email", String.valueOf(recipientEmail));
    if(!"null".equals(String.valueOf(recipientFirstName)))
      queryParams.put("firstname", String.valueOf(recipientFirstName));
    if(!"null".equals(String.valueOf(recipientLastName)))
      queryParams.put("lastname", String.valueOf(recipientLastName));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureStatusResponse DeleteSignatureEnvelope (String userId, String envelopeId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureEnvelopeDocumentResponse AddSignatureEnvelopeDocument (String userId, String envelopeId, String documentId, Integer order) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || documentId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/document/{documentId}?order={order}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(order)))
      queryParams.put("order", String.valueOf(order));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeDocumentResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeDocumentResponse.class);
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
  public FileStream GetSignedEnvelopeDocument (String userId, String envelopeId, String documentId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || documentId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/document/{documentId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId));

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
  public SignatureStatusResponse DeleteSignatureEnvelopeDocument (String userId, String envelopeId, String documentId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || documentId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/{documentId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureEnvelopeDocumentsResponse GetSignatureEnvelopeDocuments (String userId, String envelopeId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeDocumentsResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeDocumentsResponse.class);
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
  public FileStream GetSignedEnvelopeDocuments (String userId, String envelopeId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/get".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));

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
  public SignatureEnvelopeFieldsResponse AddSignatureEnvelopeField (String userId, String envelopeId, String documentId, String recipientId, String fieldId, SignatureEnvelopeFieldSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || documentId == null || recipientId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/{documentId}/recipient/{recipientId}/field/{fieldId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeFieldsResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeFieldsResponse.class);
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
  public SignatureEnvelopeFieldResponse AssignSignatureEnvelopeField (String userId, String envelopeId, String documentId, String fieldId, SignatureEnvelopeAssignFieldSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || documentId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/{documentId}/field/{fieldId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeFieldResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeFieldResponse.class);
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
  public SignatureEnvelopeFieldResponse FillEnvelopeField (String userId, String envelopeId, String documentId, String recipientId, String fieldId, String signatureId, FileStream body) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || documentId == null || recipientId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/{documentId}/recipient/{recipientId}/field/{fieldId}?signatureId={signatureId}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(signatureId)))
      queryParams.put("signatureId", String.valueOf(signatureId));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeFieldResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeFieldResponse.class);
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
  public SignatureEnvelopeFieldResponse ModifySignatureEnvelopeFieldLocation (String userId, String envelopeId, String documentId, String recipientId, String fieldId, String locationId, SignatureEnvelopeFieldLocationSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || documentId == null || recipientId == null || fieldId == null || locationId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/{documentId}/recipient/{recipientId}/fields/{fieldId}/locations/{locationId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId)).replace("{" + "locationId" + "}", String.valueOf(locationId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeFieldResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeFieldResponse.class);
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
  public SignatureStatusResponse DeleteSignatureEnvelopeFieldLocation (String userId, String envelopeId, String fieldId, String locationId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || fieldId == null || locationId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/fields/{fieldId}/locations/{locationId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId)).replace("{" + "locationId" + "}", String.valueOf(locationId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureEnvelopeFieldResponse ModifySignatureEnvelopeField (String userId, String envelopeId, String documentId, String fieldId, SignatureEnvelopeFieldSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || documentId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/{documentId}/field/{fieldId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeFieldResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeFieldResponse.class);
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
  public SignatureStatusResponse DeleteSignatureEnvelopeField (String userId, String envelopeId, String fieldId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || fieldId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/fields/{fieldId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureEnvelopeFieldsResponse GetSignatureEnvelopeFields (String userId, String envelopeId, String documentId, String recipientId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/fields?document={documentId}&recipient={recipientId}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(documentId)))
      queryParams.put("document", String.valueOf(documentId));
    if(!"null".equals(String.valueOf(recipientId)))
      queryParams.put("recipient", String.valueOf(recipientId));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeFieldsResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeFieldsResponse.class);
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
  public SignatureEnvelopeResponse GetSignatureEnvelope (String userId, String envelopeId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeResponse.class);
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
  public SignatureEnvelopeResponse ModifySignatureEnvelope (String userId, String envelopeId, SignatureEnvelopeSettings body) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, body, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeResponse.class);
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
  public SignatureEnvelopeRecipientResponse AddSignatureEnvelopeRecipient (String userId, String envelopeId, String recipientEmail, String recipientFirstName, String recipientLastName, Integer order, String role) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || recipientEmail == null || recipientFirstName == null || recipientLastName == null || role == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipient?email={recipientEmail}&firstname={recipientFirstName}&lastname={recipientLastName}&role={roleId}&order={order}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(recipientEmail)))
      queryParams.put("email", String.valueOf(recipientEmail));
    if(!"null".equals(String.valueOf(recipientFirstName)))
      queryParams.put("firstname", String.valueOf(recipientFirstName));
    if(!"null".equals(String.valueOf(recipientLastName)))
      queryParams.put("lastname", String.valueOf(recipientLastName));
    if(!"null".equals(String.valueOf(order)))
      queryParams.put("order", String.valueOf(order));
    if(!"null".equals(String.valueOf(role)))
      queryParams.put("role", String.valueOf(role));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "POST", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeRecipientResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeRecipientResponse.class);
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
  public SignatureEnvelopeRecipientResponse ModifySignatureEnvelopeRecipient (String userId, String envelopeId, String recipientId, String recipientEmail, String recipientFirstName, String recipientLastName, Integer order, String role) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || recipientId == null || recipientEmail == null || recipientFirstName == null || recipientLastName == null || role == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipient/{recipientId}?email={recipientEmail}&firstname={recipientFirstName}&lastname={recipientLastName}&role={roleId}&order={order}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(recipientEmail)))
      queryParams.put("email", String.valueOf(recipientEmail));
    if(!"null".equals(String.valueOf(recipientFirstName)))
      queryParams.put("firstname", String.valueOf(recipientFirstName));
    if(!"null".equals(String.valueOf(recipientLastName)))
      queryParams.put("lastname", String.valueOf(recipientLastName));
    if(!"null".equals(String.valueOf(order)))
      queryParams.put("order", String.valueOf(order));
    if(!"null".equals(String.valueOf(role)))
      queryParams.put("role", String.valueOf(role));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeRecipientResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeRecipientResponse.class);
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
  public SignatureStatusResponse DeleteSignatureEnvelopeRecipient (String userId, String envelopeId, String recipientId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || recipientId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipients/{recipientId}".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "DELETE", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureStatusResponse) ApiInvoker.deserialize(response, "", SignatureStatusResponse.class);
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
  public SignatureEnvelopeRecipientsResponse GetSignatureEnvelopeRecipients (String userId, String envelopeId) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipients".replace("*", "");
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "GET", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeRecipientsResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeRecipientsResponse.class);
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
  public SignatureEnvelopeResponse RenameSignatureEnvelope (String userId, String envelopeId, String name) throws ApiException {
    // verify required params are set
    if(userId == null || envelopeId == null || name == null ) {
       throw new ApiException(400, "missing required params");
    }
    String resourcePath = "/signature/{userId}/envelopes/{envelopeId}?name={name}".replace("*", "");
  	int pos = resourcePath.indexOf("?");
  	if(pos > -1){
  		resourcePath = resourcePath.substring(0, pos);
  	}
  	// create path and map variables
    resourcePath = resourcePath.replace("{format}","json").replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(name)))
      queryParams.put("name", String.valueOf(name));
    try {
      String response = apiInvoker.invokeAPI(basePath, resourcePath, "PUT", queryParams, null, headerParams, String.class);
      if(response != null){
        return (SignatureEnvelopeResponse) ApiInvoker.deserialize(response, "", SignatureEnvelopeResponse.class);
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

