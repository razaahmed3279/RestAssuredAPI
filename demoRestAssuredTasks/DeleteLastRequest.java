package demoRestAssuredTasks;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DeleteLastRequest {

	@Test
	public void deleteRequest() {
		Response response = 
				given()
				.baseUri("https://reqres.in") 
				.basePath("/api/users/2") 
				.when()
				.delete() 
				.then()
				.statusCode(204) 
				.extract().response(); 

		System.out.println("DELETE Response: " + response.asString());

	}
}
