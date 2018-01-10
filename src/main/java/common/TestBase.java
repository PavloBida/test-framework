package common;

import com.codeborne.selenide.WebDriverRunner;
import enums.BrowserEnum;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Created by Pavlo Bida in 2017
 * https://github.com/PavloBida
 */

public class TestBase {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void initWebDriver(BrowserEnum browser) {
        System.setProperty("selenide.browser", browser.toString());
        WebDriverFactory.setProperties();
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp() {

    }

}
