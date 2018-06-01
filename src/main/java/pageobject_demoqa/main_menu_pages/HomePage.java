package pageobject_demoqa.main_menu_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject_demoqa.SideMenu;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HomePage extends SideMenu {

    public static final String URL = "http://demoqa.com";

    @FindBy(css = ".entry-title")
    WebElement pageTitle;

    @FindBy(xpath = "//ul[@id='tab_ul']/li")
    public List<WebElement> tabs;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verifying that 'Home' page is opened")
    public boolean isPageLoaded() {
        return pageTitle.getText().equals("Home");
    }
}
