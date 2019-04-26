package com.formation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserCheck {

	public static void main(String[] args) throws InterruptedException {
		String chromeDriverPath = "C:\\tools\\selenium\\chromedriver.exe";
		String firefoxDriverPath = "C:\\SeleniumDrivers\\geckodriver.exe";
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		System.setProperty("webdriver.firefox.driver", firefoxDriverPath);
		
		Thread.sleep(2000);
		WebDriver webDriverChrome = new ChromeDriver();
		//WebDriver webDriverFirefox = new FirefoxDriver();
		
		webDriverChrome.close();
		//webDriverFirefox.close();

	}

}
