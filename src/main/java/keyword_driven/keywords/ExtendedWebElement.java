package keyword_driven.keywords;

import org.openqa.selenium.*;

public class ExtendedWebElement {

    private By locator;
    private String name;

    public ExtendedWebElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public By getLocator() {
        return this.locator;
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
