package com.testease.actions.click;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.testease.logger.Log;
import com.testease.waits.WaitHelper;

public class ClickActions {

    public static void click(WebDriver driver, By locator) {
        try {
            WebElement element = WaitHelper.getWait(driver)
                    .until(ExpectedConditions.elementToBeClickable(locator));

            element.click();
            Log.info("Clicked: " + locator);

        } catch (Exception e) {
            Log.error("Click failed: " + locator);
            throw e;
        }
    }
}
