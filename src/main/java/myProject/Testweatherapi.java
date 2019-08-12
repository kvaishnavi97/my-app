package myProject;

import org.json.simple.JSONObject;
import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Testweatherapi {
	@Test(priority=0)
	public void getWeatherdata() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";		 
		 RequestSpecification httpRequest = RestAssured.given();	 
		 Response response = httpRequest.request(Method.GET, "/Hyderabad");
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
		
		 JSONObject r=new JSONObject();
		 r.put("FirstName", "Virender"); 
		 r.put("LastName", "Singh");		  
		 r.put("UserName", "simpleuser001");
		 r.put("Password", "password1");
		 r.put("Email",  "someuser@gmail.com");
		 httpRequest.body(r.toJSONString());
		 Response response1 = httpRequest.post("/register");
		 System.out.println(response.asString());
		 int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, "201");
			String successCode = response.jsonPath().get("SuccessCode");
			Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
		}

		 
		
	}


