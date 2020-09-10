package demoqa_pagefactory;

import io.qameta.allure.*;
import ui_core.WebTestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends WebTestBase {

    @Test(priority = 1, description = "Top menu testing")
    @Severity(SeverityLevel.BLOCKER)
    @Step("Verifying that top menu elements are displayed")
    @Description("Verifies that all buttons on the top menu are displayed")
    public void verifyTopMenuElements() {
        for(WebElement element : homePage.getAllTopMenuButtons()) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @Test(priority = 1, description = "Side menu testing")
    @Severity(SeverityLevel.BLOCKER)
    @Step("Verifying that side menu elements are displayed")
    @Description("Verifies that all buttons on the side menu are displayed")
    public void verifySideMenuElements() {
        for(WebElement element : homePage.getAllSideMenuButtons()) {
            Assert.assertTrue(element.isDisplayed());
        }
    }
}
