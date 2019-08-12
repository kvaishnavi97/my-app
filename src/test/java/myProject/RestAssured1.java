package myProject;

import org.junit.Assert;
//import org.junit.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured1  {
	@Test
	public void GetWeatherDetails() {
		 RestAssured.baseURI = "https://reqres.in/api";
		  RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.request(Method.GET, "/users?page=2");
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is:\n " + responseBody);
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode , 200);
		 String statusLine = response.getStatusLine();
		 System.out.println("Status Line:"+statusLine);
		 Assert.assertEquals(statusLine , "HTTP/1.1 200 OK");
		 String contentType = response.header("Content-Type");
		 System.out.println("Content-Type value: " + contentType);
		 String serverType =  response.header("Server");
		 System.out.println("Server value: " + serverType);
		 String acceptLanguage = response.header("Content-Encoding");
		 System.out.println("Content-Encoding: " + acceptLanguage);
		 Headers allHeaders = response.headers();
		 for(Header header : allHeaders)
		 {
		 System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		 }
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		Assert.assertEquals(serverType, "cloudflare");
	    Assert.assertEquals(acceptLanguage, "gzip");
	    String clength=response.header("Content-Length");
	 
		
	}

}
