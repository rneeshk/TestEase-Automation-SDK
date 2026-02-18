package com.testease.actions.upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testease.logger.Log;

public class UploadActions {

    public static void uploadFile(WebDriver driver, By locator, String filePath) {
        driver.findElement(locator).sendKeys(filePath);
        Log.info("File uploaded: " + filePath);
    }
}
