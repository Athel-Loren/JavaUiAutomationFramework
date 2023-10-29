package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends Page {
    public AccountCreatedPage(WebDriver driver){ super(driver); }

    @FindBy(xpath = "//div[@class='nav float-end']//i[@class='fa-solid fa-caret-down']")
    protected WebElement accountIcon;

    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
    protected WebElement logoutBtn;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    protected WebElement continueBtn;

    public void navigateToLogoutPageFromHeader(){
        //continueBtn.click();
        accountIcon.click();
        logoutBtn.click();
        System.out.println("The user is logged out");

    }
}
