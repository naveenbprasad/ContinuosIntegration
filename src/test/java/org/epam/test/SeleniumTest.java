package org.epam.test;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    @Test
    public void testHelloWorld() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/my-java-webapp/");
        assertTrue(driver.getPageSource().contains("Hello, World!"));
        driver.quit();
    }
}