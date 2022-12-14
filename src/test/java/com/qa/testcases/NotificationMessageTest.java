package com.qa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class NotificationMessageTest extends TestBase {
	public NotificationMessageTest() {
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
	public void notificationMessage() {

		driver.get("http://localhost:7080/notification_message_rendered");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		List<String> compList = Arrays.asList("Action successful", "Action unsuccesful, please try again",
				"Action Unsuccessful");

		for (int i = 0; i < 10; i++) {
			driver.findElement(By.linkText("Click here")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#flash-messages div")));
			WebElement notification = driver.findElement(By.cssSelector("#flash"));
			String msg = notification.getText().replaceAll("×", "").trim();
			Assert.assertTrue(compList.contains(msg));
		}
	}
}
