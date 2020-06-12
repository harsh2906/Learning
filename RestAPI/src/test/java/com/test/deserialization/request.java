package com.test.deserialization;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class request {

	@Test
	public void requestParam() throws JsonProcessingException
	{
		RestAssured.baseURI="http://216.10.245.166/";
		RequestSpecification rs = RestAssured.given();
		
		//For this Jackson databind maven dependency is required
		ObjectMapper obj = new ObjectMapper();
		
		//Creation of has-map
		HashMap<String,Object> param= new HashMap<String, Object>();
		HashMap<String,Object> param1= new HashMap<String, Object>();
		
		param1.put("lat", -33.8599345);
		param1.put("lng", 151.2090242);


		param.put("location", param1);
		param.put("accuracy", 50);
		param.put("name", "harsh");
		param.put("phone_number", 9909877654D);
		param.put("address", "test house");
		param.put("types", "test house");
		param.put("website", "https//google.com");
		param.put("language", "French-IN");
		
		//Request Body print
		String RequestBody =obj.writerWithDefaultPrettyPrinter().writeValueAsString(param);
		System.out.println("RequestBody-------"+RequestBody);

		Response response = rs.given().queryParam("key", "qaclick123").body(param).post("maps/api/place/add/json");
		System.out.println("Respons Code: "+response.getStatusCode());
		System.out.println("Respons Body: "+response.asString());
		System.out.println("Response Body in JSON--------"+ response.getBody().jsonPath().prettify());
		ResponseBody<?> body = response.getBody();
		
		//Separate class is created to hold the value of successResponse
		SuccessResponse classBody = body.as(SuccessResponse.class);

		//Printing the Place ID created
		System.out.println("Place is created with ID :- "+classBody.place_id);
 
		//If and only if the response is success user can navigate to this loop
		if(response.getStatusCode() == 200)
		{
			Assert.assertEquals(classBody.status, "OK" );
			Assert.assertEquals(classBody.scope, "APP");
		}

		//If the response is fail 
		else
		{
			System.out.println("Request is not valid and status code is " +response.getStatusCode());
			Assert.assertTrue(false);
		}




	}

}
