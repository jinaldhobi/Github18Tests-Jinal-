package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;

public class LoginSuccess extends TestBase {
	LoginPage LoginSuccess;

	public LoginSuccess() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		openBrowser();
		LoginSuccess = new LoginPage();
	}

	@AfterMethod
	public void TearDown() {
		CloseBrowser();
	}

	@Test
	public void Login() {
		LoginSuccess.LoginTest(prop.getProperty("username"), prop.getProperty("password"));
	}
}
