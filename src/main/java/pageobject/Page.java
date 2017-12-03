package pageobject;

import common.LogFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.util.NoSuchElementException;

public abstract class Page implements IPageLoaded {

    private static final Logger LOG = LogFactory.getLogger(Page.class);

    protected WebDriver webDriver;

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * @return current WebDriver instance
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * @return page title
     */
    public String getTitle() {
        return webDriver.getTitle();
    }

    /**
     * @return page URL
     */
    public String getPageUrl() {
        return webDriver.getCurrentUrl();
    }

    /**
     * Verifies if the WebElement is present on the page
     * @param element to verify
     * @return
     */
    public boolean isElementPresent(WebElement element) {
        LOG.info("Checking if element is present " + element);
        try {
            element.isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Waits for the specified amount of time
     * @param seconds
     * @return
     */
    public WebDriverWait getWebDriverWait(int seconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, seconds);
        return wait;
    }

    /**
     * Clicks on element using JavaScript
     * Generally used for clicking hidden elements
     * @param webElement
     */
    public void jsClickOnElement(WebElement webElement) {
        LOG.info("Clicking on web element " + webElement);
        getJSExecutor().executeScript("arguments[0].click();", webElement);
    }

    /**
     * Scrolls the element into viewport
     * @param webElement
     */
    public void scrollToElement(WebElement webElement) {
        LOG.info("Scrollling to web element " + webElement);
        getJSExecutor().executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    /**
     * Verifies element presence on the page
     * @param seconds       wait for web element's presence
     * @param webElement    web element to look for
     * @return
     */
    public boolean isElementPresent(int seconds, WebElement webElement) {
        try {
            getWebDriverWait(seconds).until(driver -> webElement.isEnabled());
            return true;
        } catch (TimeoutException e) {
            LOG.error("Element is not available");
            return false;
        }
    }

    /**
     * JavaScript executor initialization
     * @return
     */
    private JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) webDriver;
    }

}
