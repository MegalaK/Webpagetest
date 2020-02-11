
package com.Phptravel.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	/*public void LoginLink()
	{
		WebElement lkLogin = ldriver.findElement(By.id("dropdownCurrency"));
		lkLogin.click();
	}
	*/
	public void setUsername(String name)
	{
		WebElement txtUsername = ldriver.findElement(By.name("uid"));
		txtUsername.sendKeys(name);
	}
	
	/*public void SetUsername() throws InterruptedException
	{
		WebElement txtUsername = ldriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div/div/ul/li[1]/div/div[1]/div/div[2]"));
		txtUsername.click();
		Thread.sleep(5000);
	}*/
	
	
	
	public void setPassword(String pwd)
	{
		WebElement txtPassword = ldriver.findElement(By.name("password"));
		txtPassword.sendKeys(pwd);
	}
	
	public void Clickbutton()
	{
		WebElement loginbtn = ldriver.findElement(By.name("btnLogin"));
		loginbtn.click();
	}
	
	/*public void Logoutbutton()
	{
		System.out.println("Logoutmethod is running");
		Select logoutbtn = new Select(ldriver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a/span")));
		logoutbtn.selectByVisibleText("Sign out");
		
	}*/
	
	
}
