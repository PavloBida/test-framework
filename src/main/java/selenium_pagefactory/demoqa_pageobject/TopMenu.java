package selenium_pagefactory.demoqa_pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenu {

    @FindBy(css = "#menu-item-38")
    public WebElement homeButton;

    @FindBy(css = "#menu-item-158")
    public WebElement aboutUsButton;

    @FindBy(css = "#menu-item-155")
    public WebElement servicesButton;

    @FindBy(css = "#menu-item-66")
    public WebElement demoDropdown;

    @FindBy(css = "#menu-item-65")
    public WebElement blogButton;

    @FindBy(css = "#menu-item-64")
    public WebElement contactButton;

    WebDriver driver;

    public TopMenu(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage clickHomeButton() {
        homeButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public AboutUsPage clickAboutUsButton() {
        aboutUsButton.click();
        return PageFactory.initElements(driver, AboutUsPage.class);
    }

    public ServicesPage clickServicesButton() {
        servicesButton.click();
        return PageFactory.initElements(driver, ServicesPage.class);
    }

    public BlogPage clickBlogButton() {
        blogButton.click();
        return PageFactory.initElements(driver, BlogPage.class);
    }

    public ContactPage clickContactButton() {
        contactButton.click();
        return PageFactory.initElements(driver, ContactPage.class);
    }


}
