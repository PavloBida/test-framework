package selenide_pageobject.demoqa;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import selenide_pageobject.Page;

import static com.codeborne.selenide.Selenide.$;

public abstract class GeneralMenu extends Page{

    protected SelenideElement pageTitle() {
        return $(By.cssSelector(".entry-title"));
    }

    protected SelenideElement homeButton() {
        return $(By.cssSelector("#menu-item-38"));
    }

    protected SelenideElement aboutUsButton() {
        return $(By.cssSelector("#menu-item-158"));
    }

    protected SelenideElement servicesButton() {
        return $(By.cssSelector("#menu-item-155"));
    }

    protected SelenideElement demoDropdown() {
        return $(By.cssSelector("#menu-item-66"));
    }

    protected SelenideElement blogButton() {
        return $(By.cssSelector("#menu-item-65"));
    }

    protected SelenideElement contactButton() {
        return $(By.cssSelector("#menu-item-64"));
    }

    public HomePage navigateToHomePage() {
        homeButton().click();
        return new HomePage();
    }

    public AboutUsPage navigateToAboutUsPage() {
        aboutUsButton().click();
        return new AboutUsPage();
    }


}
