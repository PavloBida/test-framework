package common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.URL;

public class BaseSetup {

    private AppiumDriver driver;

    protected AppiumDriver getDriver() {return this.driver;}

    @Parameters({"platformName", "deviceName", "platformVersion", "browserName", "systemPort", "serverURL"})
    @BeforeMethod(alwaysRun = true)
    public void setUp
            (
                    String platformName,
                    String deviceName,
                    String platformVersion,
                    String browserName,
                    String systemPort,
                    String serverUrl
            )
            throws Exception {

        if (platformName.equals("Android")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("platformVersion", platformVersion);
            capabilities.setCapability("systemPort", systemPort);
            capabilities.setCapability("browserName", browserName);
            capabilities.setCapability("automationName", "UIAutomator2");

            driver = new AndroidDriver(new URL(serverUrl), capabilities);
        }
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

}
