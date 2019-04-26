package com.formation;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Final_8 {

	public static void main(String[] args) throws InterruptedException {
		FillingFormAndSubmitting();
	}

	private static void FillingFormAndSubmitting() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		try {

			Path sampleFile = Paths.get("pages/activity-3.html");
			driver.get(sampleFile.toUri().toString());

			WebElement firstName = driver.findElement(By.id("firstName"));
			firstName.sendKeys("John");
			
			WebElement lastName = driver.findElement(By.id("lastName"));
			lastName.sendKeys("Doe");

			Select dayOfBirth = new Select(driver.findElement(By.id("dayOfBirth")));
			dayOfBirth.selectByVisibleText("20");
			
			Select monthOfBirth = new Select(driver.findElement(By.id("monthOfBirth")));
			monthOfBirth.selectByVisibleText("March");
			
			WebElement yearOfBirth = driver.findElement(By.id("yearOfBirth"));
			yearOfBirth.sendKeys("1990");

			Select hobbies = new Select(driver.findElement(By.id("hobbies")));
			hobbies.selectByVisibleText("Reading");
			hobbies.selectByVisibleText("Sports");

			WebElement masters = driver.findElement(By.cssSelector("input[value='masters']"));
			masters.click();

			WebElement emailUpdates = driver.findElement(By.id("emailUpdates"));
			emailUpdates.click();

			WebElement aboutYourself = driver.findElement(By.id("aboutYourself"));
			aboutYourself.sendKeys("I think Selenium is getting easier and easier!");

			WebElement submit = driver.findElement(By.id("submit"));
			submit.click();
			
			Thread.sleep(4000);

		} finally {
			driver.quit();
		}
	}

}
