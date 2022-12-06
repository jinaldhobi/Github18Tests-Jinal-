package com.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class CheckBoxesTest extends TestBase {
	public CheckBoxesTest() {
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
	public void checkBoxes() {

		driver.get("http://localhost:7080/checkboxes");
		WebElement checkBox1 = driver.findElement(By.cssSelector("form input:nth-of-type(1)"));
		WebElement checkBox2 = driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
		checkBox1.click();
		Assert.assertTrue(checkBox1.isSelected());
		checkBox2.click();
		Assert.assertTrue(!checkBox2.isSelected());
	}

}
