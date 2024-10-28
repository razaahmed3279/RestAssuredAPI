package test_2;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
//import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;

public class SoapXMLRequest {
	
	@Test
	public void ValidateSoapXML() throws IOException {
		
		// Note for static import of baseURI use:
		// import static io.restassured.RestAssured.baseURI;
		
		File file = new File("./SoapRequest/add.xml");
		
		if(file.exists())
			System.out.println(">> file Exists <<");
		
		FileInputStream fileInputStream	= new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		baseURI = "http://www.dneonline.com/";
		
		given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(requestBody).
		when().
			post("/calculator.asmx").
			then().
			statusCode(200).log().all();
			//statusCode(200).log().all().body("//*:AddResult.text()", equalTo("5"));
		
	}

}


