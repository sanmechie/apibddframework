package com.apiEngine;

import io.restassured.response.Response;

public interface IRestResponse<T> {
	/***
	 * 
	 * Generic Response Interface
	 */
	
	public T getBody();
	
	public String getContent();
	
	public int getStatusCode();
	
	public boolean isSuccessful();
	
	public Response getResponse();
	
	public Exception getException();
	
	


}
