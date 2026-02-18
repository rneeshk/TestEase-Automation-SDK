package com.testease.actions.mouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.testease.logger.Log;

public class MouseActions {

    public static void hover(WebDriver driver, By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
        Log.info("Hovered on element: " + locator);
    }

    public static void dragAndDrop(WebDriver driver, By source, By target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(
                driver.findElement(source),
                driver.findElement(target)
        ).perform();

        Log.info("Drag and drop completed");
    }
}
