package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestUtil;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public void openBrowser() throws IOException {
		FileInputStream f = new FileInputStream(
				"D:\\Testing_Classes\\Selenium_workspace\\WebdriverTestsJinal\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(f);

		String browser = prop.getProperty("browser");
		System.out.println(browser);

		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Testing_Classes\\Seleniumjars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "D:\\Testing_Classes\\Seleniumjars\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		//PageFactory.initElements(driver, this);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PageLoadTimeOut));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.ImplicitWait));
		driver.get(prop.getProperty("url"));
		}

	public void CloseBrowser() {
		driver.quit();
	}
}
