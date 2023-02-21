package com.stepDefinitions;

import com.apiEngine.IRestResponse;
import com.enums.Context;
import com.model.ListUserResponse;
import com.utilities.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class ListUserSteps extends BaseSteps {
	
	/***
	 * 
	 * This class defines steps required for List Users Feature
	 */

	private static IRestResponse<ListUserResponse> listUserResponse;

	public ListUserSteps(TestContext testContext) {
		super(testContext);
	}

	@When("I access a User with {int}")
	public void i_access_a_User_with(int userID) {
		listUserResponse = getEndPoints().getUserResponse(userID);
		getScenarioContext().setContext(Context.RESPONSE, listUserResponse.getResponse());

	}

	@Then("I should get correct {string} and {string}")
	public void i_should_get_correct_and(String name, String userName) {
		Assert.assertEquals(name, listUserResponse.getBody().name);
		Assert.assertEquals(userName, listUserResponse.getBody().username);

	}

	@When("I access all available Users")
	public void i_access_all_available_Users() {
		listUserResponse = getEndPoints().getUserResponse();
		getScenarioContext().setContext(Context.RESPONSE, listUserResponse.getResponse());
	}

}
