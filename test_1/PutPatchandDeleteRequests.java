package test_1;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchandDeleteRequests {

	@Test
	public void testPut() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Ahmed");
		request.put("job", "SQA Engineer");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api";
		
		given().
		body(request.toJSONString()).
		when().
		put("/users/2").
		then().
		statusCode(200)
		.log().all();
	}
	
	
	@Test
	public void testPatch() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Raza");
		request.put("job", "SQA Engineer");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/";
		
		given().
		body(request.toJSONString()).
		when().
		patch("/api/users/2").
		then().
		statusCode(200)
		.log().all();
	}
	
	
	@Test
	public void testDelete() {
		
		baseURI = "https://reqres.in/";
		
		when().
		delete("/api/users/2").
		then().
		statusCode(204)
		.log().all();
	}
	
	
}
