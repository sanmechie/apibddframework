package com.utilities;

import com.apiDataProvider.APIConfigFileReader;
import com.apiEngine.EndPoints;

public class TestContext {
	
	private EndPoints endPoints;
	private ScenarioContext scenarioContext;
	
	public TestContext() {
		endPoints = new EndPoints(APIConfigFileReader.getInstance().getBaseUrl());
		scenarioContext = new ScenarioContext();
	}
	
	 public EndPoints getEndPoints() {
        return endPoints;
    }
	 
	 public ScenarioContext getScenarioContext() {
			return scenarioContext;
		}
}