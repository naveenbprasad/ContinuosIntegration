package org.epam.testng.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By logInButton = By.id("SubmitLogin");
    private By logOutButton = By.cssSelector(".logout");
    private By invalidCredentialsMessage = By.cssSelector(".alert-danger");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clicklogIn() {
        driver.findElement(logInButton).click();
    }

    public boolean islogedIn() {
        return driver.findElement(logOutButton).isDisplayed();
    }

    public boolean islogOutAvailable() {
        return driver.findElement(logOutButton).isDisplayed();
    }

    public void clicklogOut() {
        driver.findElement(logOutButton).click();
    }

    public boolean islogedOut() {
        return driver.findElement(logInButton).isDisplayed();
    }

    public boolean islogInPageDisplayed() {
        return driver.findElement(logInButton).isDisplayed();
    }

    public boolean isInvalidCredentialsMessageDisplayed() {
        return driver.findElement(invalidCredentialsMessage).isDisplayed();
    }
}