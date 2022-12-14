package com.qa.testcases;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class MouseHoverTest extends TestBase {
	public MouseHoverTest() {
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
	public void mouseHover() {

		List<String> compList = Arrays.asList("name: user1", "name: user2", "name: user3");

		driver.get("http://localhost:7080/hovers");
		List<WebElement> images = driver.findElements(By.cssSelector("#content .figure"));
		Actions action = new Actions(driver);

		List<String> hoverTextList = images.stream().map((e) -> {
			action.moveToElement(e).perform();
			return e.findElement(By.tagName("h5")).getText().trim();
		}).collect(Collectors.toList());

		Assert.assertEquals(compList, hoverTextList);

	}
	
}
