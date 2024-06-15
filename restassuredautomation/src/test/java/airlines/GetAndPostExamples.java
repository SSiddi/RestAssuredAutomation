package airlines;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetAndPostExamples {

	@Test
	public void GeTest1()
	{
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getTime());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getBody().asString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
				
	}
	
	@Test
	public void GeTest2()
	{
		baseURI  ="https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[0].id",equalTo(7)).
			log().all();
	}
	
	@Test
	public void testPost()
	{
		baseURI  ="https://reqres.in/api";
		JSONObject reqBody = new JSONObject();
		reqBody.put("name", "morpheus");
		reqBody.put("job", "leader");
		
		System.out.println( " reqBody.toJSONString() is : " + reqBody.toJSONString()); //{"name":"morpheus","job":"leader"}

		given().
			header("Content-Type","application/json").
			
			body(reqBody.toJSONString()).	
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		}
	}

