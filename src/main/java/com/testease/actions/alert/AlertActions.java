package com.testease.actions.alert;

import org.openqa.selenium.WebDriver;
import com.testease.logger.Log;

public class AlertActions {

    public static void accept(WebDriver driver) {
        driver.switchTo().alert().accept();
        Log.info("Alert accepted");
    }

    public static void dismiss(WebDriver driver) {
        driver.switchTo().alert().dismiss();
        Log.info("Alert dismissed");
    }

    public static void sendKeys(WebDriver driver, String text) {
        driver.switchTo().alert().sendKeys(text);
        Log.info("Text entered into alert: " + text);
    }
}
