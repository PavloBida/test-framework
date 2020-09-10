package android;

import com.codeborne.selenide.WebDriverRunner;
import ui_core.AndroidDriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Created by Pavlo Bida in 2017
 * https://github.com/PavloBida
 */

public class AndroidNativeBase {

    @Parameters({"deviceId", "androidVersion", "appPath", "appPackage", "appActivity", "url"})
    @BeforeClass
    protected void setup(String deviceId, String androidVersion, String appPath, String appPackage, String appActivity, String url) {
        WebDriverRunner.setWebDriver(new AndroidDriverFactory(deviceId, androidVersion, appPath, appPackage, appActivity, url).getAndroidDriver());

    }

    @AfterClass
    protected void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

}
