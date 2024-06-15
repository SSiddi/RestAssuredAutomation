package airlines;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AirlineTests {


	@Test
	public void createAirline()
	{
		String endpoint = "https://api.instantwebtools.net/v1/airlines";	
		Map<String, Object> payload = Payloads.GetAirlinePayload("12", "Sri Lankan Airways", "Sri Lanka", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png", "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1990");
		Response response = RestUtils.performPost(endpoint, payload, new HashMap<>());
		Assert.assertEquals(response.statusCode(), 200);
	}
}
