package com.Phptravels.TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Phptravel.PageObjects.LoginPage;
import com.Phptravels.Utilities.XLUtils;

import junit.framework.Assert;

public class TC_FLLoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException
	{
		driver.get(baseURL);
		Thread.sleep(5000);
		System.out.println("DataDrivenTest Started");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);
		
		System.out.println("Username:" +user);
		lp.setPassword(pwd);
		System.out.println("Password:" +pwd);
		lp.Clickbutton();
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
		 
		}
	
	@DataProvider(name= "LoginData")
	String[][] getDate() throws IOException
	{
		//C:\Selenium_workarea\PhpTravelsV2\src\test\java\com\Phptravels\TestData\TestData.xlsx
		String path=System.getProperty("user.dir")+ "/src/test/java/com/Phptravels/TestData/TestData.xlsx";
		System.out.println(System.getProperty("user.dir")+ "/src/test/java/com/Phptravels/TestData/TestData.xlsx");
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int cocount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String [rownum][cocount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0;j<cocount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				//System.out.println("Value:"+XLUtils.getCellData(path, "Sheet1", i, j));
			}
		}
		
		return logindata;
	}
}
