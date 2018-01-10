package common;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Created by Pavlo Bida in 2017
 * https://github.com/PavloBida
 */

public class AndroidTestBase {

    @Parameters({"deviceId", "androidVersion", "appPath", "appPackage", "appActivity"})
    @BeforeClass
    protected void setup(String deviceId, String androidVersion, String appPath, String appPackage, String appActivity) {
        WebDriverRunner.setWebDriver(new AndroidDriverFactory(deviceId, androidVersion, appPath, appPackage, appActivity).getAndroidDriver());
    }

    @AfterClass
    protected void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

}
