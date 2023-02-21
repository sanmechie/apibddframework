@comments
Feature: Commenting on posts using /comments endpoint of  https://jsonplaceholder.typicode.com/
Description: The tests will cover comments feature  using /comments


  @positive
  Scenario Outline: Test I can succesfully comment on a post using the /comments endpoint
    Given the base URL is set
    When I comment using <valid_data>
    Then I should recieve correct <status_code>
    And A valid response <valid_data> 
    #other examples could be testing for length of posts. 
    #Since it is not clear what is the max length, I have not included here
   Examples:
   
       | valid_data                        | status_code |
       | 1, "John", "Doe", "I am John Doe" | 201         |
   

  @negative #this should fail as post ID doesnt exist
  Scenario Outline: Test I cannot comment on post which doesnt exist
    Given the base URL is set
    When I comment using <invalid_data>
    Then I should recieve correct <status_code>
   Examples:
   
       | invalid_data                          | status_code |
       | 101, "John", "Doe", "I am John Doe" | 404         |
 
    @positive
  Scenario Outline: Test the response time  is within 1 sec when /comments endpoint is accessed i
    Given the base URL is set
    When I comment using <valid_data>
    Then the response time is within <acceptable> limits
   Examples:
   
       | valid_data                        | acceptable |
       | 1, "John", "Doe@biz.com", "I am John Doe" | 1         |
       
       
   @positive
  Scenario Outline: Test the response schema of comment created is valid
    Given the base URL is set
    When I comment using <valid_data>
    Then I should recieve correct <status_code>
    And A valid response as per "comments" defined schema 
   Examples:
   
       | valid_data                        | status_code |
       | 1, "John", "Doe", "I am John Doe" | 201         |
 
   @negative #this should fail as Payload is inocrrect
  Scenario Outline: Test I cannot comment on post when data is invalid
    Given the base URL is set
    When I comment using <invalid_data>
    Then I should recieve correct <status_code>
   Examples:
   
       | invalid_data                    | status_code |
       | 100, "", "Doe", "I am John Doe" | 404         |
       
 #Coverage can be increased by listing comments, patching comments, updating comments and deleting comments
       