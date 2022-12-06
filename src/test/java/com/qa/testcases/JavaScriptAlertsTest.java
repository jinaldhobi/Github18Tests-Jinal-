package com.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class JavaScriptAlertsTest extends TestBase {
	public JavaScriptAlertsTest() {
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
	public void jsAlert() {

		driver.get("http://localhost:7080/javascript_alerts");
		WebElement alertButton = driver.findElement(By.cssSelector("[onclick='jsAlert()']"));

		alertButton.click();
		String msg = driver.switchTo().alert().getText();
		Assert.assertEquals(msg, "I am a JS Alert");
	}

	@Test
	public void jsConfirmAlert() {

		driver.get("http://localhost:7080/javascript_alerts");
		WebElement confirmButton = driver.findElement(By.cssSelector("[onclick='jsConfirm()']"));
		confirmButton.click();
		String msg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(msg, "I am a JS Confirm");
	}

	@Test
	public void jsPromptAlert() {

		driver.get("http://localhost:7080/javascript_alerts");

		WebElement promptButton = driver.findElement(By.cssSelector("[onclick='jsPrompt()']"));
		promptButton.click();
		driver.switchTo().alert().sendKeys("Hello World!");
		driver.switchTo().alert().accept();
		WebElement result = driver.findElement(By.cssSelector("#result"));
		Assert.assertTrue(result.getText().contains("Hello World!") );
	}
}