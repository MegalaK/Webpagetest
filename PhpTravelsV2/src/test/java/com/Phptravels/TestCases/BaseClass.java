package com.Phptravels.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Phptravels.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	//public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
    @BeforeClass
    
    public void setup(String br)
    { 	System.out.println("Inside Setup");
		logger = Logger.getLogger("FlightSearch");
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\Log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.out.println("Before opening Firefox" + readconfig.getFirefoxpath());
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver = new InternetExplorerDriver();
		}
		    System.out.println("before get URL" +baseURL);
		    
    }
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts. getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") +"/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screeshot taken");
	}
}
