package pageobject_demoqa.main_menu_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject_demoqa.SideMenu;
import ru.yandex.qatools.allure.annotations.Step;

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

    @Step("Verifying that 'Contact' page is opened")
    public boolean isPageLoaded() {
        return pageTitle.getText().equals("Contact");
    }
}
