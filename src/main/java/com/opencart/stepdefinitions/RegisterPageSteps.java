package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();//singleton
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the register form is populated with valid random data")
    public void theRegisterFormIsPopulatedWithValidRandomData() throws InterruptedException {
        String randomEmail = RandomDataManager.generateRandomEmail();
        String password = RandomDataManager.generatePassword();

        System.out.println(randomEmail);
        System.out.println(password);

        registerPage.fillInTheRegisterForm(
                RandomDataManager.generateFirstName(),
                RandomDataManager.generateLastName(),
                randomEmail,
                password,
                true);

       // registerPage.fillInTheRegisterForm("dsgasdfcas","sdfsdfsvsdv","ahdfashg@gmail.com","afssdvsfd",true);
        Thread.sleep(1000);
        System.out.println("The Register Form is populated with valid random data");
    }

    @And("Continue button is clicked")
    public void continueButtonIsClicked() throws InterruptedException {
        registerPage.clickTheContinueButton();
        Thread.sleep(500);
        System.out.println("The continue button has been clicked");
    }

    @When("the Register Form is populated with the following data:")
    public void theRegisterFormIsPopulatedWithTheFollowingData(Map<String, String> formDataMap) throws InterruptedException {
        String firstNameValue = formDataMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")){
            firstNameValue = RandomDataManager.generateFirstName();
        }
        String lastNameValue = formDataMap.get("lastName");
        if (lastNameValue != null && lastNameValue.toUpperCase().equals("RANDOM")){
            lastNameValue = RandomDataManager.generateLastName();
        }
        String emailInput = formDataMap.get("email");
        if (emailInput !=null && emailInput.equalsIgnoreCase("RANDOM")){
            emailInput = RandomDataManager.generateRandomEmail();
        }
        String password = formDataMap.get("password");
        if (password != null && password.equalsIgnoreCase("RANDOM")){
            password = RandomDataManager.generatePassword();
        }
        registerPage.fillInTheRegisterForm(firstNameValue, lastNameValue, emailInput, password, true);
        Thread.sleep(1000);
    }
}
