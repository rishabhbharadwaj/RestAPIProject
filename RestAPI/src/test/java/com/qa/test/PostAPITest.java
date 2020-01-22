package com.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

public class PostAPITest extends TestBase{
	
	TestBase testBase;
	String serviceURL;
	String apiURL;
	String url;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;
	String jsonFilePath;

	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		testBase = new TestBase();
		serviceURL = prop.getProperty("URL");
		apiURL = prop.getProperty("serviceURL");
		url = serviceURL + apiURL;
		jsonFilePath = prop.getProperty("jsonFilePath");
	}
	
	@Test
	public void postAPITest() throws Exception {
		restClient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-type", "application/json");
		
		// JACKSON API for marshaling (conversion of java object to JSON) 
		ObjectMapper objectMapper = new ObjectMapper();
		Users users = new Users("Rishabh","Leader");
		
		//convert java object to JSON file
		objectMapper.writeValue(new File(jsonFilePath), users);
		
		// object to JSON in String
		String userJsonString = objectMapper.writeValueAsString(users);
		closeableHttpResponse = restClient.post(url, userJsonString, headerMap);
		
		//1. status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_201);
	
		//2. JSON string
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		objectMapper.readValue(responseString, Users.class);
		
		
	}
}
