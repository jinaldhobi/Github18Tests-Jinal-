package com.qa.testcases;

import java.io.IOException;
import java.time.Duration;
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

public class DynamicControlsTest extends TestBase {
	public DynamicControlsTest() {
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
	public void dinamicControls() {

		driver.get("http://localhost:7080/dynamic_controls");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// checkbox
		WebElement remove_add = driver.findElement(By.cssSelector("#checkbox-example button"));
		remove_add.click();
		wait.until(ExpectedConditions.textToBePresentInElement(remove_add, "Add"));

		List<WebElement> checkboxList = driver.findElements(By.cssSelector("#checkbox [type=checkbox]"));
		Assert.assertTrue(checkboxList.size() == 0, "the checkbox is still visible");

		remove_add.click();
		wait.until(ExpectedConditions.textToBePresentInElement(remove_add, "Remove"));

		WebElement checkbox = driver.findElement(By.cssSelector("#checkbox-example [type=checkbox]"));
		Assert.assertTrue(checkbox.isDisplayed());

		// textbox
		WebElement enable_disable = driver.findElement(By.cssSelector("#input-example button"));
		enable_disable.click();
		wait.until(ExpectedConditions.textToBePresentInElement(enable_disable, "Disable"));

		WebElement input = driver.findElement(By.cssSelector("#input-example input"));
		Assert.assertTrue(input.isEnabled());

		enable_disable.click();
		wait.until(ExpectedConditions.textToBePresentInElement(enable_disable, "Enable"));

		Assert.assertFalse(input.isEnabled());

	}
}
