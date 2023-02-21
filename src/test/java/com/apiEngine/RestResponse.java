package com.apiEngine;

import io.restassured.response.Response;

public class RestResponse<T> implements IRestResponse<T> {
	
	/***
	 * 
	 * Generic  method implementation of Rest Response interface
	 * required to validate and assert response data
	 */
	

	private T data;
	private Response response;
	private Exception e;

	public RestResponse(Class<T> t, Response response) {
		this.response = response;
		try {
			this.data = t.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			throw new RuntimeException("There should be a default constructor in the Response POJO");
		}
	}

	@SuppressWarnings("unchecked")
	public T getBody() {
		try {
			data = (T) response.getBody().as(data.getClass());
		} catch (Exception e) {
			this.e = e;
		}
		return data;
	}

	public String getContent() {
		return response.getBody().asString();
	}

	public int getStatusCode() {

		return response.getStatusCode();
	}

	public Response getResponse() {

		return response;
	}

	public Exception getException() {
		return e;
	}

	public boolean isSuccessful() {
		int code = response.getStatusCode();
		if (code == 200 || code == 201 || code == 202 || code == 203 || code == 204 || code == 205)
			return true;
		return false;
	}

}
