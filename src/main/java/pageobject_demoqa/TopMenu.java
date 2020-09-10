package pageobject_demoqa;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobject_demoqa.main_menu_pages.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TopMenu {

    @FindBy(css = "#menu-item-38")
    public WebElement homeButton;

    @FindBy(css = "#menu-item-158")
    public WebElement aboutUsButton;

    @FindBy(css = "#menu-item-155")
    public WebElement servicesButton;

    @FindBy(css = "#menu-item-66")
    public WebElement demoDropdown;

    @FindBy(css = "#menu-item-65")
    public WebElement blogButton;

    @FindBy(css = "#menu-item-64")
    public WebElement contactButton;

    WebDriver driver;

    public TopMenu(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Clicked Home button")
    public HomePage clickHomeButton() {
        homeButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

    @Step("Clicked About us button")
    public AboutUsPage clickAboutUsButton() {
        aboutUsButton.click();
        return PageFactory.initElements(driver, AboutUsPage.class);
    }

    @Step("Clicked Services button")
    public ServicesPage clickServicesButton() {
        servicesButton.click();
        return PageFactory.initElements(driver, ServicesPage.class);
    }

    @Step("Clicked Blog button")
    public BlogPage clickBlogButton() {
        blogButton.click();
        return PageFactory.initElements(driver, BlogPage.class);
    }

    @Step("Clicked Contact button")
    public ContactPage clickContactButton() {
        contactButton.click();
        return PageFactory.initElements(driver, ContactPage.class);
    }

    public List<WebElement> getAllTopMenuButtons() {
        return new LinkedList<>(Arrays.asList(
                homeButton, aboutUsButton, servicesButton, demoDropdown, blogButton, contactButton)
        );
    }


}
