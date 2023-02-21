package com.model;

public class Comments {
	
	/***
	 * 
	 * POJO for Comment Feature
	 */

	public int postId;
	public String name;
	public String email;
	public String body;

	public Comments(int postId, String name, String email, String body) {

		this.postId = postId;
		this.name = name;
		this.email = email;
		this.body = body;
	}

}
