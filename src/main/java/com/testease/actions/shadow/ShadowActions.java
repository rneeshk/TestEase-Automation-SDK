package com.testease.actions.shadow;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testease.logger.Log;

public class ShadowActions {

    public static WebElement getShadowElement(WebDriver driver, By host, By element) {
        WebElement shadowHost = driver.findElement(host);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowRoot = (WebElement) js.executeScript(
                "return arguments[0].shadowRoot", shadowHost);

        Log.info("Accessed shadow DOM");

        return shadowRoot.findElement(element);
    }
}
