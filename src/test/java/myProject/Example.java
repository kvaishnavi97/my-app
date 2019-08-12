package myProject;

import org.json.simple.JSONObject;
//import org.junit.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import static org.junit.Assert.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example extends testBase {
	@Test(dataProvider="infop1")
	public void postaddinfo(String ename,String ejob,String eid) {
		RestAssured.baseURI="https://reqres.in/api/users";
		 httpRequest=RestAssured.given();
		JSONObject j=new JSONObject();
		j.put("name", ename);
		j.put("job", ejob);
		j.put("id", eid);
		httpRequest.header("content-Type","application/json");
		httpRequest.body(j.toJSONString());
		//Post request
	  Response response	=httpRequest.request(Method.POST,"/create1");
		//capture response body
	    String b =response.getBody().asString();
	    System.out.println("Responsebody:"  +b);
	    Assert.assertEquals(b.contains(ename), true);
	    Assert.assertEquals(b.contains(ejob), true);
	    Assert.assertEquals(b.contains(eid), true);

	    //verify status code and all contents
	}
	@DataProvider(name="infop1")
	String[][] getinfo(){
		String data[][]= { {"rakshanda1","KPIT","32"},{"Shubham1","KPIT","28"},
				{"omkar1","paramatrix","29"}};
		  return(data); 

}
}
