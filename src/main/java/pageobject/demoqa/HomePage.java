package pageobject.demoqa;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.WebDriver;

public class HomePage extends GeneralMenu{

    WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public static final String URL = "http://demoqa.com";


    @Override
    public boolean isPageLoaded() {
        return $(pageTitle).getText().contains("Home");
    }

}
