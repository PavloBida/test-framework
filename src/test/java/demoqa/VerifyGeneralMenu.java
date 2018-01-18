package demoqa;

import static com.codeborne.selenide.Selenide.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenide_pageobject.demoqa.AboutUsPage;
import selenide_pageobject.demoqa.HomePage;

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
