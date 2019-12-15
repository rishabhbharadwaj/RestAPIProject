package com.qa.client;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {

	//1. GET Method
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url); //HTTP get request
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet); // hit the GET URL
		
		return closeableHttpResponse;
		
	}
	
	
	
	
	
	
	
	
	
	
}
