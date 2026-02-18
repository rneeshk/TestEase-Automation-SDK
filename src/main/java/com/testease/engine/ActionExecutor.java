package com.testease.engine;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.testease.analytics.LocatorTracker;
import com.testease.logger.Log;
import com.testease.retry.RetryEngine;
import com.testease.utils.ScreenshotUtil;

public class ActionExecutor {

    // For locator-based actions
    public static void execute(WebDriver driver, By locator, Runnable action) {

        long startTime = System.currentTimeMillis();

        try {
            highlight(driver, locator);

            RetryEngine.execute(action);

            long endTime = System.currentTimeMillis();
            Log.info("Action completed in: " + (endTime - startTime) + " ms");

        } catch (Exception e) {

            LocatorTracker.recordFailure(locator.toString());

            String safeName = locator.toString().replaceAll("[^a-zA-Z0-9]", "");
            ScreenshotUtil.capture(driver, "ACTION_FAIL_" + safeName);

            Log.error("Action failed for locator: " + locator);
            throw e;
        }
    }

    // For non-locator actions (alerts, windows, etc.)
    public static void execute(WebDriver driver, Runnable action) {

        long startTime = System.currentTimeMillis();

        try {
            RetryEngine.execute(action);

            long endTime = System.currentTimeMillis();
            Log.info("Action completed in: " + (endTime - startTime) + " ms");

        } catch (Exception e) {
            Log.error("Action failed");
            throw e;
        }
    }

    private static void highlight(WebDriver driver, By locator) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                "arguments[0].style.border='3px solid yellow'",
                driver.findElement(locator)
            );
        } catch (Exception ignored) {}
    }
}
