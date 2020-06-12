package com.test.jsonObject;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PostStudentAPI {

	String baseURL = "http://dummy.restapiexample.com/api/v1/";
	String basePath = "/create";

	@Test(priority =1)
	public void testUsingMap1()
	{
		
	/*	Actual Payload
	 {
			"name": "testName",
			"salary" : "2212",
			"age" : "22"
		} */
		
		JSONObject json = new JSONObject();
		json.put("name", "testName");
		json.put("salary", "12345");
		json.put("age", "22");
		Response response = given().baseUri(baseURL).body(json).when().post(basePath);
		System.out.println("Response 1:  "+response.asString());
	
	}
	
	@Test(priority =2)
	public void testUsingMap()
	{
		
	/*	Actual Payload
	 * {
			"name": "testName",
			"salary" : "2212",
			"age" : {
			"ageX" : "22",
			"ageY" : "23"
			
		} 
		*/
		JSONObject json = new JSONObject();
		JSONObject json2 = new JSONObject();

		json.put("name", "testName");
		json.put("salary", "12345");
		
		json2.put("ageX", "22");
		json2.put("ageY", "23");
		
		json.put("age", json2);
		
		//Response
		Response response = given().baseUri(baseURL).body(json).when().post(basePath);
		System.out.println("Response 2:  "+ response.asString());
		System.out.println("Response IN JSON:  "+response.getBody().jsonPath().prettify());
	}
}
