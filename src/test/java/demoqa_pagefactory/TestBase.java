package demoqa_pagefactory;

import common.WebDriverFactory;
import enums.BrowserEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import selenium_pagefactory.demoqa_pageobject.HomePage;

public class TestBase {

    private WebDriverFactory webDriverFactory;
    protected WebDriver driver;
    protected HomePage homePage;

    @Parameters("browser")
    @BeforeClass
    public void setup(BrowserEnum browser) {
        webDriverFactory = new WebDriverFactory(browser);
        driver = webDriverFactory.getWebdriver();
        driver.get(HomePage.URL);
        homePage = PageFactory.initElements(driver, HomePage.class);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
