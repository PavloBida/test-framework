package demoqa;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.demoqa.AboutUsPage;
import pageobject.demoqa.HomePage;

public class VerifyGeneralMenu extends TestBase {

    HomePage homePage;
    AboutUsPage aboutUsPage;

    @Test
    public void verifyHomePage() {
        homePage = new HomePage();
        open(HomePage.URL);

        Assert.assertTrue(homePage.isPageLoaded());
        aboutUsPage = homePage.navigateToAboutUsPage();
        Assert.assertTrue(aboutUsPage.isPageLoaded());
    }

}
