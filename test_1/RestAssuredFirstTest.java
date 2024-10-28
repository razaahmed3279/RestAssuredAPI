package test_1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredFirstTest {

	@Test
	public void testOne() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response time: " + response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		//Assert.assertEquals(statusCode, 400);
		Assert.assertEquals(statusCode, 200);
	}
	
}
