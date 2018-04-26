package demoqa_pagefactory;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject_demoqa.main_menu_pages.AboutUsPage;
import pageobject_demoqa.main_menu_pages.ContactPage;
import pageobject_demoqa.main_menu_pages.ServicesPage;

public class MainPagesTest extends TestBase {

    @Test
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
