# RestAssured Cucumber framework

<p align="center"> API BDD framework built using Java, restassured, cucumber
    <br> 
</p>

## 📝 Table of Contents

- [Introduction](#introduction)
- [Framework & Design Considerations](#FrameWork_Design)
- [Tech Stack](#stack)
- [Coverage](#coverage)
- [Structure](#structure)
- [Execution](#execution)
- [Improvements](#improvements)


## Introduction <a name = "Introduction"></a>

This is a framework for testing the Users, Posts and Comments endpoint of https://jsonplaceholder.typicode.com/


## Framework & Design Considerations <a name = "FrameWork_Design"></a>
- Rest assured is a java library for testing Restful Web services. It can be used to test XML & JSON based web services.
- API calls & validations are made using RestAssured in conjunction with Junit
- Each of the features are categorized into domain model packages
- These domain models are called from a step-definitions class which are in-turn called from BDD tests.
- Sharing of data between Scenarios and test can be done with Context under utilities package
- The API spec for schema comparison is placed inside "schemas" folder in test resources. The specs are generated from https://www.liquid-technologies.com/online-json-to-schema-converter.


## Tech stack <a name = "stack"></a>
1. Java 1.8
2. Maven 3.9
3. RestAsured 5.3.0
4. Junit 4.13
5. Cucumber 5.2.0

## Coverage <a name = "coverage"></a>
### **_Assumptions made_**:
1. Only "GET" method has been tested for /users endpoint
2. Only "POST" method has been tested for /posts and /comments endpoint
3. I couldn't get a clarification whether all methods such POST, DELETE, PATCH, PUT need to be tested for each of the endpoints
4. None of the Post requests for any of the endpoints are persisting. So I have added sample scenario in make post sections where I am creating a post and trying to list that post which fails

### **_Increasing_coverage_**
Since the requirements are not clear. So after discussing with PO,
The coverage can be increased by adding Tests for each of the methods such as PATCH, PUT and DELETE
For Ex: Create a user via /users endpoint and then using this userID make a post using /posts endpoint and then using this postID comment using /comments

## Project directory structure <a name = "structure"></a>

```Gherkin
src
  + test
    + java                          
      + dataProvider              Project Config reader        
      + apiEngine                 Generic Rest Response interface
      + enums                     enums
      + model                     Domain Model
      + runner                    Junit Runner
      + stepdefinitions           Methods for testing the features
      + utilites                  Scenario and Test Context
src
  + test
      + resources                 
        + features                Test Scenarios for features
        + schemas                 Folder containing json schema for API schema validation
src
  + configs                       Project Config
  
```
## Executing the tests <a name = "execution"></a>
Run `mvn clean verify` from the command line.

**Note**: Some test cases are expected to fail(around 5 are failing)

The test results will be recorded here `/target/cucumber-reports/index.html`.

## Improvements <a name = "improvements"></a>
1. Logging
2. Improve reporting feature 
3. Parallel execution 


