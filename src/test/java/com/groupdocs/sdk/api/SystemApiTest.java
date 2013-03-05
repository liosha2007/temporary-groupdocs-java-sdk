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
import com.groupdocs.sdk.model.GetCountriesResponse;
import com.groupdocs.sdk.model.GetPlanResponse;
import com.groupdocs.sdk.model.SubscriptionPlanInfo;
import com.groupdocs.sdk.model.GetUserSubscriptionPlanResponse;
import com.groupdocs.sdk.model.GetSubscriptionPlansResponse;
import com.groupdocs.sdk.model.GetStatesResponse;
import com.groupdocs.sdk.model.SetUserSubscriptionPlanResponse;


public class SystemApiTest extends AbstractUnitTest {
  
	SystemApi api;
	
	@Rule
	public ClientDriverRule driver = new ClientDriverRule();
	
	@Before
	public void setUpBefore() throws Exception {
		api = new SystemApi();
		api.setBasePath(driver.getBaseUrl());
	}

	@Test
	public void testGetUserPlan() throws Exception {
		// sample parameters
		String callerId = "callerId";
		
		String resourcePath = "/system/{callerId}/plan".replace("{" + "callerId" + "}", String.valueOf(callerId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("system/GetUserPlan.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetPlanResponse response = api.GetUserPlan(callerId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetUserSubscriptionPlan() throws Exception {
		// sample parameters
		String callerId = "callerId";
		
		String resourcePath = "/system/{callerId}/subscription".replace("{" + "callerId" + "}", String.valueOf(callerId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("system/GetUserSubscriptionPlan.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetUserSubscriptionPlanResponse response = api.GetUserSubscriptionPlan(callerId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testGetSubscriptionPlans() throws Exception {
		// sample parameters
		String callerId = "callerId";
		String family = "family";
		
		String resourcePath = "/system/{callerId}/plans/{family}".replace("{" + "callerId" + "}", String.valueOf(callerId)).replace("{" + "family" + "}", String.valueOf(family));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("system/GetSubscriptionPlans.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetSubscriptionPlansResponse response = api.GetSubscriptionPlans(callerId, family);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Test
	public void testSetSubscriptionPlan() throws Exception {
		// sample parameters
		String userId = "userId";
		String productId = "productId";
		SubscriptionPlanInfo body = getSampleRequest("system/payload/SetSubscriptionPlan.json", new TypeReference<SubscriptionPlanInfo>(){});
		
		String resourcePath = "/system/{userId}/subscriptions/{productId}".replace("{" + "userId" + "}", String.valueOf(userId)).replace("{" + "productId" + "}", String.valueOf(productId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.PUT).withHeader("Content-Type", MediaType.APPLICATION_JSON);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("system/SetSubscriptionPlan.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			SetUserSubscriptionPlanResponse response = api.SetSubscriptionPlan(userId, productId, body);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Ignore("upper case property name can't be deserialized")
	@Test
	public void testGetCountries() throws Exception {
		// sample parameters
		String callerId = "callerId";
		
		String resourcePath = "/system/{callerId}/countries".replace("{" + "callerId" + "}", String.valueOf(callerId));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("system/GetCountries.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetCountriesResponse response = api.GetCountries(callerId);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	@Ignore("upper case property name can't be deserialized")
	@Test
	public void testGetStates() throws Exception {
		// sample parameters
		String callerId = "callerId";
		String countryName = "countryName";
		
		String resourcePath = "/system/{callerId}/countries/{countryName}/states".replace("{" + "callerId" + "}", String.valueOf(callerId)).replace("{" + "countryName" + "}", String.valueOf(countryName));
		
		ClientDriverRequest mockRequest = onRequestTo(resourcePath).withMethod(Method.GET).withHeader("Content-Type", MediaType.TEXT_HTML);
		// add query parameters to expectation
		mockRequest = mockRequest.withParam("signature", Pattern.compile(".*"));
		// read response json from file
		String responseBody = getSampleResponse("system/GetStates.json");
		
		ClientDriverResponse mockResponse = giveResponse(responseBody).withStatus(200);
		driver.addExpectation(mockRequest, mockResponse);
		
		try {
			GetStatesResponse response = api.GetStates(callerId, countryName);
			// this ensures that json was successfully deserialized into corresponding model object
			assertSameJson(responseBody, response);
			
		} catch(ApiException e){
			log(e.getCode() + ": " + e.getMessage());
		}
	
	}
	
	
}

