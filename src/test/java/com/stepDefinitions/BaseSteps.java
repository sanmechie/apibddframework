package com.stepDefinitions;

import com.apiDataProvider.APIConfigFileReader;
import com.apiEngine.EndPoints;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import com.utilities.ScenarioContext;
import com.utilities.TestContext;
import io.restassured.response.Response;

public class BaseSteps {
	
	/***
	 * Base Steps for sharing Test Context and Scenario Context
	 */

	private EndPoints endPoints;
	private ScenarioContext scenarioContext;

	public BaseSteps(TestContext testContext) {
		endPoints = testContext.getEndPoints();
		scenarioContext = testContext.getScenarioContext();
	}

	public EndPoints getEndPoints() {
		return endPoints;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

	public void verifyResponseSchema(Response respone, String schema) {
		respone.then().body(matchesJsonSchemaInClasspath(APIConfigFileReader.getInstance().getSchemaPath() + schema));
	}

	public long getResponseTime(Response r) {
		return (r.getTime() / 1000) % 60;

	}
}
