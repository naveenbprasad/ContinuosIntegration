package org.epam.testng.Test;

import org.epam.testng.Pages.LoginPage;
import org.epam.testng.Pages.RegistrationPage;
import org.epam.testng.Utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class RegistrationTest {

    private WebDriver driver;
    private RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp() {
        driver = BaseTest.getDriver(); // Get the ThreadLocal WebDriver instance
        registrationPage = new RegistrationPage(driver); // Initialize LoginPage
    }

    @AfterMethod
    public void tearDown() {
        BaseTest.quitDriver(); // Quits the driver after each test
    }

    @DataProvider(name = "RegistrationData")
    public Object[][] loginDataProvider() {
        return ExcelUtils.readExcel("src/test/resources/testData.xlsx", "RegistrationData");
    }


    @Test(dataProvider = "RegistrationData")
    public void testLogin(String email) throws InterruptedException {
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        email = email.replaceAll("@example.com", new Random().nextInt(10000) +"@example.com");
        registrationPage.enterEmail(email);
        registrationPage.clickSignup();

        registrationPage.isFormDisplayed();

        registrationPage.enterFirstName("test first");
        registrationPage.enterLastName("test second");
        registrationPage.enterPassword("Password123");
        registrationPage.selectDateOfBirth("15","3","1990");

        registrationPage.checkNewsletter();

        registrationPage.clickRegister();
        Assert.assertTrue(registrationPage.isRegistrationSuccess());
        Assert.assertTrue(registrationPage.isConfirmationMessageDisplayed());
    }
}
