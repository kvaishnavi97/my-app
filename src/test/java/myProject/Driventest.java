package myProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class Driventest  {
	@Test
	public void createdata() throws IOException{
		File src=new File("D:\\Vaishnavi\\test\\src\\test\\java\\test\\Config1.Properties");
		FileInputStream fis=new FileInputStream(src);
		Properties pro=new Properties();
		pro.load(fis);
		
	}

}
