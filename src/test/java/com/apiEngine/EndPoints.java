package com.apiEngine;

import com.model.Comments;
import com.model.CommentsResponse;
import com.model.ListUserResponse;
import com.model.MakePost;
import com.model.MakePostResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndPoints {
	
	/***
	 * 
	 * Class initializing Base URL and wrapper methods to perform and return response
	 */

	private final RequestSpecification request;

	public EndPoints(String baseUrl) {
		RestAssured.baseURI = baseUrl;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
	}

	public IRestResponse<MakePostResponse> makePosts(MakePost makepost) {

		Response response = request.body(makepost).post(Routes.posts());
		return new RestResponse<MakePostResponse>(MakePostResponse.class, response);

	}
	
	public IRestResponse<MakePostResponse> getPosts() {

		Response response = request.get(Routes.posts());
		return new RestResponse<MakePostResponse>(MakePostResponse.class, response);

	}
	
	public IRestResponse<MakePostResponse> getPosts(int postID) {

		Response response = request.get(Routes.posts() + "/" + postID);
		return new RestResponse<MakePostResponse>(MakePostResponse.class, response);

	}

	
	public IRestResponse<CommentsResponse> postComments(Comments comments) {

		Response response = request.body(comments).post(Routes.comments());
		return new RestResponse<CommentsResponse>(CommentsResponse.class, response);

	}
	
	public IRestResponse<ListUserResponse> getUserResponse(int userID) {

		Response response = request.get(Routes.users() + "/" + userID);
		return new RestResponse<ListUserResponse>(ListUserResponse.class, response);

	}

	public IRestResponse<ListUserResponse> getUserResponse() {

		Response response = request.get(Routes.users());
		return new RestResponse<ListUserResponse>(ListUserResponse.class, response);

	}

}
