package demoqa_pagefactory;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium_pagefactory.demoqa_pageobject.AboutUsPage;
import selenium_pagefactory.demoqa_pageobject.ContactPage;
import selenium_pagefactory.demoqa_pageobject.ServicesPage;

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
