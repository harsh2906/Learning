package com.test.pojo;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Request {
	
	Age age = new Age("23","24");
	Payload payload = new Payload("TestName", "1234", age);
	
	@Test
	public void postCall()
	{
		Response res = RestAssured.given().baseUri("http://dummy.restapiexample.com/api/v1").body(payload).when().post("/create");
		System.out.println(res.asString());
		Assert.assertEquals(res.getStatusCode(), 200, "Status"
				+ " code doces not match");
	}

}
