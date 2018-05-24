package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Synchronization {

    private static final Logger LOG = LogFactory.getLogger(Synchronization.class);

    private WebDriver driver;

    public Synchronization(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * WebDriver Fluent Wait
     * Waits for an element for 20 seconds, polling every 100 milliseconds, ignoring NoSuchElementException.
     * @param selector  Selector with which an element should be located
     * @return          A WebElement instance in case an element has been found
     */
    public WebElement waitAndGetWebElement(By selector) {
        LOG.info(String.format("Waiting for element with selector: %s", selector));
        return new FluentWait<>(driver)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .withTimeout(20, TimeUnit.SECONDS)
                .withMessage("Couldn't find element even after 20 seconds")
                .until(webElement -> driver.findElement(selector));
    }

    /**
     * WebDriver Explicit Wait
     * Waits for an element for specified amount of time
     * @param webElement    WebElement that should be located
     * @param timeout       The amount of time (seconds) to wait for an element
     * @return              True if the element has appeared and false if has not
     */
    public boolean waitForElement(WebElement webElement, long timeout) {
        LOG.info(String.format("Explicitly waiting up to %d seconds", timeout));
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(webElement)).isDisplayed();
    }

    /**
     * A least preferred type of synchronization, USE IT ONLY AS A LAST RESORT
     * This method stops application execution for the specified amount of time
     * @param seconds
     */
    public void sleep(int seconds) {
        long milliseconds = seconds * 1000;  // Converting seconds to milliseconds
        try {
            LOG.info(String.format("Sleeping for %d seconds", seconds));
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            LOG.error(e.getMessage());
        }
    }
}
