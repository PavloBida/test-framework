package keyword_driver;

import common.LogFactory;
import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import ru.yandex.qatools.allure.annotations.Step;

public class Action {

    private static final Logger LOG = LogFactory.getLogger(Action.class);

    private WebDriver driver;

    public Action(WebDriver driver) {
        this.driver = driver;
    }

    public void click(ExtendedWebElement element) {
        driver.findElement(element.getLocator()).click();
        LOG.info("Clicked on element : " + element.getName());
    }

    public String getText(ExtendedWebElement element) {
        return driver.findElement(element.getLocator()).getText();
    }

}
