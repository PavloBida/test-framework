package pageobject.demoqa;

import static com.codeborne.selenide.Selenide.$;

public class AboutUsPage extends GeneralMenu{

    public boolean isPageLoaded() {
        return pageTitle().getText().contains("About us");
    }
}
