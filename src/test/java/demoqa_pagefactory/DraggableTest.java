package demoqa_pagefactory;

import common.WebTestBase;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject_demoqa.main_menu_pages.DraggablePage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class DraggableTest extends WebTestBase {

    private static final int DRAG_LENGTH = 25;

    private DraggablePage draggablePage;
    private Point beforeLocation;
    private Point afterLocation;

    @BeforeClass
    public void openDraggablePage() {
        draggablePage = homePage.clickDraggableButton();
    }

    @Test(priority = 5, description = "Dragging web element scenario")
    @Features("Dragging")
    @Severity(SeverityLevel.NORMAL)
    @Step("Verifying dragging the box around")
    @Description("Verifies that the box can be dragged around on the Draggable page")
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
