package demoqa_pagefactory;

import common.Synchronization;
import common.WebDriverFactory;
import enums.BrowserEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageobject_demoqa.main_menu_pages.HomePage;

public class TestBase {

    protected Synchronization sync;
    protected WebDriver driver;
    protected HomePage homePage;

    /**
     * - Initializing WebDriver for the browser, specified in testng.xml
     *   If no browser is specified - Chrome is used by default
     * - Initializing HomePage for demoqa.com website
     * - Initializing other objects, that are needed in each test
     * @param browser
     */
    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("CHROME") BrowserEnum browser) {
        driver = new WebDriverFactory(browser).getWebdriver();
        sync = new Synchronization(driver);
        driver.get(HomePage.URL);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
