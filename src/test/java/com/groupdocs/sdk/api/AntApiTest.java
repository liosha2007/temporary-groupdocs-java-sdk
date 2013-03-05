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


public class AntApiTest extends AbstractUnitTest {
  
	AntApi api;
	
	@Rule
	public ClientDriverRule driver = new ClientDriverRule();
	
	@Before
	public void setUpBefore() throws Exception {
		api = new AntApi();
		api.setBasePath(driver.getBaseUrl());
	}

	@Test
	public void testCreateAnnotation() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		AnnotationInfo body = getSampleRequest("ant/payload/CreateAnnotation.json", new TypeReference<AnnotationInfo>(){});
		
		String resourcePath = "/ant/{userId}/files/{fileId}/annotations".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/CreateAnnotation.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			CreateAnnotationResponse response = api.CreateAnnotation(userId, fileId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testListAnnotations() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/ant/{userId}/files/{fileId}/annotations".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/ListAnnotations.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			ListAnnotationsResponse response = api.ListAnnotations(userId, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteAnnotation() throws Exception {
		// sample parameters
		String userId = "userId";
		String annotationId = "annotationId";
		
		String resourcePath = "/ant/{userId}/annotations/{annotationId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/DeleteAnnotation.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteAnnotationResponse response = api.DeleteAnnotation(userId, annotationId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCreateAnnotationReply() throws Exception {
		// sample parameters
		String userId = "userId";
		String annotationId = "annotationId";
		AnnotationReplyInfo body = getSampleRequest("ant/payload/CreateAnnotationReply.json", new TypeReference<AnnotationReplyInfo>(){});
		
		String resourcePath = "/ant/{userId}/annotations/{annotationId}/replies".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/CreateAnnotationReply.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddReplyResponse response = api.CreateAnnotationReply(userId, annotationId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testEditAnnotationReply() throws Exception {
		// sample parameters
		String userId = "userId";
		String replyGuid = "replyGuid";
		String body = "body";
		
		String resourcePath = "/ant/{userId}/replies/{replyGuid}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "replyGuid" + "}", String.valueOf(replyGuid));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/EditAnnotationReply.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			EditReplyResponse response = api.EditAnnotationReply(userId, replyGuid, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteAnnotationReply() throws Exception {
		// sample parameters
		String userId = "userId";
		String replyGuid = "replyGuid";
		
		String resourcePath = "/ant/{userId}/replies/{replyGuid}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "replyGuid" + "}", String.valueOf(replyGuid));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/DeleteAnnotationReply.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteReplyResponse response = api.DeleteAnnotationReply(userId, replyGuid);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testListAnnotationReplies() throws Exception {
		// sample parameters
		String userId = "userId";
		String annotationId = "annotationId";
		Long after = 0L;
		
		String resourcePath = "/ant/{userId}/annotations/{annotationId}/replies".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("after", after);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/ListAnnotationReplies.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			ListRepliesResponse response = api.ListAnnotationReplies(userId, annotationId, after);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSetAnnotationCollaborators() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String version = "version";
		List<String> body = getSampleRequest("ant/payload/SetAnnotationCollaborators.json", new TypeReference<List<String>>(){});
		
		String resourcePath = "/ant/{userId}/files/{fileId}/version/{version}/collaborators".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "version" + "}", String.valueOf(version));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/SetAnnotationCollaborators.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SetCollaboratorsResponse response = api.SetAnnotationCollaborators(userId, fileId, version, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetAnnotationCollaborators() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/ant/{userId}/files/{fileId}/collaborators".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/GetAnnotationCollaborators.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetCollaboratorsResponse response = api.GetAnnotationCollaborators(userId, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddAnnotationCollaborator() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		ReviewerInfo body = getSampleRequest("ant/payload/AddAnnotationCollaborator.json", new TypeReference<ReviewerInfo>(){});
		
		String resourcePath = "/ant/{userId}/files/{fileId}/collaborators".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/AddAnnotationCollaborator.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddCollaboratorResponse response = api.AddAnnotationCollaborator(userId, fileId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteDocumentReviewer() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String reviewerId = "reviewerId";
		
		String resourcePath = "/ant/{userId}/files/{fileId}/collaborators/{reviewerId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "reviewerId" + "}", String.valueOf(reviewerId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/DeleteDocumentReviewer.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddCollaboratorResponse response = api.DeleteDocumentReviewer(userId, fileId, reviewerId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetReviewerContacts() throws Exception {
		// sample parameters
		String userId = "userId";
		
		String resourcePath = "/ant/{userId}/contacts".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/GetReviewerContacts.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetReviewerContactsResponse response = api.GetReviewerContacts(userId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSetReviewerContacts() throws Exception {
		// sample parameters
		String userId = "userId";
		List<ReviewerContactInfo> body = getSampleRequest("ant/payload/SetReviewerContacts.json", new TypeReference<List<ReviewerContactInfo>>(){});
		
		String resourcePath = "/ant/{userId}/reviewerContacts".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/SetReviewerContacts.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetReviewerContactsResponse response = api.SetReviewerContacts(userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testMoveAnnotation() throws Exception {
		// sample parameters
		String userId = "userId";
		String annotationId = "annotationId";
		Point body = getSampleRequest("ant/payload/MoveAnnotation.json", new TypeReference<Point>(){});
		
		String resourcePath = "/ant/{userId}/annotations/{annotationId}/position".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/MoveAnnotation.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			MoveAnnotationResponse response = api.MoveAnnotation(userId, annotationId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSetAnnotationAccess() throws Exception {
		// sample parameters
		String userId = "userId";
		String annotationId = "annotationId";
		Integer body = 0;
		
		String resourcePath = "/ant/{userId}/annotations/{annotationId}/annotationAccess".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/SetAnnotationAccess.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SetAnnotationAccessResponse response = api.SetAnnotationAccess(userId, annotationId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testMoveAnnotationMarker() throws Exception {
		// sample parameters
		String userId = "userId";
		String annotationId = "annotationId";
		Point body = getSampleRequest("ant/payload/MoveAnnotationMarker.json", new TypeReference<Point>(){});
		
		String resourcePath = "/ant/{userId}/annotations/{annotationId}/markerPosition".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/MoveAnnotationMarker.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			MoveAnnotationResponse response = api.MoveAnnotationMarker(userId, annotationId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSetReviewerRights() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		List<ReviewerInfo> body = getSampleRequest("ant/payload/SetReviewerRights.json", new TypeReference<List<ReviewerInfo>>(){});
		
		String resourcePath = "/ant/{userId}/files/{fileId}/reviewerRights".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/SetReviewerRights.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SetReviewerRightsResponse response = api.SetReviewerRights(userId, fileId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSharedLinkAccessRights() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/ant/{userId}/files/{fileId}/sharedLinkAccessRights".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/GetSharedLinkAccessRights.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetSharedLinkAccessRightsResponse response = api.GetSharedLinkAccessRights(userId, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSetSharedLinkAccessRights() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		Integer body = 0;
		
		String resourcePath = "/ant/{userId}/files/{fileId}/sharedLinkAccessRights".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/SetSharedLinkAccessRights.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SetSharedLinkAccessRightsResponse response = api.SetSharedLinkAccessRights(userId, fileId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSetSessionCallbackUrl() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String body = "body";
		
		String resourcePath = "/ant/{userId}/files/{fileId}/sessionCallbackUrl".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/SetSessionCallbackUrl.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SetSessionCallbackUrlResponse response = api.SetSessionCallbackUrl(userId, fileId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSaveTextField() throws Exception {
		// sample parameters
		String userId = "userId";
		String annotationId = "annotationId";
		TextFieldInfo body = getSampleRequest("ant/payload/SaveTextField.json", new TypeReference<TextFieldInfo>(){});
		
		String resourcePath = "/ant/{userId}/annotations/{annotationId}/textFieldInfo".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "annotationId" + "}", String.valueOf(annotationId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("ant/SaveTextField.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SaveAnnotationTextResponse response = api.SaveTextField(userId, annotationId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	
}

