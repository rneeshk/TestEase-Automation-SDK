package com.testease.actions.scroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.testease.logger.Log;

public class ScrollActions {

    public static void scrollToElement(WebDriver driver, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(locator));

        Log.info("Scrolled to element: " + locator);
    }

    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Log.info("Scrolled to bottom");
    }
}
