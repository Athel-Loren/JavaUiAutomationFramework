package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    @Then("the current Url contains {string} keyword")
    public void theCurrentUrlContainsKeyword(String keyWordFromTheUrl) throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();
        boolean currentUrlContainsKeyword = currentUrl.contains(keyWordFromTheUrl);
        System.out.println("######## " +currentUrl);
        System.out.println("******** " +keyWordFromTheUrl);
        Thread.sleep(500);

        Assertions.assertTrue(currentUrlContainsKeyword,"The KeyWord: " + keyWordFromTheUrl+ " is present in " + currentUrl);
    }

    @Given("{string} endpoint is accessed")
    public void endpointIsAccessed(String endpointValue){
        driver.get("https://andreisecuqa.host"+endpointValue);
    }

    @Then("the following list of error messages is displayed:")
    public void  theFollowingListOfErrorMessagesIsDisplayed(List<String> errorMessagesList) throws InterruptedException {
        Thread.sleep(1000);
        errorMessagesList.forEach(errorMessages -> {
            boolean errorMessageIsDisplayed = driver.findElement(By.xpath("//*[contains(text(),'"+errorMessages+"')]")).isDisplayed();
            Assertions.assertTrue(errorMessageIsDisplayed,"The error message : " + errorMessages+ " is displayed");
        });

    }
}
