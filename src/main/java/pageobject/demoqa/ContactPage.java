package pageobject.demoqa;

import static com.codeborne.selenide.Selenide.$;

public class ContactPage extends GeneralMenu{

    public boolean isPageLoaded() {
        return pageTitle().getText().contains("Contacts");
    }

}
