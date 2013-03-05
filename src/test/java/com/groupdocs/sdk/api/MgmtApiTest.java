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
import com.groupdocs.sdk.model.UpdateStorageProviderResponse;
import com.groupdocs.sdk.model.DeleteAccountUserResponse;
import com.groupdocs.sdk.model.UserInfoResponse;
import com.groupdocs.sdk.model.UserInfo;
import com.groupdocs.sdk.model.SetUserRolesResponse;
import com.groupdocs.sdk.model.UpdateAccountUserResponse;
import com.groupdocs.sdk.model.ResetPasswordResponse;
import com.groupdocs.sdk.model.GetStorageProvidersResponse;
import com.groupdocs.sdk.model.StorageProviderInfo;
import com.groupdocs.sdk.model.ChangePasswordResponse;
import com.groupdocs.sdk.model.AddStorageProviderResponse;
import com.groupdocs.sdk.model.UpdateUserResponse;
import com.groupdocs.sdk.model.UserPasswordInfo;
import com.groupdocs.sdk.model.GetAccountResponse;
import com.groupdocs.sdk.model.CreateUserResponse;
import com.groupdocs.sdk.model.GetRolesResponse;
import com.groupdocs.sdk.model.GetUserEmbedKeyResponse;
import com.groupdocs.sdk.model.DeleteAccountResponse;
import com.groupdocs.sdk.model.RoleInfo;
import com.groupdocs.sdk.model.GetAccountUsersResponse;


public class MgmtApiTest extends AbstractUnitTest {
  
	MgmtApi api;
	
	@Rule
	public ClientDriverRule driver = new ClientDriverRule();
	
	@Before
	public void setUpBefore() throws Exception {
		api = new MgmtApi();
		api.setBasePath(driver.getBaseUrl());
	}

