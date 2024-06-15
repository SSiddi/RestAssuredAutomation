

package airlines;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class PutPatchDelete {

	// put is used to update a resource, it will update the complete resource
	@Test
	public void testPut() {
		baseURI = "https://reqres.in/api";
		
		JSONObject reqBody = new JSONObject();
		reqBody.put("name", "morpheus");
		reqBody.put("job", "leader");

		System.out.println(" reqBody.toJSONString() is : " + reqBody.toJSONString()); // {"name":"morpheus","job":"leader"}

		given().
			header("Content-Type", "application/json").
			body(reqBody.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).log().all();
	}

	// patch is used to update certain key of a resource and not the complete resource
	@Test
	public void testPatch() {
		baseURI = "https://reqres.in/api";
		JSONObject reqBody = new JSONObject();
		reqBody.put("name", "Mohan");
		reqBody.put("job", "Tester");

		System.out.println(" reqBody.toJSONString() is : " + reqBody.toJSONString());

		given().
			header("Content-Type", "application/json").
			body(reqBody.toJSONString()).
		when().
			patch("/users/2").
		then().
			statusCode(200).log().all();
	}

	
	@Test
	public void testDelete() {
		baseURI = "https://reqres.in/api";
		JSONObject reqBody = new JSONObject();
		reqBody.put("name", "Mohan");
		reqBody.put("job", "Tester");

		System.out.println(" reqBody.toJSONString() is : " + reqBody.toJSONString());

		when().
			delete("/users/2").
		then().
			statusCode(204).log().all();
	}
}
