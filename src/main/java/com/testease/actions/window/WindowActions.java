package com.testease.actions.window;

import org.openqa.selenium.WebDriver;
import com.testease.logger.Log;

public class WindowActions {

    public static void switchToNewTab(WebDriver driver) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        Log.info("Switched to new tab/window");
    }
}
