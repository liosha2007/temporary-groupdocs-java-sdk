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


public class DocApiTest extends AbstractUnitTest {
  
	DocApi api;
	
	@Rule
	public ClientDriverRule driver = new ClientDriverRule();
	
	@Before
	public void setUpBefore() throws Exception {
		api = new DocApi();
		api.setBasePath(driver.getBaseUrl());
	}

	@Test
	public void testViewDocument() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String pageNumber = "pageNumber";
		String pageCount = "pageCount";
		String width = "width";
		String quality = "quality";
		String usePdf = "usePdf";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/thumbnails".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("page_number", pageNumber);
		mockRequest = mockRequest.withParam("page_count", pageCount);
		mockRequest = mockRequest.withParam("width", width);
		mockRequest = mockRequest.withParam("quality", quality);
		mockRequest = mockRequest.withParam("use_pdf", usePdf);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/ViewDocument.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			ViewDocumentResponse response = api.ViewDocument(userId, fileId, pageNumber, pageCount, width, quality, usePdf);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testViewDocumentAsHtml() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String pageNumber = "pageNumber";
		String pageCount = "pageCount";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/htmlRepresentations".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("page_number", pageNumber);
		mockRequest = mockRequest.withParam("page_count", pageCount);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/ViewDocumentAsHtml.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			ViewDocumentResponse response = api.ViewDocumentAsHtml(userId, fileId, pageNumber, pageCount);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetDocumentViews() throws Exception {
		// sample parameters
		String userId = "userId";
		String startIndex = "startIndex";
		String pageSize = "pageSize";
		
		String resourcePath = "/doc/{userId}/views".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("page_index", startIndex);
		mockRequest = mockRequest.withParam("page_size", pageSize);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetDocumentViews.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DocumentViewsResponse response = api.GetDocumentViews(userId, startIndex, pageSize);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testShareDocument() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		List<String> body = getSampleRequest("doc/payload/ShareDocument.json", new TypeReference<List<String>>(){});
		
		String resourcePath = "/doc/{userId}/files/{fileId}/sharers".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/ShareDocument.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SharedUsersResponse response = api.ShareDocument(userId, fileId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUnshareDocument() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/sharers".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/UnshareDocument.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SharedUsersResponse response = api.UnshareDocument(userId, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetFolderSharers() throws Exception {
		// sample parameters
		String userId = "userId";
		String folderId = "folderId";
		
		String resourcePath = "/doc/{userId}/folders/{folderId}/sharers".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "folderId" + "}", String.valueOf(folderId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetFolderSharers.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SharedUsersResponse response = api.GetFolderSharers(userId, folderId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testShareFolder() throws Exception {
		// sample parameters
		String userId = "userId";
		String folderId = "folderId";
		List<String> body = getSampleRequest("doc/payload/ShareFolder.json", new TypeReference<List<String>>(){});
		
		String resourcePath = "/doc/{userId}/folders/{folderId}/sharers".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "folderId" + "}", String.valueOf(folderId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/ShareFolder.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SharedUsersResponse response = api.ShareFolder(userId, folderId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUnshareFolder() throws Exception {
		// sample parameters
		String userId = "userId";
		String folderId = "folderId";
		
		String resourcePath = "/doc/{userId}/folders/{folderId}/sharers".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "folderId" + "}", String.valueOf(folderId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/UnshareFolder.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SharedUsersResponse response = api.UnshareFolder(userId, folderId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSetDocumentAccessMode() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String mode = "mode";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/accessinfo".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("mode", mode);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/SetDocumentAccessMode.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DocumentAccessInfoResponse response = api.SetDocumentAccessMode(userId, fileId, mode);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetDocumentAccessInfo() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/accessinfo".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetDocumentAccessInfo.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DocumentAccessInfoResponse response = api.GetDocumentAccessInfo(userId, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetDocumentMetadata() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/metadata".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetDocumentMetadata.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetDocumentInfoResponse response = api.GetDocumentMetadata(userId, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetDocumentMetadataByPath() throws Exception {
		// sample parameters
		String userId = "userId";
		String path = "path";
		
		String resourcePath = "/doc/{userId}/files/{path}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetDocumentMetadataByPath.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetDocumentInfoResponse response = api.GetDocumentMetadataByPath(userId, path);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSetDocumentUserStatus() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String status = "status";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/sharer".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("status", status);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/SetDocumentUserStatus.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DocumentUserStatusResponse response = api.SetDocumentUserStatus(userId, fileId, status);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSharedDocuments() throws Exception {
		// sample parameters
		String userId = "userId";
		String sharesTypes = "sharesTypes";
		String pageIndex = "pageIndex";
		String pageSize = "pageSize";
		String orderBy = "orderBy";
		Boolean orderAsc = Boolean.TRUE;
		
		String resourcePath = "/doc/{userId}/shares/{sharesTypes}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "sharesTypes" + "}", String.valueOf(sharesTypes));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("page_index", pageIndex);
		mockRequest = mockRequest.withParam("page_size", pageSize);
		mockRequest = mockRequest.withParam("order_by", orderBy);
		mockRequest = mockRequest.withParam("order_asc", orderAsc);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetSharedDocuments.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SharedDocumentsResponse response = api.GetSharedDocuments(userId, sharesTypes, pageIndex, pageSize, orderBy, orderAsc);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetTemplateFields() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		Boolean includeGeometry = Boolean.TRUE;
		
		String resourcePath = "/doc/{userId}/files/{fileId}/fields".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("include_geometry", includeGeometry);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetTemplateFields.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			TemplateFieldsResponse response = api.GetTemplateFields(userId, fileId, includeGeometry);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetDocumentFormats() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/formats".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetDocumentFormats.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetDocumentForeignTypesResponse response = api.GetDocumentFormats(userId, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetDocumentPageImage() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		Integer pageNumber = 0;
		String dimension = "dimension";
		Integer quality = 0;
		Boolean usePdf = Boolean.TRUE;
		Boolean expiresOn = Boolean.TRUE;
		
		String resourcePath = "/doc/{userId}/files/{fileId}/pages/{pageNumber}/images/{dimension}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "pageNumber" + "}", String.valueOf(pageNumber)).replace("{" + "dimension" + "}", String.valueOf(dimension));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("quality", quality);
		mockRequest = mockRequest.withParam("use_pdf", usePdf);
		mockRequest = mockRequest.withParam("expires", expiresOn);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetDocumentPageImage.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			FileStream response = api.GetDocumentPageImage(userId, fileId, pageNumber, dimension, quality, usePdf, expiresOn);
			assertThat(response.getInputStream(), not(nullValue()));
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetDocumentPageHtml() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		Integer pageNumber = 0;
		Boolean expiresOn = Boolean.TRUE;
		
		String resourcePath = "/doc/{userId}/files/{fileId}/pages/{pageNumber}/htmlRepresentations".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "pageNumber" + "}", String.valueOf(pageNumber));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("expires", expiresOn);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetDocumentPageHtml.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			FileStream response = api.GetDocumentPageHtml(userId, fileId, pageNumber, expiresOn);
			assertThat(response.getInputStream(), not(nullValue()));
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetDocumentPagesImageUrls() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String dimension = "dimension";
		Integer firstPage = 0;
		Integer pageCount = 0;
		Integer quality = 0;
		Boolean usePdf = Boolean.TRUE;
		String token = "token";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/pages/images/{dimension}/urls".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "dimension" + "}", String.valueOf(dimension));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("first_page", firstPage);
		mockRequest = mockRequest.withParam("page_count", pageCount);
		mockRequest = mockRequest.withParam("quality", quality);
		mockRequest = mockRequest.withParam("use_pdf", usePdf);
		mockRequest = mockRequest.withParam("token", token);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetDocumentPagesImageUrls.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetImageUrlsResponse response = api.GetDocumentPagesImageUrls(userId, fileId, firstPage, pageCount, dimension, quality, usePdf, token);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetDocumentPagesHtmlUrls() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		Integer firstPage = 0;
		Integer pageCount = 0;
		
		String resourcePath = "/doc/{userId}/files/{fileId}/pages/htmlRepresentationUrls".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("first_page", firstPage);
		mockRequest = mockRequest.withParam("page_count", pageCount);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetDocumentPagesHtmlUrls.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetImageUrlsResponse response = api.GetDocumentPagesHtmlUrls(userId, fileId, firstPage, pageCount);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetEditLock() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/editlock".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetEditLock.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetEditLockResponse response = api.GetEditLock(userId, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testRemoveEditLock() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String lockId = "lockId";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/editlock".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("lockId", lockId);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/RemoveEditLock.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			RemoveEditLockResponse response = api.RemoveEditLock(userId, fileId, lockId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetDocumentTags() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/tags".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/GetDocumentTags.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetTagsResponse response = api.GetDocumentTags(userId, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSetDocumentTags() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/tags".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/SetDocumentTags.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SetTagsResponse response = api.SetDocumentTags(userId, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testRemoveDocumentTags() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/doc/{userId}/files/{fileId}/tags".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("doc/RemoveDocumentTags.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			RemoveTagsResponse response = api.RemoveDocumentTags(userId, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	
}

