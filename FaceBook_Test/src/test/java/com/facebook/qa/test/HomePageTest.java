package com.facebook.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.util.Testbase;
import com.facebook.qa.homepage.HomePage;
import com.facebook.qa.homepage.LoginPage;

public class HomePageTest extends Testbase{
	
	
	public  LoginPage loginPage ;
	public HomePage homepage;
	public com.facebook.qa.homepage.ProfilePage ProfilePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialisation();
	//	ProfilePage= new ProfilePage();
		 loginPage = new LoginPage();
		homepage = loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void VerifyHomePageTitle(){
	String HomePage = homepage.verifyHomePageTitle();
	System.out.println(HomePage);
	//Assert.assertEquals(HomePage,"(1)Facebook");
	}
	
//	@Test(priority=2)
	//public void verifyUserName(){
//		Boolean user = homepage.verifyUserName();
      //  	Assert.assertTrue(user);
//	}
	
	@Test(priority=3)
	public void VerifyProfileLink(){
		ProfilePage = homepage.ClickOnProfile();
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
