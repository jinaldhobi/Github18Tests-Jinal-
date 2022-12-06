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

public class DragandDropTest extends TestBase {

	public DragandDropTest() {
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
	public void DragAndDrop() {

		driver.get("http://localhost:7080/drag_and_drop");

		WebElement A = driver.findElement(By.id("column-a"));
		WebElement B = driver.findElement(By.id("column-b"));
		System.out.println(A.getText());
		Actions builder = new Actions(driver);
		builder.dragAndDrop(A, B).build().perform();
		System.out.println(B.getText());

		WebElement textonA = driver.findElement(By.cssSelector("#column-a header"));
		WebElement textonB = driver.findElement(By.cssSelector("#column-b header"));

		Assert.assertEquals(textonA.getText().trim(), "A");
		Assert.assertEquals(textonB.getText().trim(), "B");
	}
}
