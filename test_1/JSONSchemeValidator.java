package test_1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemeValidator {

	@Test
	public void testGet() {

		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
				.statusCode(200);
	}

}
