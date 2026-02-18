package com.testease.actions.input;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.testease.logger.Log;
import com.testease.waits.WaitHelper;

public class InputActions {

    public static void type(WebDriver driver, By locator, String text) {
        try {
            WebElement element = WaitHelper.getWait(driver)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));

            element.clear();
            element.sendKeys(text);

            Log.info("Typed '" + text + "' into " + locator);

        } catch (Exception e) {
            Log.error("Typing failed: " + locator);
            throw e;
        }
    }
}
