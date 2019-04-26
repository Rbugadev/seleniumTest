package com.formation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChoixSimpleOuMultipleElement_5 {

  public static void main(String[] args) {
    interactingWithDropDown();
  }

  private static void interactingWithDropDown() {

    WebDriver driver = new ChromeDriver();

    try {
    	Path sampleFile = Paths.get("pages/activity-2.html");
		driver.get(sampleFile.toUri().toString());

      Select singleChoiceList = new Select(driver.findElement(By.id("monthOfBirth")));

      if (!singleChoiceList.isMultiple() && singleChoiceList.getOptions().size() == 13) {
        System.out.println("The list does not accept multiple choices and contains 13 options (including 'Choose...').");
        singleChoiceList.selectByVisibleText("February");
        if (singleChoiceList.getFirstSelectedOption().getText().equalsIgnoreCase("February")) {
          System.out.println("It worked, February was selected as the month.");
        } else {
          System.out.println("Something went wrong, February is not selected.");
        }
      } else {
        System.out.println("Something went wrong 1");
      }

      Select multipleChoiceList = new Select(driver.findElement(By.id("hobbies")));

      if (multipleChoiceList.isMultiple() && multipleChoiceList.getOptions().size() == 4) {
        System.out.println("The list does accept multiple choices and contains 4 options.");
        multipleChoiceList.selectByVisibleText("Reading");
        multipleChoiceList.selectByVisibleText("Sports");
        multipleChoiceList.selectByVisibleText("Traveling");

        multipleChoiceList.deselectByVisibleText("Sports");

        if (multipleChoiceList.getAllSelectedOptions().size() == 2) {
          System.out.println("It worked, 2 options have been chosen");
        } else {
        	System.out.println("Something went wrong 2");
        }

        List<String> expectedSelection = Arrays.asList("Reading", "Traveling");
        List<String> actualSelection = new ArrayList<String>();

        for (WebElement element : multipleChoiceList.getAllSelectedOptions()) {
          actualSelection.add(element.getText());
        }

        if (actualSelection.containsAll(expectedSelection)) {
          System.out.println("It worked, all expected elements were selected.");
        } else {
        	System.out.println("Something went wrong 3");
        }
      } else {
        System.out.println("Something went wrong 4");
      }

    } finally {
      driver.quit();
    }
  }

}