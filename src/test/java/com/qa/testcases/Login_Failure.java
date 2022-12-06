package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;

public class Login_Failure extends TestBase {
	LoginPage Login_Failure;
	
	public Login_Failure() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		openBrowser();
		Login_Failure = new LoginPage();
	}

	@AfterMethod
	public void TearDown() {
		CloseBrowser();
	}

	@Test
	public void Login_Failure_Username() {
		Login_Failure.LoginTest("wrongusername", "SuperSecretPassword!");
	}
	
	@Test
	public void Login_Failure_Password() {
		Login_Failure.LoginTest("tomsmith", "wrongPassword!");
	}
}
