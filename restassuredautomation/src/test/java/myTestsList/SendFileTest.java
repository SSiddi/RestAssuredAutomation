package myTestsList;

import static io.restassured.RestAssured.get;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SendFileTest {

	File file = new File("D:\\Shabnam Project\\restassuredautomation\\src\\test\\java\\myTestsList\\Butterfly.png");

	@Test
	public void TestUpload() {
		Response response = RestAssured.given().multiPart("file", file, "multipart/form-data")
				.post("https://the-internet.herokuapp.com/upload").thenReturn();

		System.out.println(response.asPrettyString());
	}

}
