package com.stepDefinitions;

import org.junit.Assert;

import com.enums.Context;
import com.utilities.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class CommonSteps extends BaseSteps {
	
	/***
	 * 
	 * This class defines common steps required for all Features
	 */

	public CommonSteps(TestContext testContext) {
		super(testContext);
	}

	@Given("the base URL is set")
	public void the_base_URL_is_set() {
		// BaseURL is already set-up through test context
	}

	@Then("A valid response as per {string} defined schema")
	public void a_valid_response_as_per_defined_schema(String responseType) throws Exception {
		String schemaFile = "";
		switch (responseType) {
		case "users":

			schemaFile = "listusers.json";
			break;
		case "posts":

			schemaFile = "makeposts.json";
		case "comments":

			schemaFile = "comments.json";
			break;
		default:
			throw new Exception("To validate schema options available as users, posts or comments");
		}

		Response r = (Response) getScenarioContext().getContext(Context.RESPONSE);
		verifyResponseSchema(r, schemaFile);
	}

	@Then("I should recieve correct {int}")
	public void i_should_recieve_correct_status_code(int status_code) {
		Response r = (Response) getScenarioContext().getContext(Context.RESPONSE);
		Assert.assertEquals(status_code, r.getStatusCode());
	}

	
	@Then("the response time is within {int} limits")
	public void the_response_time_is_within_limits(long expectedTime) {
		Response r = (Response) getScenarioContext().getContext(Context.RESPONSE);
		long actualTime = getResponseTime(r);
		Assert.assertTrue(actualTime < expectedTime);
	}
	
	
	@Then("content type in response header should contain {string}")
	public void content_type_in_response_header_should_contain(String content_type) {
		Response r = (Response) getScenarioContext().getContext(Context.RESPONSE);
		Assert.assertEquals(content_type, r.getContentType());
	}
	

}
