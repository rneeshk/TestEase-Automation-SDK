package com.testease.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;
import com.testease.analytics.LocatorTracker;
import com.testease.driver.DriverManager;
import com.testease.logger.Log;
import com.testease.reporting.ReportManager;
import com.testease.utils.ConfigReader;
import com.testease.utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;
    protected ExtentTest test;

    @BeforeMethod
    public void setup(Method method) {

        // Create Extent test
        test = ReportManager.getReport().createTest(method.getName());

        Log.info("Launching browser");

        driver = DriverManager.getDriver();
        driver.manage().window().maximize();

        String url = ConfigReader.get("url");
        Log.info("Opening URL: " + url);

        driver.get(url);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            Log.error("Test Failed: " + result.getName());

            ScreenshotUtil.capture(driver, result.getName());
            test.fail("Test Failed: " + result.getName());

        } else {
            Log.info("Test Passed: " + result.getName());
            test.pass("Test Passed: " + result.getName());
        }

        DriverManager.quitDriver();
        Log.info("Browser closed");
    }

    @AfterSuite
    public void generateLocatorReport() {

        // Flush extent report
        ReportManager.getReport().flush();

        // Print locator analytics
        LocatorTracker.printReport();
    }
}
