package com.apiEngine;

public class Routes {
	
	
    private static final String POSTS = "/posts";
    private static final String USERS = "/users";
    private static final String COMMENTS = "/comments";
    
    public static String posts(){
    	return POSTS;
    }
    
    public static String users(){
    	return USERS;
    }
    
    
    public static String comments(){
    	return COMMENTS;
    }

}
