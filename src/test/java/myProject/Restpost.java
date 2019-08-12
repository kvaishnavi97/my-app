package myProject;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Restpost {
	@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="https://reqres.in/api/users";
		RequestSpecification request = RestAssured.given();

		JSONObject j = new JSONObject();
		j.put("name", "Sayali");
		j.put("job", "TCS");
		j.put("id", "45");
		request.header("Content-Type","application/json");
		request.body(j.toJSONString());
	    Response response=request.request(Method.POST,"/create");
		ResponseBody body=response.getBody();
		String b=body.asString();
		System.out.println("Response body:" +b);

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		ResponseBody r=response.getBody();
		System.out.println("Response body:"+r.asString());
		
	}
	@Test
	public void AuthenticationBasics()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		RequestSpecification request = RestAssured.given();

		Response response = request.get();
		System.out.println("Status code: " + response.getStatusCode());
		System.out.println("Status message " + response.body().asString());
	}

}
