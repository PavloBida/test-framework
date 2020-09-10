package util;

import core.LogFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;

public class WebHelper {

    private static final Logger LOG = LogFactory.getLogger(WebHelper.class);

    private WebDriver driver;

    public WebHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Scrolls page to specified element.
     */
    public void scrollToElement(WebElement element) {
        LOG.info("Scrolling to web element");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        long windowHeight = (long) jse.executeScript("return window.innerHeight");

        // scrolls element into view
        jse.executeScript("arguments[0].scrollIntoView(true);", element);

        // and then scroll half-way up the page, to ensure
        // the element is not obscured by another element.
        jse.executeScript("window.scrollBy(0, " + -(windowHeight / 2) + ")", "");
    }

}
