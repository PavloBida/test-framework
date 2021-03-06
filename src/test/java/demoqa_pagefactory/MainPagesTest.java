package demoqa_pagefactory;

import io.qameta.allure.Description;
import io.qameta.allure.Features;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import ui_core.WebTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject_demoqa.main_menu_pages.AboutUsPage;
import pageobject_demoqa.main_menu_pages.ContactPage;
import pageobject_demoqa.main_menu_pages.ServicesPage;

public class MainPagesTest extends WebTestBase {

    @Test(priority = 2, description = "Main pages of the website testing")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifies that main pages of the website are displayed")
    public void verifyPagesAreOpened() {
        Assert.assertTrue(homePage.isPageLoaded());

        AboutUsPage aboutUsPage = homePage.clickAboutUsButton(); // Navigate to About Us page
        Assert.assertTrue(aboutUsPage.isPageLoaded());

        ServicesPage servicesPage = aboutUsPage.clickServicesButton(); // Navigate to Services page
        Assert.assertTrue(servicesPage.isPageLoaded());

        ContactPage contactPage = servicesPage.clickContactButton(); // Navigate to Contacts page
        Assert.assertTrue(contactPage.isPageLoaded());
    }

}
