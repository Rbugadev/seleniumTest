package com.formation;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Overview_1 {

	public static void main(String[] args) throws InterruptedException {
		gettingStaleElementReferenceException();
	}

	private static void gettingStaleElementReferenceException() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		try {
			Path sampleFile = Paths.get("pages/activity-1.html");
			driver.get(sampleFile.toUri().toString());
			
			WebElement spanish = driver.findElement(By.id("spanish"));
			spanish.click();
			
			WebElement email = driver.findElement(By.id("inputEmail"));

			email.sendKeys("email@gmail.com");
			
			Thread.sleep(2000);

			// We use getAttribute("value") because it is an input element, not a text box
			if (email.getAttribute("value").equalsIgnoreCase("email@gmail.com")) {
				System.out.println("Le script a fonctionné 'email@gmail.com' a été tapé.");
			} else {
				System.out.println("Mauvais script.");
			}
		} finally {
			driver.quit();
		}
	}

}