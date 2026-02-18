package com.testease.actions.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testease.logger.Log;

public class FrameActions {

    public static void switchToFrame(WebDriver driver, By locator) {
        driver.switchTo().frame(driver.findElement(locator));
        Log.info("Switched to frame");
    }

    public static void switchBack(WebDriver driver) {
        driver.switchTo().defaultContent();
        Log.info("Switched back to main content");
    }
}
