package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public Properties prop;
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.property");
			prop.load(input);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
