package demoqa_pagefactory;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void verifyTopMenuElements() {
        for(WebElement element : homePage.getAllTopMenuButtons()) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @Test
    public void verifySideMenuElements() {
        for(WebElement element : homePage.getAllSideMenuButtons()) {
            Assert.assertTrue(element.isDisplayed());
        }
    }
}
