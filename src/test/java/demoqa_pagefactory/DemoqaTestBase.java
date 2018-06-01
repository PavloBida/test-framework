package demoqa_pagefactory;

import common.WebTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import pageobject_demoqa.main_menu_pages.HomePage;

public class DemoqaTestBase extends WebTestBase {
    protected HomePage homePage;

    @BeforeClass
    public void openDemoqa() {
        driver.get(HomePage.URL);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }
}
