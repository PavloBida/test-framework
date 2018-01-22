package keyword_driver;

import common.LogFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

public class Navigate {

    private static final Logger LOG = LogFactory.getLogger(Navigate.class);

    WebDriver driver;

    public Navigate(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String URL) {
        LOG.info("Navigating URL: " + URL);
        driver.get(URL);
    }

    public void back() {
        LOG.info("Navigating back");
        driver.navigate().back();
    }

    public void forward() {
        LOG.info("Navigating forward");
        driver.navigate().forward();
    }

    public void refresh() {
        LOG.info("Refreshing page");
        driver.navigate().refresh();
    }
}
