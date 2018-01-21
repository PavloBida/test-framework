package demoqa_keyword_driven;

import common.WebDriverFactory;
import enums.BrowserEnum;
import keyword_driven_pageobject.AboutUsPage;
import keyword_driven_pageobject.HomePage;
import keyword_driver.Action;
import keyword_driver.Navigate;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class KeywordTestBase {

    private WebDriverFactory webDriverFactory;
    protected WebDriver driver;
    protected Action action;
    protected Navigate navigate;

    protected HomePage homePage;
    protected AboutUsPage aboutUsPage;

    @Parameters("browser")
    @BeforeClass
    public void setup(BrowserEnum browser) {
        webDriverFactory = new WebDriverFactory(browser);
        driver = webDriverFactory.getWebdriver();
        action = new Action(driver);
        navigate = new Navigate(driver);
        navigate.open(HomePage.URL);
        homePage = new HomePage(driver);
        aboutUsPage = new AboutUsPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
