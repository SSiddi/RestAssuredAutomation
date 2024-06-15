package airlines;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

	public static Map<String, Object>  GetAirlinePayload(String id, String name, String country,String logo, String slogan,String head_quaters, String website, String established)
	{
		Map<String, Object> payload = new HashMap<>();
		payload.put("id", id);
		payload.put("name", name);
		payload.put("country", country);
		payload.put("logo", logo);
		payload.put("slogan", slogan);
		payload.put("head_quaters", head_quaters);
		payload.put("website", website);
		payload.put("established", established);
		return payload;		
	}
}
