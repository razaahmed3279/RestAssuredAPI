package demoRestAssuredTasks;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SecondRequest {

    @Test
    public void postSecondRequest() {
        
        Response response = 
            given()
                .baseUri("https://reqres.in") // Set the base URI
                .basePath("/api/users") // Set the endpoint path for POST
                .header("Content-Type", "application/json") // Set header for JSON
                .body("{ \"name\": \"Ahmed\", \"job\": \"SQA Engineer\" }") // Add JSON body
            .when()
                .post() // Send POST request
            .then()
                .statusCode(201) // Validate response status code for POST (usually 201)
                .body("name", equalTo("Ahmed")) // Validate response body
                .body("job", equalTo("Software Engineer")) // Validate job in the response
                .extract().response(); // Extract response
        
        // Optionally, you can print the response if needed
        System.out.println("Response: " + response.asString());
    }
}
