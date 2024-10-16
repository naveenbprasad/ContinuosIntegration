package org.epam.testng.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Private constructor to prevent instantiation
    private BaseTest() {}

    // Method to get WebDriver instance
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(new ChromeDriver());
            driver.get().manage().window().maximize();
            System.out.println("Driver initialized for thread: " + Thread.currentThread().getId());
        }
        return driver.get();
    }

    // Method to quit the WebDriver
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Clear the driver for the current thread
            System.out.println("Driver quit for thread: " + Thread.currentThread().getId());
        }
    }
}
