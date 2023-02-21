@listUsers
Feature: List Users using /users endpoint of  https://jsonplaceholder.typicode.com/
Description: The tests will list users features

  @positive
  Scenario Outline: Test I can succesfully list a user using the /users endpoint
    Given the base URL is set
    When I access a User with <valid_user_id>
    Then I should recieve correct <status_code>
    And I should get correct <name> and <username>
    Examples:
    |valid_user_id|status_code|name           |username|
    |1            |200        |"Leanne Graham"|"Bret"  |
 
  @positive
  Scenario: Test user response schema is valid
    Given the base URL is set
    When I access all available Users
    Then A valid response as per "users" defined schema
 
  @negative
  Scenario Outline: Test proper error code when no user exists
    Given the base URL is set
    When I access a User with <invalid_user_id>
    Then I should recieve correct <status_code> 
    Examples:
    |invalid_user_id|status_code|
    |100            |404        |
    |0              |404        |
    |-1             |404        |
 
 
    
  @positive
   #Here based on clear requirement we can add scenarios for testing different response header
  Scenario Outline: Test header content type is correct in response
    Given the base URL is set
    When I access a User with <valid_user_id>
    Then content type in response header should contain <content_type>
    Examples:
    |valid_user_id|content_type|
    |1            |"application/json; charset=utf-8"|  
    
    
   @positive
  Scenario Outline: Test the response time is within 1 sec when /users endpoint is accessed 
    Given the base URL is set
    When I access a User with <valid_user_id>
    Then the response time is within <acceptable> limits
    Examples:
    |valid_user_id|acceptable|
    |1            |1|
    