package com.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class ContextMenuTest extends TestBase {
	public ContextMenuTest() {
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
	public void contextMenu() {

		driver.get("http://localhost:7080/context_menu");

		WebElement hotspot = driver.findElement(By.id("hot-spot"));
		Actions actions = new Actions(driver);
		actions.contextClick(hotspot).perform();
		String alertmsg = driver.switchTo().alert().getText();

		Assert.assertEquals(alertmsg, "You selected a context menu");

	}
}
