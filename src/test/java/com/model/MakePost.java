package com.model;

public class MakePost {
	/***
	 * 
	 * POJO for Make Post
	 */

	public int userId;
	public String title;
	public String body;

	public MakePost(int userId, String title, String body) {

		this.userId = userId;
		this.title = title;
		this.body = body;
	}
	
}
