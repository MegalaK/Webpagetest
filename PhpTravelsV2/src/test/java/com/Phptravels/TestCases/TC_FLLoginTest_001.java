package com.Phptravels.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Phptravel.PageObjects.LoginPage;

import junit.framework.Assert;

public class TC_FLLoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		driver.get(baseURL);
		System.out.println("Started LoginTest");
		LoginPage lp = new LoginPage(driver);
		System.out.println("Before Username");
		logger.info("starting test");
		Thread.sleep(5000);
		
		//lp.setUsername(readconfig.getUsername());
		lp.setUsername(readconfig.getUsername());
		logger.info("Entered Username");
		
		lp.setPassword(readconfig.getPassword());
		logger.info("Entered Password");
		
		lp.Clickbutton();
		logger.info("Clicked Login");
		Thread.sleep(5000);
	
		
		String actualTitle = driver.getTitle();
		System.out.println("Actual Title:" +actualTitle);
		String expectedTitle = "My Account";
		Assert.assertEquals(expectedTitle,actualTitle);
		
		
		if(driver.getTitle().equals(expectedTitle))

		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
			
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Login test failed");
			captureScreen(driver, "loginTest_"+readconfig.getUsername());
			
		}
		//lp.Logoutbutton();
	}
	
}
