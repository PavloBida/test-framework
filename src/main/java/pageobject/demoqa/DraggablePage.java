package pageobject.demoqa;

import static com.codeborne.selenide.Selenide.$;

public class DraggablePage extends GeneralMenu {

    public boolean isPageLoaded() {
        return pageTitle().getText().contains("Draggable");
    }
}
