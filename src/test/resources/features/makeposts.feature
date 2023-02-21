
@makePosts
Feature: Making posts using /posts endpoint of  https://jsonplaceholder.typicode.com/
Description: The tests will cover posts feature  using /posts


  @positive
  Scenario Outline: Test I can succesfully create a Post with valid request using /posts endpoint
    Given the base URL is set
    When I make a post with <valid_data>
    Then I should recieve correct <status_code>
    And A valid response <valid_data> 
    #other examples could be testing for length of posts. 
    #Since it is not clear what is the max length, I have not included here
   Examples:
   
       | valid_data          | status_code |
       | 1, "hello", "World" | 201         |
       | 1, "%^&*(((", "**&&**" | 201         | #Testing specical characters
       
  @positive
  Scenario Outline: Test I can succesfully create a Post with valid request and retrieve that post
    Given the base URL is set
    When I make a post with <valid_data>
    Then I can retrieve that post <valid_data> with <status_code>
   # other examples could be testing for length of posts. 
   # Since it is not clear what is the max length, I have not included here
   Examples:
   
       | valid_data          | status_code |
       | 1, "hello", "World" | 201         |


   @positive
  Scenario Outline: Test the response schema of post creation is valid
    Given the base URL is set
    When I make a post with <valid_data>
    Then I should recieve correct <status_code>
    And A valid response as per "posts" defined schema

   Examples:
   
       | valid_data          | status_code |
       | 1, "hello", "World" | 201        |
 

   @positive
  Scenario Outline: Test the response time Test the response time is within 1 sec when /posts endpoint is accessed
    Given the base URL is set
    When I make a post with <valid_data>
    Then the response time is within <acceptable> limits
   Examples:
  
       | valid_data          |acceptable|
       | 1, "hello", "World" | 1        |
       
  @positive
   #Here based on clear requirement we can add scenarios for testing different response header
  Scenario Outline: Test header content type is correct in response for /posts endpoint
    Given the base URL is set
    When I make a post with <valid_data>
    Then content type in response header should contain <content_type>
    Examples:
    | valid_data             |content_type|
    |1, "hello", "World"|"application/json; charset=utf-8"| 
    
    
   @neagtive #these should fail
   #Here based on clear requirement we can add scenarios for testing diffent invalid payload
   #invalid payload should receive 400. In the below example body and title are empty
  Scenario Outline: Test I get an error when I make a post with invalid request
    Given the base URL is set
    When I make a post with <invalid_data>
    Then I should recieve correct <status_code>
    Examples:
    | invalid_data|status_code|
    |1, "", ""    |400        |
    |200, "", ""  |404        | # in this user doesnt exist in the system
    
  #Coverage can be increased by listing posts, patching posts, updating posts and deleting posts 
    