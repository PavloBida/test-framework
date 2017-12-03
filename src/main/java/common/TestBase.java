package common;

import com.codeborne.selenide.WebDriverRunner;
import enums.BrowserEnum;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {

    public TestBase() {

    }

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void initWebDriver(BrowserEnum browser) {
        WebDriverRunner.setWebDriver(new WebDriverFactory(browser).getWebdriver());
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        WebDriverRunner.closeWebDriver();
    }

}
