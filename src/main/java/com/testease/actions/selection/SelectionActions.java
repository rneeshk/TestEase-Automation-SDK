package com.testease.actions.selection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.testease.logger.Log;
import com.testease.waits.WaitHelper;

public class SelectionActions {

    public static void check(WebDriver driver, By locator) {
        WebElement element = WaitHelper.getWait(driver)
                .until(ExpectedConditions.elementToBeClickable(locator));

        if (!element.isSelected()) {
            element.click();
            Log.info("Checkbox selected: " + locator);
        }
    }

    public static void uncheck(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);

        if (element.isSelected()) {
            element.click();
            Log.info("Checkbox unselected: " + locator);
        }
    }

    public static void selectRadio(WebDriver driver, By locator) {
        WebElement element = WaitHelper.getWait(driver)
                .until(ExpectedConditions.elementToBeClickable(locator));

        element.click();
        Log.info("Radio button selected: " + locator);
    }
}
