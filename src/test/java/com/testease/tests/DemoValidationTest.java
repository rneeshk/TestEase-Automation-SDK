package com.testease.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.testease.base.BaseTest;
import com.testease.core.TestEase;

public class DemoValidationTest extends BaseTest {

    // ✅ PASSING TEST
    // Proves: type, highlight, wait, execution pipeline working
    @Test
    public void googleSearch_shouldPass() {

        TestEase.type(driver, By.name("q"), "TestEase Automation");
        TestEase.pressEnter(driver, By.name("q"));
    }

    // ❌ FAILING TEST (INTENTIONAL)
    // Proves: retry, screenshot, locator analytics, logging
    @Test
    public void invalidLocator_shouldTriggerRetryAndScreenshot() {

        // This locator does NOT exist → will fail
        TestEase.click(driver, By.id("THIS_ELEMENT_DOES_NOT_EXIST"));
    }
}
