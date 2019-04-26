package com.formation;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxElement_7 {

	public static void main(String[] args) {
		interactingWithCheckBox();
	}

	private static void interactingWithCheckBox() {

		WebDriver driver = new ChromeDriver();

		try {
			Path sampleFile = Paths.get("pages/activity-2.html");
			driver.get(sampleFile.toUri().toString());

			WebElement emailUpdates = driver.findElement(By.id("emailUpdates"));
			if (emailUpdates.isEnabled() && emailUpdates.isDisplayed()) {
				System.out.println("The email updates checkbox is enabled and visible.");
				if (!emailUpdates.isSelected()) {
					emailUpdates.click();
					if (emailUpdates.isSelected()) {
						System.out.println("It worked, the checkbox to get email updates was selected");
					} else {
						System.out.println("Something went wrong, the email updates checkbox was not selected.");
					}
				}

			} else {
				System.out.println("Something went wrong, checkbox was not enabled and visible.");
			}
		} finally {
			driver.quit();
		}
	}

}
