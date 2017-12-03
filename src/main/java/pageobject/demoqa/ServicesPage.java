package pageobject.demoqa;

import static com.codeborne.selenide.Selenide.$;

public class ServicesPage extends GeneralMenu {

    public boolean isPageLoaded() {
        return pageTitle().getText().contains("Services");
    }
}
