package com.stepDefinitions;

import org.junit.Assert;
import com.apiEngine.IRestResponse;
import com.enums.Context;
import com.model.Comments;
import com.model.CommentsResponse;
import com.utilities.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class CommentSteps extends BaseSteps {
	/***
	 * 
	 * This class defines steps required for Comments Feature
	 */

	public CommentSteps(TestContext testContext) {
		super(testContext);
	}

	private static IRestResponse<CommentsResponse> commentResponse;


	@When("I comment using {int}, {string}, {string}, {string}")
	public void i_comment_using(int postID, String name, String email, String body) {
		Comments comment = new Comments(postID, name, email, body);
		commentResponse = getEndPoints().postComments(comment);
		getScenarioContext().setContext(Context.RESPONSE, commentResponse.getResponse());
	}

	@Then("A valid response {int}, {string}, {string}, {string}")
	public void a_valid_response(int postID, String name, String email, String body) {
		Assert.assertEquals(body, commentResponse.getBody().body);
		Assert.assertEquals(name, commentResponse.getBody().name);
		Assert.assertEquals(email, commentResponse.getBody().email);
		Assert.assertEquals( postID, commentResponse.getBody().postId);

	}



}
