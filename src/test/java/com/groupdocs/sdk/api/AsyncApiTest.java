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


public class AsyncApiTest extends AbstractUnitTest {
  
	AsyncApi api;
	
	@Rule
	public ClientDriverRule driver = new ClientDriverRule();
	
	@Before
	public void setUpBefore() throws Exception {
		api = new AsyncApi();
		api.setBasePath(driver.getBaseUrl());
	}

	@Test
	public void testGetJob() throws Exception {
		// sample parameters
		String userId = "userId";
		String jobId = "jobId";
		
		String resourcePath = "/async/{userId}/jobs/{jobId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("async/GetJob.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetJobResponse response = api.GetJob(userId, jobId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetJobJson() throws Exception {
		// sample parameters
		String userId = "userId";
		String jobId = "jobId";
		
		String resourcePath = "/async/{userId}/jobs/{jobId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("async/GetJobJson.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetJobResponse response = api.GetJobJson(userId, jobId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetJobResources() throws Exception {
		// sample parameters
		String userId = "userId";
		String statusIds = "statusIds";
		String actions = "actions";
		String excludedActions = "excludedActions";
		
		String resourcePath = "/async/{userId}/jobs/resources".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("statusIds", statusIds);
		mockRequest = mockRequest.withParam("actions", actions);
		mockRequest = mockRequest.withParam("excluded_actions", excludedActions);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("async/GetJobResources.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetJobResourcesResponse response = api.GetJobResources(userId, statusIds, actions, excludedActions);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetJobDocuments() throws Exception {
		// sample parameters
		String userId = "userId";
		String jobId = "jobId";
		String format = "format";
		
		String resourcePath = "/async/{userId}/jobs/{jobId}/documents".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("format", format);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("async/GetJobDocuments.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetJobDocumentsResponse response = api.GetJobDocuments(userId, jobId, format);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCreateJob() throws Exception {
		// sample parameters
		String userId = "userId";
		JobInfo body = getSampleRequest("async/payload/CreateJob.json", new TypeReference<JobInfo>(){});
		
		String resourcePath = "/async/{userId}/jobs".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("async/CreateJob.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			CreateJobResponse response = api.CreateJob(userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteJob() throws Exception {
		// sample parameters
		String userId = "userId";
		String jobGuid = "jobGuid";
		
		String resourcePath = "/async/{userId}/jobs/{jobGuid}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobGuid" + "}", String.valueOf(jobGuid));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("async/DeleteJob.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteResult response = api.DeleteJob(userId, jobGuid);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddJobDocument() throws Exception {
		// sample parameters
		String userId = "userId";
		String jobId = "jobId";
		String fileId = "fileId";
		Boolean checkOwnership = Boolean.TRUE;
		String formats = "formats";
		
		String resourcePath = "/async/{userId}/jobs/{jobId}/files/{fileId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("check_ownership", checkOwnership);
		mockRequest = mockRequest.withParam("out_formats", formats);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("async/AddJobDocument.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddJobDocumentResponse response = api.AddJobDocument(userId, jobId, fileId, checkOwnership, formats);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteJobDocument() throws Exception {
		// sample parameters
		String userId = "userId";
		String jobGuid = "jobGuid";
		String documentId = "documentId";
		
		String resourcePath = "/async/{userId}/jobs/{jobGuid}/documents/{documentId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobGuid" + "}", String.valueOf(jobGuid)).replace("{" + "documentId" + "}", String.valueOf(documentId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("async/DeleteJobDocument.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteResponse response = api.DeleteJobDocument(userId, jobGuid, documentId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddJobDocumentUrl() throws Exception {
		// sample parameters
		String userId = "userId";
		String jobId = "jobId";
		String absoluteUrl = "absoluteUrl";
		String formats = "formats";
		
		String resourcePath = "/async/{userId}/jobs/{jobId}/urls".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("absolute_url", absoluteUrl);
		mockRequest = mockRequest.withParam("out_formats", formats);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("async/AddJobDocumentUrl.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddJobDocumentResponse response = api.AddJobDocumentUrl(userId, jobId, absoluteUrl, formats);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUpdateJob() throws Exception {
		// sample parameters
		String userId = "userId";
		String jobId = "jobId";
		JobInfo body = getSampleRequest("async/payload/UpdateJob.json", new TypeReference<JobInfo>(){});
		
		String resourcePath = "/async/{userId}/jobs/{jobId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("async/UpdateJob.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UpdateJobResponse response = api.UpdateJob(userId, jobId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetJobs() throws Exception {
		// sample parameters
		String userId = "userId";
		String pageIndex = "pageIndex";
		String pageSize = "pageSize";
		String date = "date";
		String statusIds = "statusIds";
		String actions = "actions";
		String excludedActions = "excludedActions";
		
		String resourcePath = "/async/{userId}/jobs".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("page", pageIndex);
		mockRequest = mockRequest.withParam("count", pageSize);
		mockRequest = mockRequest.withParam("date", date);
		mockRequest = mockRequest.withParam("statusIds", statusIds);
		mockRequest = mockRequest.withParam("actions", actions);
		mockRequest = mockRequest.withParam("excluded_actions", excludedActions);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("async/GetJobs.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetJobsResponse response = api.GetJobs(userId, pageIndex, pageSize, date, statusIds, actions, excludedActions);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetJobsDocuments() throws Exception {
		// sample parameters
		String userId = "userId";
		String pageIndex = "pageIndex";
		String pageSize = "pageSize";
		String actions = "actions";
		String excludedActions = "excludedActions";
		String orderBy = "orderBy";
		Boolean orderAsc = Boolean.TRUE;
		
		String resourcePath = "/async/{userId}/jobs/documents".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("page", pageIndex);
		mockRequest = mockRequest.withParam("count", pageSize);
		mockRequest = mockRequest.withParam("actions", actions);
		mockRequest = mockRequest.withParam("excluded_actions", excludedActions);
		mockRequest = mockRequest.withParam("order_by", orderBy);
		mockRequest = mockRequest.withParam("order_asc", orderAsc);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("async/GetJobsDocuments.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetJobsDocumentsResponse response = api.GetJobsDocuments(userId, pageIndex, pageSize, actions, excludedActions, orderBy, orderAsc);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testConvert() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String targetType = "targetType";
		String emailResults = "emailResults";
		String description = "description";
		Boolean printScript = Boolean.TRUE;
		String callbackUrl = "callbackUrl";
		Boolean checkDocumentOwnership = Boolean.TRUE;
		
		String resourcePath = "/async/{userId}/files/{fileId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("new_type", targetType);
		mockRequest = mockRequest.withParam("email_results", emailResults);
		mockRequest = mockRequest.withParam("new_description", description);
		mockRequest = mockRequest.withParam("print_script", printScript);
		mockRequest = mockRequest.withParam("callback", callbackUrl);
		mockRequest = mockRequest.withParam("checkDocumentOwnership", checkDocumentOwnership);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("async/Convert.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			ConvertResponse response = api.Convert(userId, fileId, targetType, emailResults, description, printScript, callbackUrl, checkDocumentOwnership);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	
}

