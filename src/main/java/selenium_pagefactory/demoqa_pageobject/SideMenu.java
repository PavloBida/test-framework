package selenium_pagefactory.demoqa_pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideMenu extends TopMenu {

    // Registration section

    @FindBy(css = "#menu-item-374")
    public WebElement registrationButton;

    // Interaction section

    @FindBy(css = "#menu-item-140")
    public WebElement draggableButton;

    @FindBy(css = "#menu-item-141")
    public WebElement droppableButton;

    @FindBy(css = "#menu-item-143")
    public WebElement resizableButton;

    @FindBy(css = "#menu-item-142")
    public WebElement selectableButton;

    @FindBy(css = "#menu-item-151")
    public WebElement sortableButton;

    // Widget section

    @FindBy(css = "#menu-item-144")
    public WebElement accordionButton;

    @FindBy(css = "#menu-item-145")
    public WebElement autoCompleteButton;

    @FindBy(css = "#menu-item-146")
    public WebElement datePickerButton;

    @FindBy(css = "#menu-item-147")
    public WebElement menuButton;

    @FindBy(css = "#menu-item-97")
    public WebElement sliderButton;

    @FindBy(css = "#menu-item-98")
    public WebElement tabsButton;

    @FindBy(css = "#menu-item-99")
    public WebElement tooltipButton;

    // Frames and Windows section

    @FindBy(css = "#menu-item-148")
    public WebElement framesAndWindowsButton;

    WebDriver driver;

    public SideMenu(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
