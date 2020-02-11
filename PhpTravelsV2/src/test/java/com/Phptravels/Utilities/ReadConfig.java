
package com.Phptravels.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {

	 Properties pro;
	 
	 public ReadConfig()
	 {
		 File src = new File (System.getProperty("user.dir")+ "\\Configurations\\config.properties");
		 try {
			 FileInputStream fis = new FileInputStream(src);
			 pro = new Properties();
			 pro.load(fis);
		 }catch (Exception e) {
			 System.out.println("Exception is" + e.getMessage());
		 }
	 }
	 
	 public String getApplicationURL()
	 {
		 return pro.getProperty("baseURL");
		 
	 }
	 public String getUsername()
	 {
		 String url=pro.getProperty("username");
	     return url;
		 
	 }
	 public String getPassword()
	 {
		 return pro.getProperty("password");
		 
	 }
	 public String getChromepath()
	 {
		return pro.getProperty("chromepath");
		 	 
	 }
	 public String getIEpath()
	 {
		 return pro.getProperty("iepath");
		 	 
	 }
	 public String getFirefoxpath()
	 {
		 return pro.getProperty("firefoxpath");
		 		 
	 }
}
