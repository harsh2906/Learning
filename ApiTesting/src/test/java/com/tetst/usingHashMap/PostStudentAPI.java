package com.tetst.usingHashMap;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
		
		Map<String,Object> map = new HashMap();
		map.put("name", "testName");
		map.put("salary", "12345");
		map.put("age", "22");
		Response response = given().baseUri(baseURL).body(map).when().post(basePath);
		System.out.println("Response 1:  "+response.asString());
	
	}
	
	@SuppressWarnings("deprecation")
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
		Map<String,Object> map = new HashMap();
		Map<String,Object> map2 = new HashMap();

		map.put("name", "testName");
		map.put("salary", "12345");
		
		map2.put("ageX", "22");
		map2.put("ageY", "23");
		
		map.put("age", map2);
		
		//Response
		Response response = given().baseUri(baseURL).body(map).when().post(basePath);
		System.out.println("Response 2:  "+ response.asString());
	}
}
