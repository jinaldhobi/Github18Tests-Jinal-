package com.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class DynamicLoadingTest extends TestBase {
	public DynamicLoadingTest() {
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
	public void dinamicLoading() {

		// Example 1: Element on page that is hidden

		driver.get("http://localhost:7080/dynamic_loading");
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		driver.findElement(By.cssSelector("#start button")).click();
		WebElement message1 = driver.findElement(By.cssSelector("#finish"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(message1));
		Assert.assertEquals(message1.getText(), "Hello World!");

		// Example 2: Element rendered after the fact

		driver.get("http://localhost:7080/dynamic_loading");
		driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
		driver.findElement(By.cssSelector("#start button")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish")));
		WebElement message2 = driver.findElement(By.cssSelector("#finish"));
		Assert.assertEquals(message2.getText(), "Hello World!");

	}
}
