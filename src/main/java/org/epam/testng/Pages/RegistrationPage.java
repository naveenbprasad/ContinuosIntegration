package org.epam.testng.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private By emailField = By.id("email_create");
    private By signupButton = By.id("SubmitCreate");
    private By firstNameField = By.id("customer_firstname");
    private By lastNameField = By.id("customer_lastname");
    private By passwordField = By.id("passwd");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By registerButton = By.id("submitAccount");
    private By successMessage = By.cssSelector(".info-account");
    private By errorMessage = By.id("create_account_error");
    private By accountform = By.id("account-creation_form");
    WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSignup() {
        driver.findElement(signupButton).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        new Select(driver.findElement(dayDropdown)).selectByValue(day);
        new Select(driver.findElement(monthDropdown)).selectByValue(month);
        new Select(driver.findElement(yearDropdown)).selectByValue(year);
    }

    public void checkNewsletter() {
        if (!driver.findElement(newsletterCheckbox).isSelected()) {
            driver.findElement(newsletterCheckbox).click();
        }
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public boolean isRegistrationSuccess() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public boolean isConfirmationMessageDisplayed() {
        return isRegistrationSuccess();
    }

    public boolean isErrorMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorMessage)));
        return driver.findElement(errorMessage).isDisplayed();
    }

    public void isFormDisplayed() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(signupButton)));
        wait.until(ExpectedConditions.visibilityOfElementLocated((accountform)));
    }
}
