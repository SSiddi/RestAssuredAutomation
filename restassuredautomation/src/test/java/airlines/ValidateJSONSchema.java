package airlines;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import io.restassured.module.jsv.JsonSchemaValidator;

	public class ValidateJSONSchema {

	@Test
	public void GetTest2()
	{
		baseURI  ="https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json")); // place schema file in class path which is in resources folder
		
	}
	
	}
