package myProject;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.junit.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;


public class Logconfig {
	public static StringWriter rw;
	public static PrintStream rc;
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/student";		
	}
	@Before
	public  void beforeEachTest() {
		rw=new StringWriter();
		rc=new PrintStream(new WriterOutputStream(rw),true);
		
	}
	@Test
	public void getStudent() {
		RestAssured.given()
		.when()
		.get("/api/users/2")
		.asString();
		//System.out.println(response);
		
		RestAssured
		.given()
		.filter(new RequestLoggingFilter(rc))
		.when()
		.get("/api/users/2");
		System.err.println(rw.toString());
		
		
	}
	

}
