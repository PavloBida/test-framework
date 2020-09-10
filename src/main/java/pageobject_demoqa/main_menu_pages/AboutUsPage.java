package pageobject_demoqa.main_menu_pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject_demoqa.SideMenu;

public class AboutUsPage extends SideMenu {

    @FindBy(css = ".entry-title")
    WebElement pageTitle;

    @FindBy(css = ".entry-content p")
    WebElement pageContent;

    WebDriver driver;

    public AboutUsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verifying that 'About us' page is opened")
    public boolean isPageLoaded() {
        return pageTitle.getText().equals("About us");
    }

}
