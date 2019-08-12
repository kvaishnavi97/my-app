package myProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Datadriven {
	@Test(dataProvider="infoP")
	public void getinfo(String ename,String ejob,String eid) {
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification request = RestAssured.given();
		JSONObject j = new JSONObject();
		j.put("name", ename);
		j.put("job", ejob);
		j.put("id", eid);
		request.header("Content-Type","application/json");
		request.body(j.toJSONString());
	    Response response=request.request(Method.POST,"/create");
		ResponseBody body=response.getBody();
		String b=body.asString();
		System.out.println("Response body:" +b);
		Assert.assertEquals(b.contains(ename), true);
		Assert.assertEquals(b.contains(ejob), true);
		//Assert.assertEquals(b.contains(eid), true);
		int stcode=response.getStatusCode();
		Assert.assertEquals(stcode, 201);//verify statuscode

	}		
	     @DataProvider(name="infoP")
         String[][] getinfopost() throws IOException{
	    	 String name="",job="",id="";
	    	 String path="G:\\Interview\\WiproPBL\\myProject\\src\\test\\java\\myProject\\Book1.xlsx";
	    	 String emp[][]=new String[3][3];
	    	 InputStream is=new FileInputStream(path);
	          XSSFWorkbook hssf=new XSSFWorkbook(is); 
	          XSSFSheet hssfSheet=hssf.getSheetAt(0);
	    	 for(int i=0;i<3;i++) {	    		
	    			    name=hssfSheet.getRow(i).getCell(0).getStringCellValue();
	    			    job=hssfSheet.getRow(i).getCell(1).getStringCellValue();
	    			   id=hssfSheet.getRow(i).getCell(2).getStringCellValue();	    			   
	    			
	    		 
	    		 emp[i][0]=name;
	    		 emp[i][1]=job;
	    		 emp[i][2]=id;
	    		 
	    	 }
        	//String emp[][]= {{"Rakshanda","KPIT","32"},{"Shubham","KPIT","28"},{"Omkar","Paramatrix","29"}};
        	return(emp);
        	
         }
	
}
