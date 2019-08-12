package myProject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Restassured {
	@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="https://reqres.in/api/users/2";
		RequestSpecification request = RestAssured.given();
			JSONObject j = new JSONObject();
		j.put("name", "vaishnavi");
		j.put("job", "Adrosonic");
		request.header("Content-Type","application/json");
		request.body(j.toJSONString());
		Response response = request.request(Method.PUT,"/update");
		 

		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.body().asString());
	}

}
