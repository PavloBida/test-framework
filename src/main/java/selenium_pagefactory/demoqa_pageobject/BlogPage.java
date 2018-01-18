package selenium_pagefactory.demoqa_pageobject;

import org.openqa.selenium.WebDriver;

public class BlogPage extends SideMenu {

    private WebDriver driver;

    public BlogPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
