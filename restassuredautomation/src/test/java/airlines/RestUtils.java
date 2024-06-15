package airlines;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.response.Response;

public class RestUtils {

	

	public static Response performPost(String endPoint, Map<String, Object> requesPayload, Map <String,String> headers)
	{
		return   given().log().all()
				.baseUri(endPoint)
				.headers(headers)
				.body(requesPayload)
				.post()
				.then().log().all().extract().response();
	}
	
	
}
