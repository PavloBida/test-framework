package keyword_driven_pageobject;


import keyword_driver.Action;
import keyword_driver.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class AboutUsPage extends TopMenu {

    ExtendedWebElement pageTitle =
            new ExtendedWebElement(By.cssSelector(".entry-title"), "'About us' page title");

    ExtendedWebElement pageContent =
            new ExtendedWebElement(By.cssSelector(".entry-content p"), "'About us' page content");

    WebDriver driver;
    Action action;

    public AboutUsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.action = new Action(driver);
    }

    @Step("Verified whether 'About us' page is loaded")
    public boolean isPageLoaded() {
        return action.getText(pageTitle).equals("About us");
    }

}
