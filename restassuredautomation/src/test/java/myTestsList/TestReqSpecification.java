package myTestsList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.internal.ResponseSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TestReqSpecification {

	static RequestSpecification getCommSpec() {
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.setBaseUri("https://restful-booker.herokuapp.com");
		reqBuilder.setBasePath("/booking");

		RequestSpecification reqSpec = reqBuilder.build();
		return reqSpec;
	}

	@Test
	public void getData() {
		Response res = RestAssured.given().spec(getCommSpec()).when().get();

		System.out.println(res.asPrettyString());
	}

	static ResponseSpecification responseSpec() {
		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectStatusCode(200);

		ResponseSpecification resSpec = resBuilder.build();
		return resSpec;
	}

	@Test
	public void test_with() {
		String url = "https://reqres.in/api/users?page=2";
		RestAssured
		.given()
		.when()
		.get(url)
		.then()
		.spec(responseSpec());
	}

	@Test
	public void test_without() {
		String url = "https://reqres.in/api/users";
		RestAssured.given().when().get(url).then().spec(responseSpec());
	}

}