	@Test
	public void testGetUserProfile() throws Exception {
		// sample parameters
		String userId = "userId";
		
		String resourcePath = "/mgmt/{userId}/profile".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/GetUserProfile.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UserInfoResponse response = api.GetUserProfile(userId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUpdateUserProfile() throws Exception {
		// sample parameters
		String userId = "userId";
		UserInfo body = getSampleRequest("mgmt/payload/UpdateUserProfile.json", new TypeReference<UserInfo>(){});
		
		String resourcePath = "/mgmt/{userId}/profile".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/UpdateUserProfile.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UpdateUserResponse response = api.UpdateUserProfile(userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testChangeUserPassword() throws Exception {
		// sample parameters
		String userId = "userId";
		UserPasswordInfo body = getSampleRequest("mgmt/payload/ChangeUserPassword.json", new TypeReference<UserPasswordInfo>(){});
		
		String resourcePath = "/mgmt/{userId}/profile/password".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/ChangeUserPassword.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			ChangePasswordResponse response = api.ChangeUserPassword(userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetUserProfileByResetToken() throws Exception {
		// sample parameters
		String callerId = "callerId";
		String token = "token";
		
		String resourcePath = "/mgmt/{callerId}/reset-tokens".replace("{" + "callerId" + "}", String.valueOf(callerId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("token", token);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/GetUserProfileByResetToken.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UserInfoResponse response = api.GetUserProfileByResetToken(callerId, token);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetUserProfileByVerifToken() throws Exception {
		// sample parameters
		String callerId = "callerId";
		String token = "token";
		
		String resourcePath = "/mgmt/{callerId}/verif-tokens".replace("{" + "callerId" + "}", String.valueOf(callerId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("token", token);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/GetUserProfileByVerifToken.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UserInfoResponse response = api.GetUserProfileByVerifToken(callerId, token);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetUserProfileByClaimedToken() throws Exception {
		// sample parameters
		String callerId = "callerId";
		String token = "token";
		
		String resourcePath = "/mgmt/{callerId}/claimed-tokens".replace("{" + "callerId" + "}", String.valueOf(callerId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("token", token);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/GetUserProfileByClaimedToken.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UserInfoResponse response = api.GetUserProfileByClaimedToken(callerId, token);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetAlienUserProfile() throws Exception {
		// sample parameters
		String callerId = "callerId";
		String userId = "userId";
		
		String resourcePath = "/mgmt/{callerId}/users/{userId}/profile".replace("{" + "callerId" + "}", String.valueOf(callerId)).replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/GetAlienUserProfile.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UserInfoResponse response = api.GetAlienUserProfile(callerId, userId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUpdateAlienUserProfile() throws Exception {
		// sample parameters
		String callerId = "callerId";
		String userId = "userId";
		UserInfo body = getSampleRequest("mgmt/payload/UpdateAlienUserProfile.json", new TypeReference<UserInfo>(){});
		
		String resourcePath = "/mgmt/{callerId}/users/{userId}/profile".replace("{" + "callerId" + "}", String.valueOf(callerId)).replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/UpdateAlienUserProfile.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UpdateUserResponse response = api.UpdateAlienUserProfile(callerId, userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCreateUser() throws Exception {
		// sample parameters
		String callerId = "callerId";
		UserInfo body = getSampleRequest("mgmt/payload/CreateUser.json", new TypeReference<UserInfo>(){});
		
		String resourcePath = "/mgmt/{callerId}/users".replace("{" + "callerId" + "}", String.valueOf(callerId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/CreateUser.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			CreateUserResponse response = api.CreateUser(callerId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testCreateUserLogin() throws Exception {
		// sample parameters
		String callerId = "callerId";
		String userId = "userId";
		String password = "password";
		
		String resourcePath = "/mgmt/{callerId}/users/{userId}/logins".replace("{" + "callerId" + "}", String.valueOf(callerId)).replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("password", password);
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/CreateUserLogin.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UserInfoResponse response = api.CreateUserLogin(callerId, userId, password);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testChangeAlienUserPassword() throws Exception {
		// sample parameters
		String callerId = "callerId";
		String userId = "userId";
		UserPasswordInfo body = getSampleRequest("mgmt/payload/ChangeAlienUserPassword.json", new TypeReference<UserPasswordInfo>(){});
		
		String resourcePath = "/mgmt/{callerId}/users/{userId}/password".replace("{" + "callerId" + "}", String.valueOf(callerId)).replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/ChangeAlienUserPassword.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			ChangePasswordResponse response = api.ChangeAlienUserPassword(callerId, userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testResetUserPassword() throws Exception {
		// sample parameters
		String callerId = "callerId";
		String userId = "userId";
		
		String resourcePath = "/mgmt/{callerId}/users/{userId}/password".replace("{" + "callerId" + "}", String.valueOf(callerId)).replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/ResetUserPassword.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			ResetPasswordResponse response = api.ResetUserPassword(callerId, userId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetStorageProviders() throws Exception {
		// sample parameters
		String userId = "userId";
		
		String resourcePath = "/mgmt/{userId}/storages".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/GetStorageProviders.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetStorageProvidersResponse response = api.GetStorageProviders(userId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testAddStorageProvider() throws Exception {
		// sample parameters
		String userId = "userId";
		String provider = "provider";
		StorageProviderInfo body = getSampleRequest("mgmt/payload/AddStorageProvider.json", new TypeReference<StorageProviderInfo>(){});
		
		String resourcePath = "/mgmt/{userId}/storages/{provider}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "provider" + "}", String.valueOf(provider));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.POST).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/AddStorageProvider.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			AddStorageProviderResponse response = api.AddStorageProvider(userId, provider, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUpdateStorageProvider() throws Exception {
		// sample parameters
		String userId = "userId";
		String provider = "provider";
		StorageProviderInfo body = getSampleRequest("mgmt/payload/UpdateStorageProvider.json", new TypeReference<StorageProviderInfo>(){});
		
		String resourcePath = "/mgmt/{userId}/storages/{provider}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "provider" + "}", String.valueOf(provider));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/UpdateStorageProvider.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UpdateStorageProviderResponse response = api.UpdateStorageProvider(userId, provider, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetRoles() throws Exception {
		// sample parameters
		String userId = "userId";
		
		String resourcePath = "/mgmt/{userId}/roles".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/GetRoles.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetRolesResponse response = api.GetRoles(userId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetUserRoles() throws Exception {
		// sample parameters
		String callerId = "callerId";
		String userId = "userId";
		
		String resourcePath = "/mgmt/{callerId}/users/{userId}/roles".replace("{" + "callerId" + "}", String.valueOf(callerId)).replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/GetUserRoles.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetRolesResponse response = api.GetUserRoles(callerId, userId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSetUserRoles() throws Exception {
		// sample parameters
		String callerId = "callerId";
		String userId = "userId";
		List<RoleInfo> body = getSampleRequest("mgmt/payload/SetUserRoles.json", new TypeReference<List<RoleInfo>>(){});
		
		String resourcePath = "/mgmt/{callerId}/users/{userId}/roles".replace("{" + "callerId" + "}", String.valueOf(callerId)).replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/SetUserRoles.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SetUserRolesResponse response = api.SetUserRoles(callerId, userId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetAccount() throws Exception {
		// sample parameters
		String userId = "userId";
		
		String resourcePath = "/mgmt/{userId}/account".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/GetAccount.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetAccountResponse response = api.GetAccount(userId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteAccount() throws Exception {
		// sample parameters
		String userId = "userId";
		
		String resourcePath = "/mgmt/{userId}/account".replace("{" + "userId" + "}", String.valueOf(userId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/DeleteAccount.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteAccountResponse response = api.DeleteAccount(userId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetAccountUsers() throws Exception {
		// sample parameters
		String adminId = "adminId";
		
		String resourcePath = "/mgmt/{adminId}/account/users".replace("{" + "adminId" + "}", String.valueOf(adminId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/GetAccountUsers.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetAccountUsersResponse response = api.GetAccountUsers(adminId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testUpdateAccountUser() throws Exception {
		// sample parameters
		String adminId = "adminId";
		String userName = "userName";
		UserInfo body = getSampleRequest("mgmt/payload/UpdateAccountUser.json", new TypeReference<UserInfo>(){});
		
		String resourcePath = "/mgmt/{adminId}/account/users/{userName}".replace("{" + "adminId" + "}", String.valueOf(adminId)).replace("{" + "userName" + "}", String.valueOf(userName));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/UpdateAccountUser.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			UpdateAccountUserResponse response = api.UpdateAccountUser(adminId, userName, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testDeleteAccountUser() throws Exception {
		// sample parameters
		String adminId = "adminId";
		String userName = "userName";
		
		String resourcePath = "/mgmt/{adminId}/account/users/{userName}".replace("{" + "adminId" + "}", String.valueOf(adminId)).replace("{" + "userName" + "}", String.valueOf(userName));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.DELETE).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/DeleteAccountUser.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			DeleteAccountUserResponse response = api.DeleteAccountUser(adminId, userName);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetUserEmbedKey() throws Exception {
		// sample parameters
		String userId = "userId";
		String area = "area";
		
		String resourcePath = "/mgmt/{userId}/embedkey/{area}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "area" + "}", String.valueOf(area));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/GetUserEmbedKey.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetUserEmbedKeyResponse response = api.GetUserEmbedKey(userId, area);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetUserEmbedKeyFromGuid() throws Exception {
		// sample parameters
		String callerId = "callerId";
		String guid = "guid";
		
		String resourcePath = "/mgmt/{callerId}/embedkey/guid/{guid}".replace("{" + "callerId" + "}", String.valueOf(callerId)).replace("{" + "guid" + "}", String.valueOf(guid));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/GetUserEmbedKeyFromGuid.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetUserEmbedKeyResponse response = api.GetUserEmbedKeyFromGuid(callerId, guid);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGenerateKeyForUser() throws Exception {
		// sample parameters
		String userId = "userId";
		String area = "area";
		
		String resourcePath = "/mgmt/{userId}/embedkey/new/{area}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "area" + "}", String.valueOf(area));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("mgmt/GenerateKeyForUser.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetUserEmbedKeyResponse response = api.GenerateKeyForUser(userId, area);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	
}

