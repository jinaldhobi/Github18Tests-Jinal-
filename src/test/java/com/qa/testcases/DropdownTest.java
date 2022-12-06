package com.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class DropdownTest extends TestBase {

	public DropdownTest() {
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
	public void dropDown() {

		driver.get("http://localhost:7080/dropdown");

		driver.findElement(By.id("dropdown")).click();
		WebElement options = driver.findElement(By.cssSelector("option[value='1']"));
		options.click();
		Assert.assertTrue(options.isSelected());

		driver.findElement(By.id("dropdown")).click();
		options = driver.findElement(By.cssSelector("option[value='2']"));
		options.click();
		Assert.assertTrue(options.isSelected());

	}

}
