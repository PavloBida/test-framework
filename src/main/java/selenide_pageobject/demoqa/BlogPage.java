package selenide_pageobject.demoqa;

import static com.codeborne.selenide.Selenide.$;

public class BlogPage extends GeneralMenu {

    public boolean isPageLoaded() {
        return pageTitle().getText().contains("Blog");
    }
}
