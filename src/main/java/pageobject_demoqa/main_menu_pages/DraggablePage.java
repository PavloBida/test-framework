package pageobject_demoqa.main_menu_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobject_demoqa.SideMenu;

public class DraggablePage extends SideMenu{

    @FindBy(css=".entry-title")
    public WebElement pageTitle;

    /*
    Default functionality section
     */
    @FindBy(xpath="//a[text()='Default functionality']")
    public WebElement defaultFunctionalityButton;

    @FindBy(id="draggable")
    public WebElement draggableBox;

    /*
    Constraint movement section
     */
    @FindBy(xpath="//a[text()='Constrain movement']")
    public WebElement constraintMovementButton;

    /*
    Cursor style section
     */
    @FindBy(xpath="//a[text()='Cursor style']")
    public WebElement cursorSttleButton;

    /*
    Events section
     */
    @FindBy(xpath="//a[text()='Events']")
    public WebElement eventsButton;

    /*
    Draggable + Sortable section
     */
    @FindBy(xpath="//a[text()='Draggable + Sortable']")
    public WebElement draggableSortableButton;

    /*
    A box which displays the chosen section's elements
     */
    @FindBy(xpath="//div[@aria-hidden='false']/div")
    public WebElement activeContainer;

    protected WebDriver driver;

    public DraggablePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void dragDraggableBox(int xOffset, int yOffset) {
        new Actions(driver)
                .dragAndDropBy(draggableBox, xOffset, yOffset)
                .build()
                .perform();
    }
}
