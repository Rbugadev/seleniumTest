package com.formation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FindElement_3 {

  public static void main(String[] args) {
    locatingElements();
  }

  private static void locatingElements() {

    WebDriver driver = new ChromeDriver();

    try {
    	Path sampleFile = Paths.get("pages/activity-2.html");
		driver.get(sampleFile.toUri().toString());

      // Using id
      WebElement lastName = driver.findElement(By.id("lastName"));
      if (lastName.isDisplayed()) {
        System.out.println("lastName element is visible");
      } else {
        System.out.println("Wrong script 1");
      }

      // Using name
      WebElement hobbies = driver.findElement(By.name("hobbies"));
      if (hobbies.isDisplayed()) {
        System.out.println("hobbies element is visible");
      } else {
    	  System.out.println("Wrong script 2");
      }

      // Using class name (in this case, coincidentally the first name is the first element of this kind
      WebElement firstName = driver.findElement(By.className("form-control"));
      if (firstName.isDisplayed()) {
        System.out.println("hobbies element is visible");
      } else {
    	  System.out.println("Wrong script 3");
      }

      // Using HTML tag
      List<WebElement> div = driver.findElements(By.tagName("div"));
      if (div.size() > 0) {
        System.out.println("there are more than zero divs on the page");
      } else {
    	  System.out.println("Wrong script 4");
      }

      // Using link
      WebElement spanishLink = driver.findElement(By.linkText("Spanish"));
      String link = spanishLink.getAttribute("href");
      if (!"".equals(link)) {
        System.out.println("the link was found");
      } else {
    	  System.out.println("Wrong script 5");
      }

      // Using xpath (try to avoid it as much as possible, CSS is a better option)
      Select dayOfBirth = new Select(driver.findElement(By.xpath("//select")));
      if (dayOfBirth.getOptions().size() > 0) {
        System.out.println("the element was found");
      } else {
    	  System.out.println("Wrong script 6");
      }

      // Using CSS
      WebElement firstNameWithCss = driver.findElement(By.cssSelector("#firstName"));
      if (firstNameWithCss.isDisplayed()) {
        System.out.println("firstName with CSS element is visible");
      } else {
    	  System.out.println("Wrong script 7");
      }

    } finally {
      driver.quit();
    }
  }

}

