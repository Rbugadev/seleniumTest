package com.formation;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Overview_2 {

	public static void main(String[] args) throws InterruptedException {
    avoidingStaleElementReferenceException();
  }

  private static void avoidingStaleElementReferenceException() throws InterruptedException {

    WebDriver driver = new ChromeDriver();

    try {
		Path sampleFile = Paths.get("pages/activity-1.html");
		driver.get(sampleFile.toUri().toString());

      WebElement email = driver.findElement(By.id("inputEmail"));
      WebElement spanish = driver.findElement(By.id("spanish"));
      spanish.click();

      int tries = 0;
      while (tries < 2) {
        try {
          email.sendKeys("email@gmail.com");

			Thread.sleep(2000);

			// We use getAttribute("value") because it is an input element, not a text box
			if (email.getAttribute("value").equalsIgnoreCase("email@gmail.com")) {
				System.out.println("Script worked, 'email@gmail.com' was typed.");
			} else {
				System.out.println("Wrong script.");
			}
			
          break;
        } catch (StaleElementReferenceException e) {
          email = driver.findElement(By.id("inputEmail"));
        }
        tries++;
      }

    } finally {
      driver.quit();
    }
  }

}