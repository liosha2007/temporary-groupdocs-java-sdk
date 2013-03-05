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
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import com.github.restdriver.clientdriver.ClientDriverRequest.Method;
import com.github.restdriver.clientdriver.ClientDriverRule;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.model.AddReplyResponse;
import com.groupdocs.sdk.model.AnnotationInfo;
import com.groupdocs.sdk.model.AnnotationReplyInfo;
import com.groupdocs.sdk.model.CreateAnnotationResponse;
import com.groupdocs.sdk.model.EditReplyResponse;
import com.groupdocs.sdk.model.Rectangle;
import com.groupdocs.sdk.model.ReviewerInfo;
import com.groupdocs.sdk.model.SetCollaboratorsResponse;
import com.groupdocs.sdk.model.SetReviewerRightsResponse;

/**
 * Test cases to ensure correctness of Object to JSON serialization and Object from JSON deserialization
 *  
 * @author zhaidarbek
 *
 */
public class JsonSerializerTest extends AbstractUnitTest {

	AntApi antApi;
	StorageApi storageApi;
	
	@Rule
	public ClientDriverRule driver = new ClientDriverRule();
	
	@Before
	public void setUpBefore() throws Exception {
		antApi = new AntApi();
		antApi.setBasePath(driver.getBaseUrl());
		storageApi = new StorageApi();
		storageApi.setBasePath(driver.getBaseUrl());
	}

	@Test
	public void testPrimitiveSerilization() throws Exception {
		String message = "updated message from java client library";
		String replyGuid = "6a215585";
		
		String resourcePath = "/ant/{userId}/replies/{replyGuid}".replace("{userId}", userId).replace("{replyGuid}", replyGuid);
		driver.addExpectation(onRequestTo(resourcePath).withAnyParams()
				.withMethod(Method.PUT).withBody("\"" + message + "\"", MediaType.APPLICATION_JSON), 
                giveResponse(getSampleResponse("ant/EditAnnotationReply.json")).withStatus(200));
		
		EditReplyResponse response = antApi.EditAnnotationReply(userId, replyGuid, message);
		assertThat(response.getStatus(), equalTo("Ok"));
	}

	@Test
	public void testPrimitiveDeserilization() throws Exception {
		String fileId = "SomeFileGuid";
		
		String resourcePath = "/storage/{userId}/files/{fileId}".replace("{userId}", userId).replace("{fileId}", fileId);
		driver.addExpectation(onRequestTo(resourcePath).withAnyParams()
				.withHeader("Content-Type", MediaType.TEXT_HTML).withMethod(Method.GET), 
                giveResponse("GetFile returns raw file contents").withStatus(200));
		
		String response = IOUtils.toString(storageApi.GetFile(userId, fileId).getInputStream());
		assertThat(response, equalTo("GetFile returns raw file contents"));
	}

	@Test
	public void testSimpleObjectSerilizationDeserilization() throws Exception {
		String annotationId = "8257702b138f2b55";
		AnnotationReplyInfo reply = new AnnotationReplyInfo();
		reply.setText("test message from java client library");
		reply.setParentReplyGuid("6a215585");
		
		String resourcePath = "/ant/{userId}/annotations/{annotationId}/replies".replace("{userId}", userId).replace("{annotationId}", annotationId);
		String body = "{\"text\":\"test message from java client library\",\"parentReplyGuid\":\"6a215585\"}";
		driver.addExpectation(onRequestTo(resourcePath).withAnyParams()
				.withMethod(Method.POST).withBody(body, MediaType.APPLICATION_JSON), 
                giveResponse(getSampleResponse("ant/CreateAnnotationReply.json")).withStatus(200));
		
		AddReplyResponse response = antApi.CreateAnnotationReply(userId, annotationId, reply);
		assertThat(response.getStatus(), equalTo("Ok"));
		assertThat(response.getResult().getAnnotationGuid(), equalTo(annotationId));
	}

