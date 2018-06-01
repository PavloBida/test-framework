package demoqa_pagefactory;

import common.WebTestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class HomePageTest extends WebTestBase {

    @Test(priority = 1, description = "Top menu testing")
    @Features("Menu")
    @Severity(SeverityLevel.BLOCKER)
    @Step("Verifying that top menu elements are displayed")
    @Description("Verifies that all buttons on the top menu are displayed")
    public void verifyTopMenuElements() {
        for(WebElement element : homePage.getAllTopMenuButtons()) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @Test(priority = 1, description = "Side menu testing")
    @Features("Menu")
    @Severity(SeverityLevel.BLOCKER)
    @Step("Verifying that side menu elements are displayed")
    @Description("Verifies that all buttons on the side menu are displayed")
    public void verifySideMenuElements() {
        for(WebElement element : homePage.getAllSideMenuButtons()) {
            Assert.assertTrue(element.isDisplayed());
        }
    }
}
