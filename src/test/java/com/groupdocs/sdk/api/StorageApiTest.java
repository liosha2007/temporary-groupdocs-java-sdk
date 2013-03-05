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
import com.groupdocs.sdk.model.CreateFolderResponse;
import com.groupdocs.sdk.model.FileMoveResponse;
import com.groupdocs.sdk.model.ListEntitiesResponse;
import com.groupdocs.sdk.model.CompressResponse;
import com.groupdocs.sdk.model.StorageInfoResponse;
import com.groupdocs.sdk.model.UploadResponse;
import com.groupdocs.sdk.model.DeleteResponse;
import com.groupdocs.sdk.model.FolderMoveResponse;
import com.groupdocs.sdk.model.CreatePackageResponse;


public class StorageApiTest extends AbstractUnitTest {
  
	StorageApi api;
	
	@Rule
	public ClientDriverRule driver = new ClientDriverRule();
	
	@Before
	public void setUpBefore() throws Exception {
		api = new StorageApi();
		api.setBasePath(driver.getBaseUrl());
	}

	@Test
	public void testGetStorageInfo() throws Exception {
		// sample parameters
		String userId = "userId";
		
		String resourcePath = "/storage/{userId}".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/GetStorageInfo.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			StorageInfoResponse response = api.GetStorageInfo(userId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testListEntities() throws Exception {
		// sample parameters
		String userId = "userId";
		String path = "path";
		Integer pageIndex = 0;
		Integer pageSize = 0;
		String orderBy = "orderBy";
		Boolean orderAsc = Boolean.TRUE;
		String filter = "filter";
		String fileTypes = "fileTypes";
		Boolean extended = Boolean.TRUE;
		
		String resourcePath = "/storage/{userId}/folders/{path}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("page", pageIndex);
		mockRequest = mockRequest.withParam("count", pageSize);
		mockRequest = mockRequest.withParam("order_by", orderBy);
		mockRequest = mockRequest.withParam("order_asc", orderAsc);
		mockRequest = mockRequest.withParam("filter", filter);
		mockRequest = mockRequest.withParam("file_types", fileTypes);
		mockRequest = mockRequest.withParam("extended", extended);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/ListEntities.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			ListEntitiesResponse response = api.ListEntities(userId, path, pageIndex, pageSize, orderBy, orderAsc, filter, fileTypes, extended);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetFile() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/storage/{userId}/files/{fileId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/GetFile.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			FileStream response = api.GetFile(userId, fileId);
			assertThat(response.getInputStream(), not(nullValue()));
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSharedFile() throws Exception {
		// sample parameters
		String userEmail = "userEmail";
		String filePath = "filePath";
		
		String resourcePath = "/storage/shared/{userEmail}/{filePath}".replace("{" + "userEmail" + "}", String.valueOf(userEmail)).replace("{" + "filePath" + "}", String.valueOf(filePath));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/GetSharedFile.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			FileStream response = api.GetSharedFile(userEmail, filePath);
			assertThat(response.getInputStream(), not(nullValue()));
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUpload() throws Exception {
		// sample parameters
		String userId = "userId";
		String path = "path";
		String description = "description";
		FileStream body = new FileStream(getClass().getClassLoader().getResourceAsStream("test.doc"));
		
		String resourcePath = "/storage/{userId}/folders/{path}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", Pattern.compile(".*"));
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("description", description);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/Upload.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UploadResponse response = api.Upload(userId, path, description, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDecompress() throws Exception {
		// sample parameters
		String userId = "userId";
		String path = "path";
		String description = "description";
		String archiveType = "archiveType";
		FileStream body = new FileStream(getClass().getClassLoader().getResourceAsStream("test.doc"));
		
		String resourcePath = "/storage/{userId}/decompress/{path}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", Pattern.compile(".*"));
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("description", description);
		mockRequest = mockRequest.withParam("archiveType", archiveType);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/Decompress.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UploadResponse response = api.Decompress(userId, path, description, archiveType, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUploadWeb() throws Exception {
		// sample parameters
		String userId = "userId";
		String url = "url";
		
		String resourcePath = "/storage/{userId}/urls".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("url", url);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/UploadWeb.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UploadResponse response = api.UploadWeb(userId, url);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUploadGoogle() throws Exception {
		// sample parameters
		String userId = "userId";
		String path = "path";
		String fileId = "fileId";
		
		String resourcePath = "/storage/{userId}/google/files/{path}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("file_id", fileId);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/UploadGoogle.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UploadResponse response = api.UploadGoogle(userId, path, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDelete() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		
		String resourcePath = "/storage/{userId}/files/{fileId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/Delete.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteResponse response = api.Delete(userId, fileId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteFromFolder() throws Exception {
		// sample parameters
		String userId = "userId";
		String path = "path";
		
		String resourcePath = "/storage/{userId}/folders/{path}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/DeleteFromFolder.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteResponse response = api.DeleteFromFolder(userId, path);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testMoveFile() throws Exception {
		// sample parameters
		String userId = "userId";
		String path = "path";
		String mode = "mode";
		String Groupdocs_Copy = "Groupdocs_Copy";
		String Groupdocs_Move = "Groupdocs_Move";
		
		String resourcePath = "/storage/{userId}/files/{path}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("mode", mode);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/MoveFile.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			FileMoveResponse response = api.MoveFile(userId, path, mode, Groupdocs_Copy, Groupdocs_Move);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testMoveFolder() throws Exception {
		// sample parameters
		String userId = "userId";
		String path = "path";
		String mode = "mode";
		String Groupdocs_Move = "Groupdocs_Move";
		String Groupdocs_Copy = "Groupdocs_Copy";
		
		String resourcePath = "/storage/{userId}/folders/{path}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("override_mode", mode);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/MoveFolder.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			FolderMoveResponse response = api.MoveFolder(userId, path, mode, Groupdocs_Move, Groupdocs_Copy);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCreate() throws Exception {
		// sample parameters
		String userId = "userId";
		String path = "path";
		
		String resourcePath = "/storage/{userId}/paths/{path}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/Create.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			CreateFolderResponse response = api.Create(userId, path);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCompress() throws Exception {
		// sample parameters
		String userId = "userId";
		String fileId = "fileId";
		String archiveType = "archiveType";
		
		String resourcePath = "/storage/{userId}/files/{fileId}/archive/{archiveType}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "fileId" + "}", String.valueOf(fileId)).replace("{" + "archiveType" + "}", String.valueOf(archiveType));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/Compress.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			CompressResponse response = api.Compress(userId, fileId, archiveType);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCreatePackage() throws Exception {
		// sample parameters
		String userId = "userId";
		String packageName = "packageName";
		Boolean storeRelativePath = Boolean.TRUE;
		List<String> body = getSampleRequest("storage/payload/CreatePackage.json", new TypeReference<List<String>>(){});
		
		String resourcePath = "/storage/{userId}/packages/{packageName}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "packageName" + "}", String.valueOf(packageName));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("storeRelativePath", storeRelativePath);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/CreatePackage.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			CreatePackageResponse response = api.CreatePackage(userId, packageName, storeRelativePath, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testMoveToTrash() throws Exception {
		// sample parameters
		String userId = "userId";
		String path = "path";
		
		String resourcePath = "/storage/{userId}/trash/{path}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/MoveToTrash.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			FolderMoveResponse response = api.MoveToTrash(userId, path);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testRestoreFromTrash() throws Exception {
		// sample parameters
		String userId = "userId";
		String path = "path";
		
		String resourcePath = "/storage/{userId}/trash/{path}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "path" + "}", String.valueOf(path));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("storage/RestoreFromTrash.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteResponse response = api.RestoreFromTrash(userId, path);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	
}

