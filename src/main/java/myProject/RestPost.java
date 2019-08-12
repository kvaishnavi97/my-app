package myProject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RestPost {
	@Test
	public void getdata() {
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		JSONObject j = new JSONObject();
		j.put("FirstName", "dnyan"); 
		j.put("LastName", "kale");		 
		j.put("UserName", "kvaishnavi155");
		j.put("Password", "pass");
		j.put("Email",  "vai428@gmail.com");
		request.body(j.toJSONString());
		Response response=request.post("/register");
		ResponseBody body=response.getBody();
		System.out.println("Response Body:"  +body.asString());
		int statuscode=response.getStatusCode();
		String successcode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successcode, "OPERATION_SUCCESS");
	}

}
