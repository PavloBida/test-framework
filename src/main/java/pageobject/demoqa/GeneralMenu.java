package pageobject.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.Page;

public abstract class GeneralMenu extends Page{

    WebDriver webDriver;

    public GeneralMenu(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @FindBy(css = ".entry-title")
    protected WebElement pageTitle;

}
