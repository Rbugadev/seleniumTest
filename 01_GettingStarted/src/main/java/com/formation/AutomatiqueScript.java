package com.formation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomatiqueScript {

	public static void main(String[] args) throws InterruptedException {
		String chromeDriverPath = "C:\\tools\\selenium\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		
		if (driver.getTitle().equalsIgnoreCase("Google")) {
			System.out.println("Je suis bien dans Google page");
		}
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.bing.com");
		if (driver.getTitle().equalsIgnoreCase("Bing")) {
			System.out.println("Je suis bien chez Bing");
		}
		Thread.sleep(3000);
		
		driver.navigate().back();
		if (driver.getTitle().equalsIgnoreCase("Google")) {
			System.out.println("De retour chez Google");
		}
		Thread.sleep(5000);
		
		driver.close();
	}

}
