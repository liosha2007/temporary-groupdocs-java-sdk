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
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.restdriver.clientdriver.ClientDriverRequest;
import com.github.restdriver.clientdriver.ClientDriverRequest.Method;
import com.github.restdriver.clientdriver.ClientDriverResponse;
import com.github.restdriver.clientdriver.ClientDriverRule;

import com.groupdocs.sdk.common.ApiException;
import com.groupdocs.sdk.model.QuestionnaireInfo;
import com.groupdocs.sdk.model.GetQuestionnaireExecutionsResponse;
import com.groupdocs.sdk.model.Datasource;
import com.groupdocs.sdk.model.UpdateQuestionnaireExecutionResponse;
import com.groupdocs.sdk.model.GetQuestionnairesResponse;
import com.groupdocs.sdk.model.GetQuestionnaireMetadataResponse;
import com.groupdocs.sdk.model.UpdateQuestionnaireResponse;
import com.groupdocs.sdk.model.GetDocumentQuestionnairesResponse;
import com.groupdocs.sdk.model.QuestionnaireExecutionInfo;
import com.groupdocs.sdk.model.AddDatasourceResponse;
import com.groupdocs.sdk.model.AddQuestionnaireCollectorResponse;
import com.groupdocs.sdk.model.AddDocumentDataSourceResponse;
import com.groupdocs.sdk.model.DatasourceField;
import com.groupdocs.sdk.model.DeleteQuestionnaireExecutionResponse;
import com.groupdocs.sdk.model.DeleteDocumentQuestionnaireResponse;
import com.groupdocs.sdk.model.GetQuestionnaireCollectorResponse;
import com.groupdocs.sdk.model.TemplateFieldsResponse;
import com.groupdocs.sdk.model.QuestionnaireCollectorInfo;
import com.groupdocs.sdk.model.DeleteQuestionnaireCollectorResponse;
import com.groupdocs.sdk.model.GetQuestionnaireCollectorsResponse;
import com.groupdocs.sdk.model.AddDocumentQuestionnaireResponse;
import com.groupdocs.sdk.model.DeleteDatasourceResponse;
import com.groupdocs.sdk.model.QuestionnaireMetadata;
import com.groupdocs.sdk.model.GetDatasourceResponse;
import com.groupdocs.sdk.model.AddQuestionnaireExecutionResponse;
import com.groupdocs.sdk.model.GetTemplatesResponse;
import com.groupdocs.sdk.model.DeleteQuestionnaireResponse;
import com.groupdocs.sdk.model.MergeTemplateResponse;
import com.groupdocs.sdk.model.GetQuestionnaireResponse;
import com.groupdocs.sdk.model.GetDatasourcesResponse;
import com.groupdocs.sdk.model.UpdateQuestionnaireCollectorResponse;
import com.groupdocs.sdk.model.GetQuestionnaireExecutionResponse;
import com.groupdocs.sdk.model.CreateQuestionnaireResponse;


public class MergeApiTest extends AbstractUnitTest {
  
	MergeApi api;
	
	@Rule
	public ClientDriverRule driver = new ClientDriverRule();
	
	@Before
	public void setUpBefore() throws Exception {
		api = new MergeApi();
		api.setBasePath(driver.getBaseUrl());
	}

