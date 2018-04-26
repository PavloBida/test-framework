package pageobject_demoqa.main_menu_pages;

import org.openqa.selenium.WebDriver;
import pageobject_demoqa.SideMenu;

public class BlogPage extends SideMenu {

    private WebDriver driver;

    public BlogPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
