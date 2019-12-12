package com.facebook.qa.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.util.Testbase;

public class LoginPage extends Testbase {

	
	// Page Factory or Object Repository
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="pass")
	WebElement pass;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[@name='websubmit']")
	WebElement SignUpbtn;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/div/div[1]/h1/a/i")
	WebElement FbLogo;
	
	
	// Initialization Page Objects
	public LoginPage(){
		PageFactory.initElements(driver,this);
	}
	
	//Action
    
	public String ValidateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean ValidateFacebookLogo(){
		return FbLogo.isDisplayed();
		}
	
	public HomePage Login(String ema, String password){
          email.sendKeys(ema);
          pass.sendKeys(password);
          loginBtn.click();
          
          return new HomePage();
          		
	}
}
