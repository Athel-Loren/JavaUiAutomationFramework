package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();


        //New Window
        driver.switchTo().newWindow(WindowType.TAB);
        //driver.get("http://andreisecuqa.host/");
        //driver.get("https://opencart.antropy.co.uk/");
        driver.get("https://www.andreisecuqa.host/");
        Thread.sleep(1000);

        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccountIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Register']"));
        registerOption.click();
        System.out.println(driver.getCurrentUrl());
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        String firstName = RandomDataManager.generateFirstName();
        firstNameInput.sendKeys(firstName);
        System.out.println(firstName);

        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));
        String lastName = RandomDataManager.generateLastName();
        lastNameInput.sendKeys(lastName);
        System.out.println(lastName);

        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
        String randomEmail = RandomDataManager.generateRandomEmail();
        emailInput.sendKeys(randomEmail);
        System.out.println(randomEmail);

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String password = RandomDataManager.generatePassword();
        passwordInput.sendKeys(password);
        System.out.println(password);

        WebElement registerBtn = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        WebElement termsAndConditionToggleBar = driver.findElement(By.xpath("//input[@name='agree']"));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", termsAndConditionToggleBar);
        Thread.sleep(500);
        termsAndConditionToggleBar.click();

        registerBtn.click();


        Thread.sleep(5000);

        System.out.println(driver.getTitle());
        driver.close();

        //driver.close(); // inchide fereastra
        driver.quit();// inchide driverul
        System.out.println("The Execution is Over");
    }
}