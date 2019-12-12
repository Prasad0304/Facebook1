package com.facebook.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.util.Testbase;
import com.facebook.qa.homepage.HomePage;
import com.facebook.qa.homepage.LoginPage;

public class LoginPageTest extends Testbase {
	
	public  LoginPage loginPage ;
	public HomePage homepage;
	public LoginPageTest(){
		super();   //To initialise Super class Constructor i.e. testbase constructor in testbase class 
		             //     to initialise Properties
	}
	
	 @BeforeMethod
	  public void setUp(){
		
		 initialisation();
		 loginPage = new LoginPage();
		}
	 
	 @Test(priority=1)
	  
	 public void loginPageTitleTest(){
		String title = loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(title,"Facebook – log in or sign up");
	 }
	 
	 @Test(priority=2)
	 
	 public void facebookImageTest(){
		boolean  flag =  loginPage.ValidateFacebookLogo();
		Assert.assertTrue(flag);
	 }
	 
	 @Test(priority=3)
	 
	 public void loginTest(){
		 homepage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		 
	 }
	 
	 @AfterMethod
	 public void tearDown(){
		 driver.quit();
	 }

}
