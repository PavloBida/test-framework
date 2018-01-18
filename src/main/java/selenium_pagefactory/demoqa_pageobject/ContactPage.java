package selenium_pagefactory.demoqa_pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends SideMenu {

    @FindBy(css = ".entry-title")
    WebElement pageTitle;

    @FindBy(xpath = "//input[@name='your-name']")
    WebElement yourNameInputField;

    @FindBy(xpath = "//input[@name='your-email']")
    WebElement yourEmailInputField;

    @FindBy(xpath = "//input[@name='your-subject']")
    WebElement yourSubjectInputField;

    @FindBy(xpath = "//input[@name='your-message']")
    WebElement yourMessageInputField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitButton;

    WebDriver driver;

    public ContactPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isPageLoaded() {
        return pageTitle.getText().equals("Contact");
    }
}
