package org.epam.testng.Test;

import org.epam.testng.Pages.LoginPage;
import org.epam.testng.Test.BaseTest;
import org.epam.testng.Utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class LoginTest{
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = BaseTest.getDriver(); // Get the ThreadLocal WebDriver instance
        loginPage = new LoginPage(driver); // Initialize LoginPage
    }

    @AfterMethod
    public void tearDown() {
        BaseTest.quitDriver(); // Quits the driver after each test
    }

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        return ExcelUtils.readExcel("src/test/resources/testData.xlsx", "LoginData");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password) {
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clicklogIn();
        Assert.assertTrue(loginPage.islogedIn());
        Assert.assertTrue(loginPage.islogOutAvailable());
    }

}