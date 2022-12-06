package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="username")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;

	@FindBy(css = "[type=submit]")
	WebElement  Login;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void LoginTest(String username,String password){
		Username.sendKeys(username);
		Password.sendKeys(password);
		Login.click();
			}
	

}
