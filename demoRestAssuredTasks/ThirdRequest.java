package demoRestAssuredTasks;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class ThirdRequest {

	@Test
	public void putRequest() {

        String requestBody = "{ \"name\": \"Ahmed\", \"job\": \"QA Lead\" }";

        Response response = 
            given()
                .baseUri("https://reqres.in") 
                .basePath("/api/users/2") 
                .header("Content-Type", "application/json") 
                .body(requestBody) 
            .when()
                .put() // Send PUT request
            .then()
                .statusCode(200) 
                .body("name", equalTo("Ahmed")) 
                .body("job", equalTo("QA Lead")) 
                .extract().response(); 
        
        System.out.println("PUT Response: " + response.asString());
    }
}
