package demoRestAssuredTasks;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class FourthRequest {

	 @Test
	    public void patchRequest() {

	        String requestBody = "{ \"job\": \"Senior QA Engineer\" }"; 

	        Response response = 
	            given()
	                .baseUri("https://reqres.in") 
	                .basePath("/api/users/2") 
	                .header("Content-Type", "application/json") 
	                .body(requestBody) 
	            .when()
	                .patch() 
	            .then()
	                .statusCode(200) 
	                .body("job", equalTo("Senior QA Engineer")) 
	                .extract().response(); 
	        
	        System.out.println("PATCH Response: " + response.asString());
    }
}
