package com.apiDataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class APIConfigFileReader {
	
	
	private Properties properties;
	private static APIConfigFileReader configReader;

    public APIConfigFileReader() {
		BufferedReader reader;
	    	String propertyFilePath = "configs//Configuration.properties";
	        try {
	            reader = new BufferedReader(new FileReader(propertyFilePath));
	            properties = new Properties();
	            try {
	                properties.load(reader);
	                reader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	        }		
	}

    public static APIConfigFileReader getInstance( ) {
    	if(configReader == null) {
    		configReader = new APIConfigFileReader();
    	}
        return configReader;
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("baseUrl");
        if(baseUrl != null) return baseUrl;
        else throw new RuntimeException("base_Url not specified in the Configuration.properties file.");
    }
    
    public String getSchemaPath() {
        String schemaPath = properties.getProperty("schemaPath");
        if(schemaPath != null) return schemaPath;
        else throw new RuntimeException("Schemas  path not specified in the Configuration.properties file.");
    }
    
    
    public String getReportConfigPath(){
    	String reportConfigPath = properties.getProperty("reportConfigPath");
    	if(reportConfigPath!= null) return reportConfigPath;
    	else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
    }


}
