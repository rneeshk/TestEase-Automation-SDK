package com.testease.core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.testease.actions.alert.AlertActions;
import com.testease.actions.click.ClickActions;
import com.testease.actions.dropdown.DropdownActions;
import com.testease.actions.frame.FrameActions;
import com.testease.actions.input.InputActions;
import com.testease.actions.mouse.MouseActions;
import com.testease.actions.scroll.ScrollActions;
import com.testease.actions.selection.SelectionActions;
import com.testease.actions.upload.UploadActions;
import com.testease.actions.window.WindowActions;
import com.testease.engine.ActionExecutor;

public class TestEase {

    // CLICK
	public static void click(WebDriver driver, By locator) {
	    ActionExecutor.execute(driver, locator, () -> {
	        ClickActions.click(driver, locator);
	    });
	}

    // TYPE
	public static void type(WebDriver driver, By locator, String text) {
	    ActionExecutor.execute(driver, locator, () -> {
	        InputActions.type(driver, locator, text);
	    });
	}


    // DROPDOWN - SELECT
    public static void selectByText(WebDriver driver, By locator, String text) {
        ActionExecutor.execute(driver, locator, () -> {
            DropdownActions.selectByText(driver, locator, text);
        });
    }

    // DROPDOWN - CUSTOM
    public static void selectCustom(WebDriver driver, By dropdown, By option) {
        ActionExecutor.execute(driver, dropdown, () -> {
            DropdownActions.selectCustom(driver, dropdown, option);
        });
    }

    // CHECKBOX
    public static void check(WebDriver driver, By locator) {
        ActionExecutor.execute(driver, locator, () -> {
            SelectionActions.check(driver, locator);
        });
    }

    public static void uncheck(WebDriver driver, By locator) {
        ActionExecutor.execute(driver, locator, () -> {
            SelectionActions.uncheck(driver, locator);
        });
    }

    // RADIO
    public static void selectRadio(WebDriver driver, By locator) {
        ActionExecutor.execute(driver, locator, () -> {
            SelectionActions.selectRadio(driver, locator);
        });
    }

    // ALERTS
    public static void acceptAlert(WebDriver driver) {
        ActionExecutor.execute(driver, () -> {
            AlertActions.accept(driver);
        });
    }


    public static void dismissAlert(WebDriver driver) {
        ActionExecutor.execute(driver, () -> {
            AlertActions.dismiss(driver);
        });
    }

    public static void alertSendKeys(WebDriver driver, String text) {
        AlertActions.sendKeys(driver, text);
    }

    // FRAMES
    public static void switchToFrame(WebDriver driver, By locator) {
        ActionExecutor.execute(driver, () -> {
            FrameActions.switchToFrame(driver, locator);
        });
    }

    public static void switchBack(WebDriver driver) {
        FrameActions.switchBack(driver);
    }

    // SCROLL
    public static void scrollToElement(WebDriver driver, By locator) {
        ScrollActions.scrollToElement(driver, locator);
    }

    public static void scrollToBottom(WebDriver driver) {
        ActionExecutor.execute(driver, () -> {
            ScrollActions.scrollToBottom(driver);
        });
    }

    // MOUSE
    public static void hover(WebDriver driver, By locator) {
        MouseActions.hover(driver, locator);
    }

    public static void dragAndDrop(WebDriver driver, By source, By target) {
        MouseActions.dragAndDrop(driver, source, target);
    }

    // WINDOW
    public static void switchToNewTab(WebDriver driver) {
        WindowActions.switchToNewTab(driver);
    }

    // FILE UPLOAD
    public static void uploadFile(WebDriver driver, By locator, String filePath) {
        UploadActions.uploadFile(driver, locator, filePath);
    }
    
    // Press Enter
    public static void pressEnter(WebDriver driver, By locator) {
        ActionExecutor.execute(driver, locator, () ->
            driver.findElement(locator).sendKeys(Keys.ENTER)
        );
    }
}
