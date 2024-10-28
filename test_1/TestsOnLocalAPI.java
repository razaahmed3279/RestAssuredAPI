package test_1;


import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class TestsOnLocalAPI {

	//@Test
	public void posts() {
		
		baseURI = "http://localhost:3000";
		
		given().
			get("/posts").
		then().
			statusCode(200).
			log().all();
	}
	
	
	@Test
	public void comments() {
		
		baseURI = "http://localhost:3000";
		
		given().
			get("/comments").
		then().
			statusCode(200).
			log().all();
	}
		
}
