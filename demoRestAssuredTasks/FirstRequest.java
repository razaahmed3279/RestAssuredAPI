package demoRestAssuredTasks;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstRequest {

    @Test
    public void getFirstRequest() {
        
        Response response = 
            given()
                .baseUri("https://reqres.in") 
                .basePath("/api/users/2") 
            .when()
                .get()
            .then()
                .statusCode(200) 
                .body("data.id", equalTo(2)) 
                .body("data.email", equalTo("janet.weaver@reqres.in")) 
                .extract().response(); 
        System.out.println("Response: " + response.asString());
    }
}
