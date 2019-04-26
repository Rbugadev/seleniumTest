package com.formation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ImplicitWait {
	public static void main(String[] args) {
		implicitWaitExample();
	}

	private static void implicitWaitExample() {
		WebDriver driver = new ChromeDriver();
		Path sampleFile = Paths.get("pages/activity_5_A-1.html");
		driver.get(sampleFile.toUri().toString());

		// Set an implicit wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		try {
			/* Search for a button named runTestButton and click on it to start the test */
			driver.findElement(By.id("runTestButton")).click();

			// Verify expected changes to an element affected by the test run
			WebElement info = driver.findElement(By.id("lesson"));
			if (info.getText().contains("run")) {
				System.out.println("ImplicitWait worked, the element contains 'run'");
			} else {
				System.out.println("Something went wrong with ImplicitWait, 'run' was not found");
			}
		} finally {
			driver.quit();
		}
	}
}
