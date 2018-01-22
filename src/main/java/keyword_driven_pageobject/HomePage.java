package keyword_driven_pageobject;

import keyword_driver.Action;
import keyword_driver.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HomePage extends TopMenu {

    public static final String URL = "http://demoqa.com";

    private ExtendedWebElement pageTitle =
            new ExtendedWebElement(By.cssSelector(".entry-title"), "Page Title");

    private Action action;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        action = new Action(driver);
    }

    @Step("Verifying whether the HomePage is loaded")
    public boolean isPageLoaded() {
        return action.getText(pageTitle).equals("Home");
    }
}
