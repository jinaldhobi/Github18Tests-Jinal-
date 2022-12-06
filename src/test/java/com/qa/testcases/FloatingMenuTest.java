package com.qa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class FloatingMenuTest extends TestBase {
	public FloatingMenuTest() {
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
	public void floatingMenu() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("http://localhost:7080/floating_menu");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#page-footer")));

		List<WebElement> menu = new ArrayList<>();
		menu = driver.findElements(By.cssSelector("#menu li")).stream()
				.filter(e -> e.isDisplayed())
				.collect(Collectors.toList());

		Assert.assertEquals(menu.size(), 4);

	}
}
