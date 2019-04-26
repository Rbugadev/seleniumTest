package com.formation;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextAreaElement_4 {

  public static void main(String[] args) {
    interactingWithTextAreas();
  }

  private static void interactingWithTextAreas() {

    WebDriver driver = new ChromeDriver();

    try {
			Path sampleFile = Paths.get("pages/activity-2.html");
			driver.get(sampleFile.toUri().toString());

      WebElement textArea = driver.findElement(By.id("aboutYourself"));

      if (textArea.isEnabled() && textArea.isDisplayed()) {
        System.out.println("Visible and Displayed");

        // Checking for an empty text area
        if ("".equals(textArea.getAttribute("value"))) {
          System.out.println("The text area is empty");
        } else {
          System.out.println("The text area NOT empty");
        }

        textArea.sendKeys("This is a sample text.");

        if ("This is a sample text.".equalsIgnoreCase(textArea.getAttribute("value"))) {
          System.out.println("Text was correctly typed into the text area.");
        } else {
          System.out.println("Something went wrong.");
        }

        textArea.clear();
        if ("".equals(textArea.getAttribute("value"))) {
          System.out.println("The text area is empty after cleaning it though a Selenium command");
        } else {
          System.out.println("Something went wrong, the text area was not cleaned");
        }

      } else {
        System.out.println("Something went wrong, the text area is not visible and displayed");
      }

    } finally {
      driver.quit();
    }
  }

}