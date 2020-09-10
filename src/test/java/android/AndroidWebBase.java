package android;

import ui_core.AndroidDriverFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class AndroidWebBase {

    private AppiumDriver driver;
    private AndroidDriverFactory androidDriverFactory;

    protected AppiumDriver getDriver() {return this.driver;}

    @Parameters({"deviceName", "platformVersion", "browserName", "serverURL"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String deviceName, String androidVersion, String browserName, String serverUrl){
        androidDriverFactory =  new AndroidDriverFactory(deviceName, androidVersion, browserName, serverUrl);
        this.driver = androidDriverFactory.getAndroidDriver();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

}
