package demoqa_pagefactory;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject_demoqa.main_menu_pages.DraggablePage;

public class DraggableTest extends TestBase{

    private static final int DRAG_LENGTH = 25;

    private DraggablePage draggablePage;
    private Point beforeLocation;
    private Point afterLocation;

    @BeforeClass
    public void openDraggablePage() {
        draggablePage = homePage.clickDraggableButton();
    }

    @Test
    public void draggableTest() {
        draggablePage.defaultFunctionalityButton.click();
        beforeLocation = draggablePage.draggableBox.getLocation();
        draggablePage.dragDraggableBox(DRAG_LENGTH, DRAG_LENGTH);
        afterLocation = draggablePage.draggableBox.getLocation();

        Assert.assertTrue(afterLocation.getX() == beforeLocation.getX() + DRAG_LENGTH,
                "Failed to drag the box by correct X offset");
        Assert.assertTrue(afterLocation.getY() == beforeLocation.getY() + DRAG_LENGTH,
                "Failed to drag the box by correct Y offset");
    }
}
