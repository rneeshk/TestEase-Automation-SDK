package com.testease.actions.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.testease.actions.click.ClickActions;
import com.testease.logger.Log;

public class DropdownActions {

    public static void selectByText(WebDriver driver, By locator, String text) {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
        Log.info("Selected dropdown text: " + text);
    }

    public static void selectCustom(WebDriver driver, By dropdown, By option) {
        ClickActions.click(driver, dropdown);
        ClickActions.click(driver, option);
        Log.info("Selected custom dropdown option");
    }
}
