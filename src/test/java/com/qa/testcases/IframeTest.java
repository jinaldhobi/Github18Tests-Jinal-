package com.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class IframeTest extends TestBase {
	public IframeTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		openBrowser();
	}

	@AfterMethod
	public void TearDown() {
		CloseBrowser();
	}
	
	@Test
	public void iframe() {

		driver.get("http://localhost:7080/iframe");
		WebElement frame = driver.findElement(By.id("mce_0_ifr"));
		driver.switchTo().frame(frame);
		WebElement body = driver.findElement(By.id("tinymce"));
		body.clear();
		body.sendKeys("Hello World!");
		
		Assert.assertTrue(body.getText().contains("Hello World!"));
	}
}