	@Test
	public void testNestedObjectSerilizationDeserilization() throws Exception {
		AnnotationInfo annotation = new AnnotationInfo();
		Rectangle box = new Rectangle();
		box.setHeight(100d);
		box.setWidth(100d);
		box.setX(100d);
		box.setY(100d);
		AnnotationReplyInfo reply = new AnnotationReplyInfo();
		reply.setText("first message");
		AnnotationReplyInfo reply2 = new AnnotationReplyInfo();
		reply2.setText("second message");
		annotation.setType("Text");
		annotation.setBox(box);
		annotation.setReplies(Arrays.asList(new AnnotationReplyInfo[] { reply, reply2 }));
		String fileId = "SomeFileGuid";
		
		String resourcePath = "/ant/{userId}/files/{fileId}/annotations".replace("{userId}", userId).replace("{fileId}", fileId);
		String body = ApiInvoker.getInstance().serialize(annotation);
		driver.addExpectation(onRequestTo(resourcePath).withAnyParams()
				.withMethod(Method.POST).withBody(body, MediaType.APPLICATION_JSON), 
                giveResponse(getSampleResponse("ant/CreateAnnotation.json")).withStatus(200));

		CreateAnnotationResponse response = antApi.CreateAnnotation(userId, fileId , annotation);
		assertThat(response.getStatus(), equalTo("Ok"));
		assertThat(response.getResult().getAccess(), equalTo("Public"));
	}

	@Test
	public void testListOfPrimitivesSerilization() throws Exception {
		String fileId = "SomeFileGuid";
		String version = "1";
		List<String> collaborators = Arrays.asList("test1@gmail.com", "test2@gmail.com");
		
		String resourcePath = "/ant/{userId}/files/{fileId}/version/{version}/collaborators".replace("{userId}", userId).replace("{fileId}", fileId).replace("{version}", version);
		String body = "[\"test1@gmail.com\",\"test2@gmail.com\"]";
		driver.addExpectation(onRequestTo(resourcePath).withAnyParams()
				.withMethod(Method.PUT).withBody(body, MediaType.APPLICATION_JSON), 
                giveResponse(getSampleResponse("ant/SetAnnotationCollaborators.json")).withStatus(200));
		
		SetCollaboratorsResponse response = antApi.SetAnnotationCollaborators(userId, fileId , version, collaborators);
		assertThat(response.getStatus(), equalTo("Ok"));
	}

	@Ignore("There are no such methods in GroupDocs API")
	@Test
	public void testListOfPrimitivesDeserilization() {
		fail("Not yet implemented");
	}

	@Test
	public void testListOfObjectsSerilization() throws Exception {
		ReviewerInfo rev1 = new ReviewerInfo();
		rev1.setAccess_rights(1);
		rev1.setId(1232d);
		ReviewerInfo rev2 = new ReviewerInfo();
		rev2.setAccess_rights(0);
		rev2.setId(1233d);
		List<ReviewerInfo> collaborators = Arrays.asList(rev1, rev2);
		String fileId = "SomeFileGuid";

		String resourcePath = "/ant/{userId}/files/{fileId}/reviewerRights".replace("{userId}", userId).replace("{fileId}", fileId);
		String body = "[{\"id\":1232.0,\"access_rights\":1},{\"id\":1233.0,\"access_rights\":0}]";
		driver.addExpectation(onRequestTo(resourcePath).withAnyParams()
				.withMethod(Method.PUT).withBody(body, MediaType.APPLICATION_JSON), 
                giveResponse(getSampleResponse("ant/SetReviewerRights.json")).withStatus(200));

		SetReviewerRightsResponse response = antApi.SetReviewerRights(userId, fileId , collaborators);
		assertThat(response.getStatus(), equalTo("Ok"));
	}

	@Ignore("There are no such methods in GroupDocs API")
	@Test
	public void testListOfObjectsDeserilization() {
		fail("Not yet implemented");
	}

}
