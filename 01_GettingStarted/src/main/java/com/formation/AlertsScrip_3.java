package com.formation;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsScrip_3 {

    public static void main(String[] args) throws InterruptedException {
        alertsChecks();
    }

    private static void alertsChecks() throws InterruptedException{

        WebDriver driver = new ChromeDriver();

        try {
        	
        	Path sampleFile = Paths.get("pages/alert.html");
            driver.get(sampleFile.toUri().toString());

            // Accepting the first alert
            Alert simpleAlert = driver.switchTo().alert();
            System.out.println("Alert text contents: " + simpleAlert.getText());
            Thread.sleep(1000);
            if (simpleAlert.getText().equalsIgnoreCase("Simple alert. Press 'Accept' to continue")) {
                System.out.println("Simple alert was shown");
            }
            else {
                System.out.println("Simple alert was NOT shown");
            }
            
            //click sur le bouton OK
            simpleAlert.accept();

            // Accepting the confirmation or cancellation alert
            Alert confirmAlert = driver.switchTo().alert();
            if (confirmAlert.getText().equalsIgnoreCase("Confirm alert. Accept or Cancel?")) {
                System.out.println("Confirmation alert was shown");
            }
            else {
                System.out.println("Confirmation alert was NOT shown");
            }
            
            Thread.sleep(1000);
            
          //click sur le bouton Accept
            confirmAlert.accept();

            // Handling the alert with input
            Alert promptAlert = driver.switchTo().alert();
            Thread.sleep(1000);
            
			// Envoie de valeur
            promptAlert.sendKeys("Java");
            Thread.sleep(1000);
            
            promptAlert.accept();
            Thread.sleep(1000);
            if (driver.getTitle().contains("Java")) {
                System.out.println("Text was included in the title.");
            } else {
                System.out.println("Prompt alert did not work");
            }
            
            Thread.sleep(1000);
        } finally {
            driver.quit();
        }
    }

}