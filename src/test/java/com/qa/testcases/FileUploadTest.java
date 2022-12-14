package com.qa.testcases;

import java.io.File;
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

public class FileUploadTest extends TestBase {
	public FileUploadTest() {
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
	public void uploadFile() {

		String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "uploadFiles" + File.separator + "some-file.xlsx";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("http://localhost:7080/upload");
		
		WebElement inputFile = driver.findElement(By.cssSelector("#file-upload"));
		WebElement filesubmit = driver.findElement(By.cssSelector("#file-submit"));
		inputFile.sendKeys(filePath);
		filesubmit.click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#content h3")));
		String msg = driver.findElement(By.cssSelector("#content h3")).getText();
		
		Assert.assertEquals(msg, "File Uploaded!");
	}
}
