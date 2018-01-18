package selenium_pagefactory.demoqa_pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends SideMenu {

    public static final String URL = "http://demoqa.com";

    @FindBy(css = ".entry-title")
    WebElement pageTitle;

    @FindBy(xpath = "//ul[@id='tab_ul']/li")
    public List<WebElement> tabs;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isPageLoaded() {
        return pageTitle.getText().equals("Home");
    }
}
