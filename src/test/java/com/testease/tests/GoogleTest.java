package com.testease.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.testease.base.BaseTest;
import com.testease.core.TestEase;


public class GoogleTest extends BaseTest {

	@Test
	public void searchInGoogle() {

	    TestEase.type(driver, By.name("q"), "Selenium WebDriver");
	    TestEase.click(driver, By.name("btnK"));
	}
}
