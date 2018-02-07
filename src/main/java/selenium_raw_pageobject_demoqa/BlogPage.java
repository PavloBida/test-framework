package selenium_raw_pageobject_demoqa;

import org.openqa.selenium.WebDriver;

public class BlogPage extends SideMenu {

    private WebDriver driver;

    public BlogPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