	@Test
	public void testGetQuestionnaireCollectors() throws Exception {
		// sample parameters
		String userId = "userId";
		String questionnaireId = "questionnaireId";
		
		String resourcePath = "/merge/{userId}/questionnaires/{questionnaireId}/collectors".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "questionnaireId" + "}", String.valueOf(questionnaireId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/GetQuestionnaireCollectors.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetQuestionnaireCollectorsResponse response = api.GetQuestionnaireCollectors(userId, questionnaireId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetQuestionnaireCollector() throws Exception {
		// sample parameters
		String userId = "userId";
		String collectorId = "collectorId";
		
		String resourcePath = "/merge/{userId}/questionnaires/collectors/{collectorId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "collectorId" + "}", String.valueOf(collectorId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/GetQuestionnaireCollector.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetQuestionnaireCollectorResponse response = api.GetQuestionnaireCollector(userId, collectorId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddQuestionnaireCollector() throws Exception {
		// sample parameters
		String userId = "userId";
		String questionnaireId = "questionnaireId";
		QuestionnaireCollectorInfo body = getSampleRequest("merge/payload/AddQuestionnaireCollector.json", new TypeReference<QuestionnaireCollectorInfo>(){});
		
		String resourcePath = "/merge/{userId}/questionnaires/{questionnaireId}/collectors".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "questionnaireId" + "}", String.valueOf(questionnaireId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/AddQuestionnaireCollector.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddQuestionnaireCollectorResponse response = api.AddQuestionnaireCollector(userId, questionnaireId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUpdateQuestionnaireCollector() throws Exception {
		// sample parameters
		String userId = "userId";
		String collectorId = "collectorId";
		QuestionnaireCollectorInfo body = getSampleRequest("merge/payload/UpdateQuestionnaireCollector.json", new TypeReference<QuestionnaireCollectorInfo>(){});
		
		String resourcePath = "/merge/{userId}/questionnaires/collectors/{collectorId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "collectorId" + "}", String.valueOf(collectorId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/UpdateQuestionnaireCollector.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UpdateQuestionnaireCollectorResponse response = api.UpdateQuestionnaireCollector(userId, collectorId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteQuestionnaireCollector() throws Exception {
		// sample parameters
		String userId = "userId";
		String collectorId = "collectorId";
		
		String resourcePath = "/merge/{userId}/questionnaires/collectors/{collectorId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "collectorId" + "}", String.valueOf(collectorId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/DeleteQuestionnaireCollector.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteQuestionnaireCollectorResponse response = api.DeleteQuestionnaireCollector(userId, collectorId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetTemplates() throws Exception {
		// sample parameters
		String userId = "userId";
		
		String resourcePath = "/merge/{userId}/templates".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/GetTemplates.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetTemplatesResponse response = api.GetTemplates(userId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetQuestionnaireFields() throws Exception {
		// sample parameters
		String userId = "userId";
		String questionnaireId = "questionnaireId";
		Boolean includeGeometry = Boolean.TRUE;
		
		String resourcePath = "/merge/{userId}/questionnaires/{questionnaireId}/fields".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "questionnaireId" + "}", String.valueOf(questionnaireId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("include_geometry", includeGeometry);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/GetQuestionnaireFields.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			TemplateFieldsResponse response = api.GetQuestionnaireFields(userId, questionnaireId, includeGeometry);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetQuestionnaireMetadata() throws Exception {
		// sample parameters
		String userId = "userId";
		String questionnaireId = "questionnaireId";
		
		String resourcePath = "/merge/{userId}/questionnaires/{questionnaireId}/metadata".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "questionnaireId" + "}", String.valueOf(questionnaireId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/GetQuestionnaireMetadata.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetQuestionnaireMetadataResponse response = api.GetQuestionnaireMetadata(userId, questionnaireId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUpdateQuestionnaireMetadata() throws Exception {
		// sample parameters
		String userId = "userId";
		String questionnaireId = "questionnaireId";
		QuestionnaireMetadata body = getSampleRequest("merge/payload/UpdateQuestionnaireMetadata.json", new TypeReference<QuestionnaireMetadata>(){});
		
		String resourcePath = "/merge/{userId}/questionnaires/{questionnaireId}/metadata".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "questionnaireId" + "}", String.valueOf(questionnaireId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/UpdateQuestionnaireMetadata.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UpdateQuestionnaireResponse response = api.UpdateQuestionnaireMetadata(userId, questionnaireId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddJobDocumentDataSource() throws Exception {
		// sample parameters
		String userId = "userId";
		Integer jobId = 0;
		Integer fileId = 0;
		Integer datasourceId = 0;
		
		String resourcePath = "/merge/{userId}/jobs/{jobId}/files/{fileId}/datasources/{datasourceId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "datasourceId" + "}", String.valueOf(datasourceId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/AddJobDocumentDataSource.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddDocumentDataSourceResponse response = api.AddJobDocumentDataSource(userId, jobId, fileId, datasourceId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddJobDocumentDataSourceFields() throws Exception {
		// sample parameters
		String userId = "userId";
		String jobId = "jobId";
		String fileId = "fileId";
		List<DatasourceField> body = getSampleRequest("merge/payload/AddJobDocumentDataSourceFields.json", new TypeReference<List<DatasourceField>>(){});
		
		String resourcePath = "/merge/{userId}/jobs/{jobId}/files/{fileId}/datasources".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "jobId" + "}", String.valueOf(jobId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/AddJobDocumentDataSourceFields.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddDocumentDataSourceResponse response = api.AddJobDocumentDataSourceFields(userId, jobId, fileId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testFillQuestionnaire() throws Exception {
		// sample parameters
		String userId = "userId";
		String collectorId = "collectorId";
		String datasourceId = "datasourceId";
		String targetType = "targetType";
		String emailResults = "emailResults";
		
		String resourcePath = "/merge/{userId}/questionnaires/collectors/{collectorId}/datasources/{datasourceId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "collectorId" + "}", String.valueOf(collectorId)).replace("{" + "datasourceId" + "}", String.valueOf(datasourceId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("new_type", targetType);
		mockRequest = mockRequest.withParam("email_results", emailResults);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/FillQuestionnaire.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			MergeTemplateResponse response = api.FillQuestionnaire(userId, collectorId, datasourceId, targetType, emailResults);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testFillExecution() throws Exception {
		// sample parameters
		String userId = "userId";
		String executionId = "executionId";
		String datasourceId = "datasourceId";
		String targetType = "targetType";
		String emailResults = "emailResults";
		
		String resourcePath = "/merge/{userId}/questionnaires/executions/{executionId}/datasources/{datasourceId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "executionId" + "}", String.valueOf(executionId)).replace("{" + "datasourceId" + "}", String.valueOf(datasourceId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("new_type", targetType);
		mockRequest = mockRequest.withParam("email_results", emailResults);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/FillExecution.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			MergeTemplateResponse response = api.FillExecution(userId, executionId, datasourceId, targetType, emailResults);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testMergeDatasource() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String datasourceId = "datasourceId";
		String targetType = "targetType";
		String emailResults = "emailResults";
		
		String resourcePath = "/merge/{userId}/files/{fileId}/datasources/{datasourceId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "datasourceId" + "}", String.valueOf(datasourceId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("new_type", targetType);
		mockRequest = mockRequest.withParam("email_results", emailResults);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/MergeDatasource.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			MergeTemplateResponse response = api.MergeDatasource(userId, fileId, datasourceId, targetType, emailResults);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Ignore("wrong input json")
	@Test
	public void testMergeDatasourceFields() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String targetType = "targetType";
		String emailResults = "emailResults";
		String assemblyName = "assemblyName";
		List<DatasourceField> body = getSampleRequest("merge/payload/MergeDatasourceFields.json", new TypeReference<List<DatasourceField>>(){});
		
		String resourcePath = "/merge/{userId}/files/{fileId}/datasources".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("new_type", targetType);
		mockRequest = mockRequest.withParam("email_results", emailResults);
		mockRequest = mockRequest.withParam("assembly_name", assemblyName);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/MergeDatasourceFields.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			MergeTemplateResponse response = api.MergeDatasourceFields(userId, fileId, targetType, emailResults, assemblyName, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetQuestionnaire() throws Exception {
		// sample parameters
		String userId = "userId";
		String questionnaireId = "questionnaireId";
		
		String resourcePath = "/merge/{userId}/questionnaires/{questionnaireId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "questionnaireId" + "}", String.valueOf(questionnaireId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/GetQuestionnaire.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetQuestionnaireResponse response = api.GetQuestionnaire(userId, questionnaireId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetQuestionnaires() throws Exception {
		// sample parameters
		String userId = "userId";
		String status = "status";
		Integer pageNumber = 0;
		Integer pageSize = 0;
		
		String resourcePath = "/merge/{userId}/questionnaires".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("status", status);
		mockRequest = mockRequest.withParam("page_number", pageNumber);
		mockRequest = mockRequest.withParam("page_size", pageSize);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/GetQuestionnaires.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetQuestionnairesResponse response = api.GetQuestionnaires(userId, status, pageNumber, pageSize);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCreateQuestionnaire() throws Exception {
		// sample parameters
		String userId = "userId";
		QuestionnaireInfo body = getSampleRequest("merge/payload/CreateQuestionnaire.json", new TypeReference<QuestionnaireInfo>(){});
		
		String resourcePath = "/merge/{userId}/questionnaires".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/CreateQuestionnaire.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			CreateQuestionnaireResponse response = api.CreateQuestionnaire(userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUpdateQuestionnaire() throws Exception {
		// sample parameters
		String userId = "userId";
		String questionnaireId = "questionnaireId";
		QuestionnaireInfo body = getSampleRequest("merge/payload/UpdateQuestionnaire.json", new TypeReference<QuestionnaireInfo>(){});
		
		String resourcePath = "/merge/{userId}/questionnaires/{questionnaireId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "questionnaireId" + "}", String.valueOf(questionnaireId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/UpdateQuestionnaire.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UpdateQuestionnaireResponse response = api.UpdateQuestionnaire(userId, questionnaireId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteQuestionnaire() throws Exception {
		// sample parameters
		String userId = "userId";
		String questionnaireId = "questionnaireId";
		
		String resourcePath = "/merge/{userId}/questionnaires/{questionnaireId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "questionnaireId" + "}", String.valueOf(questionnaireId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/DeleteQuestionnaire.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteQuestionnaireResponse response = api.DeleteQuestionnaire(userId, questionnaireId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetDocumentQuestionnaires() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/merge/{userId}/files/{fileId}/questionnaires".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/GetDocumentQuestionnaires.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetDocumentQuestionnairesResponse response = api.GetDocumentQuestionnaires(userId, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCreateDocumentQuestionnaire() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		QuestionnaireInfo body = getSampleRequest("merge/payload/CreateDocumentQuestionnaire.json", new TypeReference<QuestionnaireInfo>(){});
		
		String resourcePath = "/merge/{userId}/files/{fileId}/questionnaires".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/CreateDocumentQuestionnaire.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddDocumentQuestionnaireResponse response = api.CreateDocumentQuestionnaire(userId, fileId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddDocumentQuestionnaire() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String questionnaireId = "questionnaireId";
		
		String resourcePath = "/merge/{userId}/files/{fileId}/questionnaires/{questionnaireId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "questionnaireId" + "}", String.valueOf(questionnaireId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/AddDocumentQuestionnaire.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddDocumentQuestionnaireResponse response = api.AddDocumentQuestionnaire(userId, fileId, questionnaireId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteDocumentQuestionnaire() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String questionnaireId = "questionnaireId";
		
		String resourcePath = "/merge/{userId}/files/{fileId}/questionnaires/{questionnaireId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "questionnaireId" + "}", String.valueOf(questionnaireId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/DeleteDocumentQuestionnaire.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteDocumentQuestionnaireResponse response = api.DeleteDocumentQuestionnaire(userId, fileId, questionnaireId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Ignore("wrong input json")
	@Test
	public void testAddDataSource() throws Exception {
		// sample parameters
		String userId = "userId";
		Datasource body = getSampleRequest("merge/payload/AddDataSource.json", new TypeReference<Datasource>(){});
		
		String resourcePath = "/merge/{userId}/datasources".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/AddDataSource.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddDatasourceResponse response = api.AddDataSource(userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Ignore("wrong input json")
	@Test
	public void testUpdateDataSource() throws Exception {
		// sample parameters
		String userId = "userId";
		String datasourceId = "datasourceId";
		Datasource body = getSampleRequest("merge/payload/UpdateDataSource.json", new TypeReference<Datasource>(){});
		
		String resourcePath = "/merge/{userId}/datasources/{datasourceId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "datasourceId" + "}", String.valueOf(datasourceId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/UpdateDataSource.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddDatasourceResponse response = api.UpdateDataSource(userId, datasourceId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUpdateDataSourceFields() throws Exception {
		// sample parameters
		String userId = "userId";
		String datasourceId = "datasourceId";
		Datasource body = getSampleRequest("merge/payload/UpdateDataSourceFields.json", new TypeReference<Datasource>(){});
		
		String resourcePath = "/merge/{userId}/datasources/{datasourceId}/fields".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "datasourceId" + "}", String.valueOf(datasourceId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/UpdateDataSourceFields.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddDatasourceResponse response = api.UpdateDataSourceFields(userId, datasourceId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteDataSource() throws Exception {
		// sample parameters
		String userId = "userId";
		String datasourceId = "datasourceId";
		
		String resourcePath = "/merge/{userId}/datasources/{datasourceId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "datasourceId" + "}", String.valueOf(datasourceId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/DeleteDataSource.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteDatasourceResponse response = api.DeleteDataSource(userId, datasourceId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetDataSource() throws Exception {
		// sample parameters
		String userId = "userId";
		String datasourceId = "datasourceId";
		String fields = "fields";
		
		String resourcePath = "/merge/{userId}/datasources/{datasourceId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "datasourceId" + "}", String.valueOf(datasourceId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("field", fields);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/GetDataSource.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetDatasourceResponse response = api.GetDataSource(userId, datasourceId, fields);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetQuestionnaireDataSources() throws Exception {
		// sample parameters
		String userId = "userId";
		String questionnaireId = "questionnaireId";
		Boolean includeFields = Boolean.TRUE;
		
		String resourcePath = "/merge/{userId}/questionnaires/{questionnaireId}/datasources".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "questionnaireId" + "}", String.valueOf(questionnaireId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("include_fields", includeFields);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/GetQuestionnaireDataSources.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetDatasourcesResponse response = api.GetQuestionnaireDataSources(userId, questionnaireId, includeFields);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddQuestionnaireExecution() throws Exception {
		// sample parameters
		String userId = "userId";
		String collectorId = "collectorId";
		QuestionnaireExecutionInfo body = getSampleRequest("merge/payload/AddQuestionnaireExecution.json", new TypeReference<QuestionnaireExecutionInfo>(){});
		
		String resourcePath = "/merge/{userId}/questionnaires/collectors/{collectorId}/executions".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "collectorId" + "}", String.valueOf(collectorId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/AddQuestionnaireExecution.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddQuestionnaireExecutionResponse response = api.AddQuestionnaireExecution(userId, collectorId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetQuestionnaireCollectorExecutions() throws Exception {
		// sample parameters
		String userId = "userId";
		String collectorId = "collectorId";
		
		String resourcePath = "/merge/{userId}/questionnaires/collectors/{collectorId}/executions".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "collectorId" + "}", String.valueOf(collectorId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/GetQuestionnaireCollectorExecutions.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetQuestionnaireExecutionsResponse response = api.GetQuestionnaireCollectorExecutions(userId, collectorId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetQuestionnaireExecutions() throws Exception {
		// sample parameters
		String userId = "userId";
		String questionnaireId = "questionnaireId";
		
		String resourcePath = "/merge/{userId}/questionnaires/{questionnaireId}/executions".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "questionnaireId" + "}", String.valueOf(questionnaireId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/GetQuestionnaireExecutions.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetQuestionnaireExecutionsResponse response = api.GetQuestionnaireExecutions(userId, questionnaireId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetQuestionnaireExecution() throws Exception {
		// sample parameters
		String userId = "userId";
		String executionId = "executionId";
		
		String resourcePath = "/merge/{userId}/questionnaires/executions/{executionId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "executionId" + "}", String.valueOf(executionId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/GetQuestionnaireExecution.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetQuestionnaireExecutionResponse response = api.GetQuestionnaireExecution(userId, executionId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteQuestionnaireExecution() throws Exception {
		// sample parameters
		String userId = "userId";
		String executionId = "executionId";
		
		String resourcePath = "/merge/{userId}/questionnaires/executions/{executionId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "executionId" + "}", String.valueOf(executionId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/DeleteQuestionnaireExecution.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteQuestionnaireExecutionResponse response = api.DeleteQuestionnaireExecution(userId, executionId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUpdateQuestionnaireExecution() throws Exception {
		// sample parameters
		String userId = "userId";
		String executionId = "executionId";
		QuestionnaireExecutionInfo body = getSampleRequest("merge/payload/UpdateQuestionnaireExecution.json", new TypeReference<QuestionnaireExecutionInfo>(){});
		
		String resourcePath = "/merge/{userId}/questionnaires/executions/{executionId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "executionId" + "}", String.valueOf(executionId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/UpdateQuestionnaireExecution.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UpdateQuestionnaireExecutionResponse response = api.UpdateQuestionnaireExecution(userId, executionId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUpdateQuestionnaireExecutionStatus() throws Exception {
		// sample parameters
		String userId = "userId";
		String executionId = "executionId";
		String body = "body";
		
		String resourcePath = "/merge/{userId}/questionnaires/executions/{executionId}/status".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "executionId" + "}", String.valueOf(executionId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("merge/UpdateQuestionnaireExecutionStatus.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UpdateQuestionnaireExecutionResponse response = api.UpdateQuestionnaireExecutionStatus(userId, executionId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	
}

