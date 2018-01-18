package demoqa_pagefactory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void verifyTopMenuElements() {
        Assert.assertTrue(homePage.aboutUsButton.isDisplayed());
        Assert.assertTrue(homePage.servicesButton.isDisplayed());
        Assert.assertTrue(homePage.demoDropdown.isDisplayed());
        Assert.assertTrue(homePage.blogButton.isDisplayed());
        Assert.assertTrue(homePage.contactButton.isDisplayed());
    }

    @Test
    public void verifySideMenuElements() {
        Assert.assertTrue(homePage.registrationButton.isDisplayed());
        Assert.assertTrue(homePage.draggableButton.isDisplayed());
        Assert.assertTrue(homePage.droppableButton.isDisplayed());
        Assert.assertTrue(homePage.resizableButton.isDisplayed());
        Assert.assertTrue(homePage.selectableButton.isDisplayed());
        Assert.assertTrue(homePage.sortableButton.isDisplayed());
        Assert.assertTrue(homePage.accordionButton.isDisplayed());
        Assert.assertTrue(homePage.autoCompleteButton.isDisplayed());
        Assert.assertTrue(homePage.datePickerButton.isDisplayed());
        Assert.assertTrue(homePage.menuButton.isDisplayed());
        Assert.assertTrue(homePage.sliderButton.isDisplayed());
        Assert.assertTrue(homePage.tabsButton.isDisplayed());
        Assert.assertTrue(homePage.tooltipButton.isDisplayed());
        Assert.assertTrue(homePage.framesAndWindowsButton.isDisplayed());

    }
}
