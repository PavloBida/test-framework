package selenide_pageobject.demoqa;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends GeneralMenu{


    public static final String URL = "http://demoqa.com";


    @Override
    public boolean isPageLoaded() {
        return pageTitle().getText().contains("Home");
    }

}
