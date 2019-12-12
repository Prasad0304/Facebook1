package com.facebook.qa.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.util.Testbase;

public class HomePage extends Testbase {

	@FindBy(xpath="//a[@title='Prasad Arewar']")
	WebElement UserNameLable;
	
	@FindBy(xpath="//a[@title='Profile']")
	WebElement Profile;
	
	public HomePage(){
		PageFactory.initElements(driver,this);
	}
	
	
	
	public String verifyHomePageTitle(){
		 return driver.getTitle();
	}
	
	
	public ProfilePage ClickOnProfile(){
		Profile.click();
		
		return new ProfilePage();
	}
}
