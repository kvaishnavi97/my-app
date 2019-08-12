package myProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Restsingleget extends testBase{
    @Test

	public void getsingle() {
	 RestAssured.baseURI = "https://reqres.in/";
	  httpRequest = RestAssured.given();
	  response = httpRequest.request(Method.GET, "/api/users/2");
	 String responseBody = response.getBody().asString();
	 System.out.println("Response Body is:\n " + responseBody);
	 long rtime=response.getTime();
	 System.out.println("Response time: "+rtime);
	 Assert.assertTrue(rtime<2000);
	 Assert.assertEquals(responseBody.contains("Janet"), true);

}
    @Test
    public void getsingle1() {
   	 RestAssured.baseURI = "https://reqres.in/";
   	 RequestSpecification httpRequest = RestAssured.given();
   	 Response response = httpRequest.request(Method.GET, "/api/unknown/2");
   	 String responseBody = response.getBody().asString();
   	 System.out.println("Response Body is =>  " + responseBody);
   	 long rtime=response.getTime();
   	 System.out.println("Response time: "+rtime);
   	 Assert.assertTrue(rtime<2000);
   	 Assert.assertEquals(responseBody.contains("fuchsia rose"), true);

   }
}
