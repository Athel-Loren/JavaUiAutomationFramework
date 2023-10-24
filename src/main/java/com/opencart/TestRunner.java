package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();

        //New Window
        driver.switchTo().newWindow(WindowType.TAB);
        //driver.get("http://andreisecuqa.host/");
        driver.get("https://opencart.antropy.co.uk/");
        //driver.get("https://www.andreisecuqa.host/");
        Thread.sleep(1000);
        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        myAccountIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']"));
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

        WebElement phoneInput = driver.findElement(By.cssSelector("#input-telephone"));
        phoneInput.sendKeys("0765574643");



        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String password = RandomDataManager.generatePassword();
        passwordInput.sendKeys(password);

        WebElement confirmPasswordInput = driver.findElement(By.cssSelector("#input-confirm"));
        confirmPasswordInput.sendKeys(password);
        System.out.println(password);

        WebElement termsAndConditionCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));
        termsAndConditionCheckbox.click();

        WebElement registerBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
        registerBtn.click();


        Thread.sleep(5000);

        System.out.println(driver.getTitle());
        driver.close();

        //driver.close(); // inchide fereastra
        driver.quit();// inchide driverul
        System.out.println("The Execution is Over");
    }
}