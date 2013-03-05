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

import static com.github.restdriver.clientdriver.RestClientDriver.giveResponse;
import static com.github.restdriver.clientdriver.RestClientDriver.onRequestTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.regex.Pattern;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.restdriver.clientdriver.ClientDriverRequest;
import com.github.restdriver.clientdriver.ClientDriverRequest.Method;
import com.github.restdriver.clientdriver.ClientDriverResponse;
import com.github.restdriver.clientdriver.ClientDriverRule;

import com.groupdocs.sdk.common.ApiException;
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


public class SignatureApiTest extends AbstractUnitTest {
  
	SignatureApi api;
	
	@Rule
	public ClientDriverRule driver = new ClientDriverRule();
	
	@Before
	public void setUpBefore() throws Exception {
		api = new SignatureApi();
		api.setBasePath(driver.getBaseUrl());
	}

	@Test
	public void testGetSignatureTemplateResources() throws Exception {
		// sample parameters
		String userId = "userId";
		
		String resourcePath = "/signature/{userId}/templates/resources".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureTemplateResources.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateResourcesResponse response = api.GetSignatureTemplateResources(userId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetFieldsList() throws Exception {
		// sample parameters
		String userId = "userId";
		String fieldId = "fieldId";
		
		String resourcePath = "/signature/{userId}/fields".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("id", fieldId);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetFieldsList.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFieldsResponse response = api.GetFieldsList(userId, fieldId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCreateSignatureField() throws Exception {
		// sample parameters
		String userId = "userId";
		SignatureFieldSettings body = getSampleRequest("signature/payload/CreateSignatureField.json", new TypeReference<SignatureFieldSettings>(){});
		
		String resourcePath = "/signature/{userId}/field".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/CreateSignatureField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFieldResponse response = api.CreateSignatureField(userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testModifySignatureField() throws Exception {
		// sample parameters
		String userId = "userId";
		String fieldId = "fieldId";
		SignatureFieldSettings body = getSampleRequest("signature/payload/ModifySignatureField.json", new TypeReference<SignatureFieldSettings>(){});
		
		String resourcePath = "/signature/{userId}/fields/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ModifySignatureField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFieldResponse response = api.ModifySignatureField(userId, fieldId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureField() throws Exception {
		// sample parameters
		String userId = "userId";
		String fieldId = "fieldId";
		
		String resourcePath = "/signature/{userId}/fields/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureField(userId, fieldId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetContacts() throws Exception {
		// sample parameters
		String userId = "userId";
		String page = "page";
		String firstName = "firstName";
		String lastName = "lastName";
		String email = "email";
		String records = "records";
		
		String resourcePath = "/signature/{userId}/contacts".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("page", page);
		mockRequest = mockRequest.withParam("firstName", firstName);
		mockRequest = mockRequest.withParam("lastName", lastName);
		mockRequest = mockRequest.withParam("email", email);
		mockRequest = mockRequest.withParam("records", records);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetContacts.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureContactsResponse response = api.GetContacts(userId, page, firstName, lastName, email, records);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddContact() throws Exception {
		// sample parameters
		String userId = "userId";
		SignatureContactSettings body = getSampleRequest("signature/payload/AddContact.json", new TypeReference<SignatureContactSettings>(){});
		
		String resourcePath = "/signature/{userId}/contact".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/AddContact.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureContactResponse response = api.AddContact(userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testModifyContact() throws Exception {
		// sample parameters
		String userId = "userId";
		String contactId = "contactId";
		SignatureContactSettings body = getSampleRequest("signature/payload/ModifyContact.json", new TypeReference<SignatureContactSettings>(){});
		
		String resourcePath = "/signature/{userId}/contacts/{contactId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "contactId" + "}", String.valueOf(contactId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ModifyContact.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureContactResponse response = api.ModifyContact(userId, contactId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteContact() throws Exception {
		// sample parameters
		String userId = "userId";
		String contactId = "contactId";
		
		String resourcePath = "/signature/{userId}/contacts/{contactId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "contactId" + "}", String.valueOf(contactId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteContact.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureContactResponse response = api.DeleteContact(userId, contactId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testImportContacts() throws Exception {
		// sample parameters
		String userId = "userId";
		List<SignatureContactSettings> body = getSampleRequest("signature/payload/ImportContacts.json", new TypeReference<List<SignatureContactSettings>>(){});
		
		String resourcePath = "/signature/{userId}/contacts".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ImportContacts.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureContactsImportResponse response = api.ImportContacts(userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignaturePredefinedLists() throws Exception {
		// sample parameters
		String userId = "userId";
		
		String resourcePath = "/signature/{userId}/lists".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignaturePredefinedLists.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignaturePredefinedListsResponse response = api.GetSignaturePredefinedLists(userId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddPredefinedList() throws Exception {
		// sample parameters
		String userId = "userId";
		SignaturePredefinedListSettings body = getSampleRequest("signature/payload/AddPredefinedList.json", new TypeReference<SignaturePredefinedListSettings>(){});
		
		String resourcePath = "/signature/{userId}/list".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/AddPredefinedList.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignaturePredefinedListResponse response = api.AddPredefinedList(userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeletePredefinedList() throws Exception {
		// sample parameters
		String userId = "userId";
		String listId = "listId";
		
		String resourcePath = "/signature/{userId}/lists/{listId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "listId" + "}", String.valueOf(listId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeletePredefinedList.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignaturePredefinedListResponse response = api.DeletePredefinedList(userId, listId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetRolesList() throws Exception {
		// sample parameters
		String userId = "userId";
		String id = "id";
		
		String resourcePath = "/signature/{userId}/roles".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("id", id);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetRolesList.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureRolesResponse response = api.GetRolesList(userId, id);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCreateSignature() throws Exception {
		// sample parameters
		String userId = "userId";
		String name = "name";
		SignatureSignatureSettings body = getSampleRequest("signature/payload/CreateSignature.json", new TypeReference<SignatureSignatureSettings>(){});
		
		String resourcePath = "/signature/{userId}/signature".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("name", name);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/CreateSignature.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureSignatureResponse response = api.CreateSignature(userId, name, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignature() throws Exception {
		// sample parameters
		String userId = "userId";
		String signatureId = "signatureId";
		
		String resourcePath = "/signature/{userId}/signatures/{signatureId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "signatureId" + "}", String.valueOf(signatureId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignature.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignature(userId, signatureId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatures() throws Exception {
		// sample parameters
		String userId = "userId";
		Integer page = 0;
		String name = "name";
		Integer records = 0;
		
		String resourcePath = "/signature/{userId}/signatures".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("page", page);
		mockRequest = mockRequest.withParam("name", name);
		mockRequest = mockRequest.withParam("records", records);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatures.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureSignaturesResponse response = api.GetSignatures(userId, page, name, records);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureTemplates() throws Exception {
		// sample parameters
		String userId = "userId";
		String page = "page";
		String documentGuid = "documentGuid";
		String recipientName = "recipientName";
		String name = "name";
		String records = "records";
		
		String resourcePath = "/signature/{userId}/templates".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("page", page);
		mockRequest = mockRequest.withParam("documentGuid", documentGuid);
		mockRequest = mockRequest.withParam("recipientName", recipientName);
		mockRequest = mockRequest.withParam("name", name);
		mockRequest = mockRequest.withParam("records", records);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureTemplates.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplatesResponse response = api.GetSignatureTemplates(userId, page, documentGuid, recipientName, name, records);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureTemplate() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		
		String resourcePath = "/signature/{userId}/templates/{templateId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureTemplate.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateResponse response = api.GetSignatureTemplate(userId, templateId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCreateSignatureTemplate() throws Exception {
		// sample parameters
		String userId = "userId";
		String name = "name";
		String templateId = "templateId";
		String envelopetId = "envelopetId";
		SignatureTemplateSettings body = getSampleRequest("signature/payload/CreateSignatureTemplate.json", new TypeReference<SignatureTemplateSettings>(){});
		
		String resourcePath = "/signature/{userId}/template".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("name", name);
		mockRequest = mockRequest.withParam("templateId", templateId);
		mockRequest = mockRequest.withParam("envelopetId", envelopetId);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/CreateSignatureTemplate.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateResponse response = api.CreateSignatureTemplate(userId, name, templateId, body, envelopetId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testModifySignatureTemplate() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		SignatureTemplateSettings body = getSampleRequest("signature/payload/ModifySignatureTemplate.json", new TypeReference<SignatureTemplateSettings>(){});
		
		String resourcePath = "/signature/{userId}/templates/{templateId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ModifySignatureTemplate.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateResponse response = api.ModifySignatureTemplate(userId, templateId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testRenameSignatureTemplate() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		String name = "name";
		
		String resourcePath = "/signature/{userId}/templates/{templateId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("name", name);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/RenameSignatureTemplate.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateResponse response = api.RenameSignatureTemplate(userId, templateId, name);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureTemplate() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		
		String resourcePath = "/signature/{userId}/templates/{templateId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureTemplate.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureTemplate(userId, templateId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddSignatureTemplateRecipient() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		String nickname = "nickname";
		String roleId = "roleId";
		String order = "order";
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/recipient".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("nickname", nickname);
		mockRequest = mockRequest.withParam("role", roleId);
		mockRequest = mockRequest.withParam("order", order);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/AddSignatureTemplateRecipient.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateResponse response = api.AddSignatureTemplateRecipient(userId, templateId, nickname, roleId, order);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureTemplateRecipients() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/recipients".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureTemplateRecipients.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateRecipientsResponse response = api.GetSignatureTemplateRecipients(userId, templateId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureTemplateRecipient() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		String recipientId = "recipientId";
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/recipients/{recipientId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureTemplateRecipient.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureTemplateRecipient(userId, templateId, recipientId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testModifySignatureTemplateRecipient() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		String recipientId = "recipientId";
		String nickname = "nickname";
		String roleId = "roleId";
		String order = "order";
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/recipient/{recipientId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("nickname", nickname);
		mockRequest = mockRequest.withParam("role", roleId);
		mockRequest = mockRequest.withParam("order", order);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ModifySignatureTemplateRecipient.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateResponse response = api.ModifySignatureTemplateRecipient(userId, templateId, recipientId, nickname, roleId, order);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddSignatureTemplateDocument() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		String documentId = "documentId";
		String order = "order";
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/document/{documentId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "documentId" + "}", String.valueOf(documentId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("order", order);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/AddSignatureTemplateDocument.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateDocumentResponse response = api.AddSignatureTemplateDocument(userId, templateId, documentId, order);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureTemplateDocuments() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/documents".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureTemplateDocuments.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateDocumentsResponse response = api.GetSignatureTemplateDocuments(userId, templateId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureTemplateDocument() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		String documentId = "documentId";
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/documents/{documentId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "documentId" + "}", String.valueOf(documentId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureTemplateDocument.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureTemplateDocument(userId, templateId, documentId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddSignatureTemplateField() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		String documentId = "documentId";
		String recipientId = "recipientId";
		String fieldId = "fieldId";
		SignatureTemplateFieldSettings body = getSampleRequest("signature/payload/AddSignatureTemplateField.json", new TypeReference<SignatureTemplateFieldSettings>(){});
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/documents/{documentId}/recipient/{recipientId}/field/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/AddSignatureTemplateField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateFieldResponse response = api.AddSignatureTemplateField(userId, templateId, documentId, recipientId, fieldId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAssignSignatureTemplateField() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		String documentId = "documentId";
		String fieldId = "fieldId";
		SignatureTemplateAssignFieldSettings body = getSampleRequest("signature/payload/AssignSignatureTemplateField.json", new TypeReference<SignatureTemplateAssignFieldSettings>(){});
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/documents/{documentId}/field/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/AssignSignatureTemplateField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateFieldResponse response = api.AssignSignatureTemplateField(userId, templateId, documentId, fieldId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testModifySignatureTemplateField() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		String documentId = "documentId";
		String fieldId = "fieldId";
		SignatureTemplateFieldSettings body = getSampleRequest("signature/payload/ModifySignatureTemplateField.json", new TypeReference<SignatureTemplateFieldSettings>(){});
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/documents/{documentId}/field/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ModifySignatureTemplateField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateFieldResponse response = api.ModifySignatureTemplateField(userId, templateId, documentId, fieldId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureTemplateFieldLocation() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		String fieldId = "fieldId";
		String locationId = "locationId";
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/fields/{fieldId}/locations/{locationId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId)).replace("{" + "locationId" + "}", String.valueOf(locationId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureTemplateFieldLocation.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureTemplateFieldLocation(userId, templateId, fieldId, locationId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testModifySignatureTemplateFieldLocation() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		String documentId = "documentId";
		String recipientId = "recipientId";
		String fieldId = "fieldId";
		String locationId = "locationId";
		SignatureTemplateFieldLocationSettings body = getSampleRequest("signature/payload/ModifySignatureTemplateFieldLocation.json", new TypeReference<SignatureTemplateFieldLocationSettings>(){});
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/documents/{documentId}/recipient/{recipientId}/fields/{fieldId}/locations/{locationId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId)).replace("{" + "locationId" + "}", String.valueOf(locationId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ModifySignatureTemplateFieldLocation.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateFieldResponse response = api.ModifySignatureTemplateFieldLocation(userId, templateId, documentId, recipientId, fieldId, locationId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureTemplateFields() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		String documentId = "documentId";
		String recipientId = "recipientId";
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/fields".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("document", documentId);
		mockRequest = mockRequest.withParam("recipient", recipientId);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureTemplateFields.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateFieldsResponse response = api.GetSignatureTemplateFields(userId, templateId, documentId, recipientId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureTemplateField() throws Exception {
		// sample parameters
		String userId = "userId";
		String templateId = "templateId";
		String fieldId = "fieldId";
		
		String resourcePath = "/signature/{userId}/templates/{templateId}/fields/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "templateId" + "}", String.valueOf(templateId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureTemplateField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureTemplateResponse response = api.DeleteSignatureTemplateField(userId, templateId, fieldId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testRestartExpiredSignatureEnvelope() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/restart".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/RestartExpiredSignatureEnvelope.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.RestartExpiredSignatureEnvelope(userId, envelopeId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSignatureEnvelopeSend() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		FileStream body = new FileStream(getClass().getClassLoader().getResourceAsStream("test.doc"));
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/send".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", Pattern.compile(".*"));
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/SignatureEnvelopeSend.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.SignatureEnvelopeSend(userId, envelopeId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSignEnvelope() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String recipientId = "recipientId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipient/{recipientId}/sign".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/SignEnvelope.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.SignEnvelope(userId, envelopeId, recipientId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureEnvelopes() throws Exception {
		// sample parameters
		String userId = "userId";
		String statusId = "statusId";
		Integer page = 0;
		String date = "date";
		String name = "name";
		Integer records = 0;
		String document = "document";
		String recipient = "recipient";
		
		String resourcePath = "/signature/{userId}/envelopes".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("statusId", statusId);
		mockRequest = mockRequest.withParam("page", page);
		mockRequest = mockRequest.withParam("date", date);
		mockRequest = mockRequest.withParam("name", name);
		mockRequest = mockRequest.withParam("records", records);
		mockRequest = mockRequest.withParam("document", document);
		mockRequest = mockRequest.withParam("recipient", recipient);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureEnvelopes.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopesResponse response = api.GetSignatureEnvelopes(userId, statusId, page, date, name, records, document, recipient);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureEnvelopeResources() throws Exception {
		// sample parameters
		String userId = "userId";
		String statusIds = "statusIds";
		
		String resourcePath = "/signature/{userId}/envelopes/resources".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("statusIds", statusIds);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureEnvelopeResources.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeResourcesResponse response = api.GetSignatureEnvelopeResources(userId, statusIds);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetRecipientSignatureEnvelopes() throws Exception {
		// sample parameters
		String userId = "userId";
		String statusId = "statusId";
		Integer page = 0;
		Integer records = 0;
		
		String resourcePath = "/signature/{userId}/envelopes/recipient".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("statusId", statusId);
		mockRequest = mockRequest.withParam("page", page);
		mockRequest = mockRequest.withParam("records", records);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetRecipientSignatureEnvelopes.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopesResponse response = api.GetRecipientSignatureEnvelopes(userId, statusId, page, records);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testArchiveSignatureForm() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		
		String resourcePath = "/signature/{userId}/forms/{formId}/archive".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ArchiveSignatureForm.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.ArchiveSignatureForm(userId, formId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCompleteSignatureForm() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		
		String resourcePath = "/signature/{userId}/forms/{formId}/complete".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/CompleteSignatureForm.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.CompleteSignatureForm(userId, formId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCreateSignatureForm() throws Exception {
		// sample parameters
		String userId = "userId";
		String name = "name";
		String templateId = "templateId";
		Integer assemblyId = 0;
		SignatureFormSettings body = getSampleRequest("signature/payload/CreateSignatureForm.json", new TypeReference<SignatureFormSettings>(){});
		
		String resourcePath = "/signature/{userId}/form".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("name", name);
		mockRequest = mockRequest.withParam("templateId", templateId);
		mockRequest = mockRequest.withParam("assemblyId", assemblyId);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/CreateSignatureForm.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFormResponse response = api.CreateSignatureForm(userId, name, templateId, assemblyId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureForm() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		
		String resourcePath = "/signature/{userId}/forms/{formId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureForm.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureForm(userId, formId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddSignatureFormDocument() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		String documentId = "documentId";
		Integer order = 0;
		
		String resourcePath = "/signature/{userId}/forms/{formId}/document/{documentId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "documentId" + "}", String.valueOf(documentId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("order", order);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/AddSignatureFormDocument.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFormDocumentResponse response = api.AddSignatureFormDocument(userId, formId, documentId, order);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureFormDocument() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		String documentId = "documentId";
		
		String resourcePath = "/signature/{userId}/forms/{formId}/documents/{documentId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "documentId" + "}", String.valueOf(documentId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureFormDocument.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureFormDocument(userId, formId, documentId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureFormDocuments() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		
		String resourcePath = "/signature/{userId}/forms/{formId}/documents".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureFormDocuments.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFormDocumentsResponse response = api.GetSignatureFormDocuments(userId, formId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddSignatureFormField() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		String documentId = "documentId";
		String fieldId = "fieldId";
		SignatureFormFieldSettings body = getSampleRequest("signature/payload/AddSignatureFormField.json", new TypeReference<SignatureFormFieldSettings>(){});
		
		String resourcePath = "/signature/{userId}/forms/{formId}/documents/{documentId}/field/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/AddSignatureFormField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFormFieldResponse response = api.AddSignatureFormField(userId, formId, documentId, fieldId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testModifySignatureFormFieldLocation() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		String documentId = "documentId";
		String fieldId = "fieldId";
		String locationId = "locationId";
		SignatureFormFieldLocationSettings body = getSampleRequest("signature/payload/ModifySignatureFormFieldLocation.json", new TypeReference<SignatureFormFieldLocationSettings>(){});
		
		String resourcePath = "/signature/{userId}/forms/{formId}/documents/{documentId}/fields/{fieldId}/locations/{locationId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId)).replace("{" + "locationId" + "}", String.valueOf(locationId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ModifySignatureFormFieldLocation.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFormFieldResponse response = api.ModifySignatureFormFieldLocation(userId, formId, documentId, fieldId, locationId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureFormFieldLocation() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		String fieldId = "fieldId";
		String locationId = "locationId";
		
		String resourcePath = "/signature/{userId}/forms/{formId}/fields/{fieldId}/locations/{locationId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId)).replace("{" + "locationId" + "}", String.valueOf(locationId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureFormFieldLocation.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureFormFieldLocation(userId, formId, fieldId, locationId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testModifySignatureFormField() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		String documentId = "documentId";
		String fieldId = "fieldId";
		SignatureFormFieldSettings body = getSampleRequest("signature/payload/ModifySignatureFormField.json", new TypeReference<SignatureFormFieldSettings>(){});
		
		String resourcePath = "/signature/{userId}/forms/{formId}/documents/{documentId}/field/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ModifySignatureFormField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFormFieldResponse response = api.ModifySignatureFormField(userId, formId, documentId, fieldId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureFormField() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		String fieldId = "fieldId";
		
		String resourcePath = "/signature/{userId}/forms/{formId}/fields/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureFormField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureFormField(userId, formId, fieldId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureFormFields() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		String documentId = "documentId";
		
		String resourcePath = "/signature/{userId}/forms/{formId}/documents/{documentId}/fields".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "documentId" + "}", String.valueOf(documentId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureFormFields.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFormFieldsResponse response = api.GetSignatureFormFields(userId, formId, documentId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureForm() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		
		String resourcePath = "/signature/{userId}/forms/{formId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureForm.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFormResponse response = api.GetSignatureForm(userId, formId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testModifySignatureForm() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		SignatureFormSettings body = getSampleRequest("signature/payload/ModifySignatureForm.json", new TypeReference<SignatureFormSettings>(){});
		
		String resourcePath = "/signature/{userId}/forms/{formId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ModifySignatureForm.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFormResponse response = api.ModifySignatureForm(userId, formId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testPublishSignatureForm() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		
		String resourcePath = "/signature/{userId}/forms/{formId}/publish".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/PublishSignatureForm.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.PublishSignatureForm(userId, formId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testRenameSignatureForm() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		String name = "name";
		
		String resourcePath = "/signature/{userId}/forms/{formId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("new_name", name);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/RenameSignatureForm.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFormResponse response = api.RenameSignatureForm(userId, formId, name);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUpdateSignatureFormFromTemplate() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		String templateId = "templateId";
		
		String resourcePath = "/signature/{userId}/forms/{formId}/templates/{templateId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId)).replace("{" + "templateId" + "}", String.valueOf(templateId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/UpdateSignatureFormFromTemplate.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFormResponse response = api.UpdateSignatureFormFromTemplate(userId, formId, templateId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureForms() throws Exception {
		// sample parameters
		String userId = "userId";
		String statusId = "statusId";
		Integer page = 0;
		String date = "date";
		String name = "name";
		Integer records = 0;
		String documentId = "documentId";
		
		String resourcePath = "/signature/{userId}/forms".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("statusId", statusId);
		mockRequest = mockRequest.withParam("page", page);
		mockRequest = mockRequest.withParam("date", date);
		mockRequest = mockRequest.withParam("name", name);
		mockRequest = mockRequest.withParam("records", records);
		mockRequest = mockRequest.withParam("documentId", documentId);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureForms.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFormsResponse response = api.GetSignatureForms(userId, statusId, page, date, name, records, documentId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureFormResources() throws Exception {
		// sample parameters
		String userId = "userId";
		String statusIds = "statusIds";
		
		String resourcePath = "/signature/{userId}/forms/resources".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("statusIds", statusIds);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureFormResources.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureFormResourcesResponse response = api.GetSignatureFormResources(userId, statusIds);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignedFormDocuments() throws Exception {
		// sample parameters
		String userId = "userId";
		String formId = "formId";
		
		String resourcePath = "/signature/{userId}/forms/{formId}/documents/get".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "formId" + "}", String.valueOf(formId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignedFormDocuments.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			FileStream response = api.GetSignedFormDocuments(userId, formId);
			assertThat(response.getInputStream(), not(nullValue()));
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddContactIntegration() throws Exception {
		// sample parameters
		String userId = "userId";
		String body = "body";
		
		String resourcePath = "/signature/{userId}/integration".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/AddContactIntegration.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.AddContactIntegration(userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSignDocument() throws Exception {
		// sample parameters
		String userId = "userId";
		SignatureSignDocumentSettings body = getSampleRequest("signature/payload/SignDocument.json", new TypeReference<SignatureSignDocumentSettings>(){});
		
		String resourcePath = "/signature/{userId}/sign".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/SignDocument.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureSignDocumentsResponse response = api.SignDocument(userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testArchiveSignatureEnvelope() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/archive".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ArchiveSignatureEnvelope.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.ArchiveSignatureEnvelope(userId, envelopeId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetEnvelopeAuditLogs() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/logs".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetEnvelopeAuditLogs.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeAuditLogsResponse response = api.GetEnvelopeAuditLogs(userId, envelopeId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCreateSignatureEnvelope() throws Exception {
		// sample parameters
		String userId = "userId";
		String name = "name";
		String templateGuid = "templateGuid";
		Integer envelopeGuid = 0;
		SignatureEnvelopeSettings body = getSampleRequest("signature/payload/CreateSignatureEnvelope.json", new TypeReference<SignatureEnvelopeSettings>(){});
		
		String resourcePath = "/signature/{userId}/envelope".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("name", name);
		mockRequest = mockRequest.withParam("templateGuid", templateGuid);
		mockRequest = mockRequest.withParam("envelopeGuid", envelopeGuid);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/CreateSignatureEnvelope.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeResponse response = api.CreateSignatureEnvelope(userId, name, body, templateGuid, envelopeGuid);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeclineEnvelope() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String recipientId = "recipientId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipient/{recipientId}/decline".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeclineEnvelope.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeclineEnvelope(userId, envelopeId, recipientId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDelegateEnvelopeRecipient() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String recipientId = "recipientId";
		String recipientEmail = "recipientEmail";
		String recipientFirstName = "recipientFirstName";
		String recipientLastName = "recipientLastName";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipient/{recipientId}/delegate".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("email", recipientEmail);
		mockRequest = mockRequest.withParam("firstname", recipientFirstName);
		mockRequest = mockRequest.withParam("lastname", recipientLastName);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DelegateEnvelopeRecipient.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DelegateEnvelopeRecipient(userId, envelopeId, recipientId, recipientEmail, recipientFirstName, recipientLastName);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureEnvelope() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureEnvelope.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureEnvelope(userId, envelopeId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddSignatureEnvelopeDocument() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String documentId = "documentId";
		Integer order = 0;
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/document/{documentId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("order", order);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/AddSignatureEnvelopeDocument.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeDocumentResponse response = api.AddSignatureEnvelopeDocument(userId, envelopeId, documentId, order);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignedEnvelopeDocument() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String documentId = "documentId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/document/{documentId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignedEnvelopeDocument.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			FileStream response = api.GetSignedEnvelopeDocument(userId, envelopeId, documentId);
			assertThat(response.getInputStream(), not(nullValue()));
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureEnvelopeDocument() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String documentId = "documentId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/{documentId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureEnvelopeDocument.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureEnvelopeDocument(userId, envelopeId, documentId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureEnvelopeDocuments() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureEnvelopeDocuments.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeDocumentsResponse response = api.GetSignatureEnvelopeDocuments(userId, envelopeId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignedEnvelopeDocuments() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/get".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignedEnvelopeDocuments.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			FileStream response = api.GetSignedEnvelopeDocuments(userId, envelopeId);
			assertThat(response.getInputStream(), not(nullValue()));
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddSignatureEnvelopeField() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String documentId = "documentId";
		String recipientId = "recipientId";
		String fieldId = "fieldId";
		SignatureEnvelopeFieldSettings body = getSampleRequest("signature/payload/AddSignatureEnvelopeField.json", new TypeReference<SignatureEnvelopeFieldSettings>(){});
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/{documentId}/recipient/{recipientId}/field/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/AddSignatureEnvelopeField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeFieldsResponse response = api.AddSignatureEnvelopeField(userId, envelopeId, documentId, recipientId, fieldId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAssignSignatureEnvelopeField() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String documentId = "documentId";
		String fieldId = "fieldId";
		SignatureEnvelopeAssignFieldSettings body = getSampleRequest("signature/payload/AssignSignatureEnvelopeField.json", new TypeReference<SignatureEnvelopeAssignFieldSettings>(){});
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/{documentId}/field/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/AssignSignatureEnvelopeField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeFieldResponse response = api.AssignSignatureEnvelopeField(userId, envelopeId, documentId, fieldId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testFillEnvelopeField() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String documentId = "documentId";
		String recipientId = "recipientId";
		String fieldId = "fieldId";
		String signatureId = "signatureId";
		FileStream body = new FileStream(getClass().getClassLoader().getResourceAsStream("test.doc"));
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/{documentId}/recipient/{recipientId}/field/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", Pattern.compile(".*"));
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signatureId", signatureId);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/FillEnvelopeField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeFieldResponse response = api.FillEnvelopeField(userId, envelopeId, documentId, recipientId, fieldId, signatureId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testModifySignatureEnvelopeFieldLocation() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String documentId = "documentId";
		String recipientId = "recipientId";
		String fieldId = "fieldId";
		String locationId = "locationId";
		SignatureEnvelopeFieldLocationSettings body = getSampleRequest("signature/payload/ModifySignatureEnvelopeFieldLocation.json", new TypeReference<SignatureEnvelopeFieldLocationSettings>(){});
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/{documentId}/recipient/{recipientId}/fields/{fieldId}/locations/{locationId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId)).replace("{" + "locationId" + "}", String.valueOf(locationId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ModifySignatureEnvelopeFieldLocation.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeFieldResponse response = api.ModifySignatureEnvelopeFieldLocation(userId, envelopeId, documentId, recipientId, fieldId, locationId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureEnvelopeFieldLocation() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String fieldId = "fieldId";
		String locationId = "locationId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/fields/{fieldId}/locations/{locationId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId)).replace("{" + "locationId" + "}", String.valueOf(locationId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureEnvelopeFieldLocation.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureEnvelopeFieldLocation(userId, envelopeId, fieldId, locationId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testModifySignatureEnvelopeField() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String documentId = "documentId";
		String fieldId = "fieldId";
		SignatureEnvelopeFieldSettings body = getSampleRequest("signature/payload/ModifySignatureEnvelopeField.json", new TypeReference<SignatureEnvelopeFieldSettings>(){});
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/documents/{documentId}/field/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "documentId" + "}", String.valueOf(documentId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ModifySignatureEnvelopeField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeFieldResponse response = api.ModifySignatureEnvelopeField(userId, envelopeId, documentId, fieldId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureEnvelopeField() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String fieldId = "fieldId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/fields/{fieldId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "fieldId" + "}", String.valueOf(fieldId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureEnvelopeField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureEnvelopeField(userId, envelopeId, fieldId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureEnvelopeFields() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String documentId = "documentId";
		String recipientId = "recipientId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/fields".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("document", documentId);
		mockRequest = mockRequest.withParam("recipient", recipientId);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureEnvelopeFields.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeFieldsResponse response = api.GetSignatureEnvelopeFields(userId, envelopeId, documentId, recipientId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureEnvelope() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureEnvelope.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeResponse response = api.GetSignatureEnvelope(userId, envelopeId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testModifySignatureEnvelope() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		SignatureEnvelopeSettings body = getSampleRequest("signature/payload/ModifySignatureEnvelope.json", new TypeReference<SignatureEnvelopeSettings>(){});
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ModifySignatureEnvelope.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeResponse response = api.ModifySignatureEnvelope(userId, envelopeId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddSignatureEnvelopeRecipient() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String recipientEmail = "recipientEmail";
		String recipientFirstName = "recipientFirstName";
		String recipientLastName = "recipientLastName";
		Integer order = 0;
		String role = "role";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipient".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("email", recipientEmail);
		mockRequest = mockRequest.withParam("firstname", recipientFirstName);
		mockRequest = mockRequest.withParam("lastname", recipientLastName);
		mockRequest = mockRequest.withParam("order", order);
		mockRequest = mockRequest.withParam("role", role);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/AddSignatureEnvelopeRecipient.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeRecipientResponse response = api.AddSignatureEnvelopeRecipient(userId, envelopeId, recipientEmail, recipientFirstName, recipientLastName, order, role);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testModifySignatureEnvelopeRecipient() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String recipientId = "recipientId";
		String recipientEmail = "recipientEmail";
		String recipientFirstName = "recipientFirstName";
		String recipientLastName = "recipientLastName";
		Integer order = 0;
		String role = "role";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipient/{recipientId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("email", recipientEmail);
		mockRequest = mockRequest.withParam("firstname", recipientFirstName);
		mockRequest = mockRequest.withParam("lastname", recipientLastName);
		mockRequest = mockRequest.withParam("order", order);
		mockRequest = mockRequest.withParam("role", role);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/ModifySignatureEnvelopeRecipient.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeRecipientResponse response = api.ModifySignatureEnvelopeRecipient(userId, envelopeId, recipientId, recipientEmail, recipientFirstName, recipientLastName, order, role);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteSignatureEnvelopeRecipient() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String recipientId = "recipientId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipients/{recipientId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId)).replace("{" + "recipientId" + "}", String.valueOf(recipientId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/DeleteSignatureEnvelopeRecipient.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureStatusResponse response = api.DeleteSignatureEnvelopeRecipient(userId, envelopeId, recipientId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSignatureEnvelopeRecipients() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}/recipients".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/GetSignatureEnvelopeRecipients.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeRecipientsResponse response = api.GetSignatureEnvelopeRecipients(userId, envelopeId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testRenameSignatureEnvelope() throws Exception {
		// sample parameters
		String userId = "userId";
		String envelopeId = "envelopeId";
		String name = "name";
		
		String resourcePath = "/signature/{userId}/envelopes/{envelopeId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "envelopeId" + "}", String.valueOf(envelopeId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("name", name);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("signature/RenameSignatureEnvelope.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SignatureEnvelopeResponse response = api.RenameSignatureEnvelope(userId, envelopeId, name);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	
}

