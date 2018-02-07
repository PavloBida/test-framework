package keyword_driven.keyword_driven_pageobject;

import keyword_driven.keywords.Action;
import keyword_driven.keywords.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class TopMenu {

    protected ExtendedWebElement homeButton = new ExtendedWebElement(By.cssSelector("#menu-item-38"), "'Home' button");
    protected ExtendedWebElement aboutUsButton = new ExtendedWebElement(By.cssSelector("#menu-item-158"), "'About us' button");
    protected ExtendedWebElement servicesButton = new ExtendedWebElement(By.cssSelector( "#menu-item-155"), "'Services' button");
    protected ExtendedWebElement demoDropdown = new ExtendedWebElement(By.cssSelector("#menu-item-66"), "'Demo' dropdown");
    protected ExtendedWebElement blogButton = new ExtendedWebElement(By.cssSelector("#menu-item-65"), "'Blog' button");
    protected ExtendedWebElement contactButton = new ExtendedWebElement(By.cssSelector("#menu-item-64"), "'Contact' button");

    WebDriver driver;
    Action action;

    public TopMenu(WebDriver driver) {
        this.driver = driver;
        this.action = new Action(driver);
    }

    @Step("Clicked 'Home' button")
    public void clickHomeButton() {
        action.click(homeButton);
    }

    @Step("Clicked 'About us' button")
    public void clickAboutUsButton() {
        action.click(aboutUsButton);
    }

    @Step("Clicked 'Services' button")
    public void clickServicesButton() {
        action.click(servicesButton);
    }

    @Step("Clicked 'Blog' button")
    public void clickBlogButton() {
        action.click(blogButton);
    }

    @Step("Clicked 'Contact' button")
    public void clickContactButton() {
        action.click(contactButton);
    }
}
