package com.stepDefinitions;

import org.junit.Assert;
import com.apiEngine.IRestResponse;
import com.enums.Context;
import com.model.MakePost;
import com.model.MakePostResponse;
import com.utilities.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MakePostSteps extends BaseSteps {
	
	/***
	 * 
	 * This class defines steps required for MakePosts Feature
	 */

	public MakePostSteps(TestContext testContext) {
		super(testContext);
	}

	private static IRestResponse<MakePostResponse> makePostResponse;

	@When("I make a post with {int}, {string}, {string}")
	public void i_make_a_post_with(int userID, String title, String body) {
		MakePost makePost = new MakePost(userID, title, body);
		makePostResponse = getEndPoints().makePosts(makePost);
		getScenarioContext().setContext(Context.RESPONSE, makePostResponse.getResponse());
		getScenarioContext().setContext(Context.MAKEPOST_ID, makePostResponse.getBody().id);
	}

	@Then("A valid response {int}, {string}, {string}")
	public void a_valid_response(int userId, String title, String body) {
		Assert.assertEquals(body, makePostResponse.getBody().body);
		Assert.assertEquals(title, makePostResponse.getBody().title);
		Assert.assertEquals(userId, makePostResponse.getBody().userId);
	}

	@Then("I can retrieve that post {int}, {string}, {string} with {int}")
	public void retrieve_that_post(int userId, String title, String body, int status_code) {
		int postId = (Integer) getScenarioContext().getContext(Context.MAKEPOST_ID);
		makePostResponse = getEndPoints().getPosts(postId);
		Assert.assertEquals(body, makePostResponse.getBody().body);
		Assert.assertEquals(title, makePostResponse.getBody().title);
		Assert.assertEquals(userId, makePostResponse.getBody().userId);
		Assert.assertEquals(status_code, makePostResponse.getStatusCode());
	}

}
