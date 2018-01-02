package common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverFactory {

    private static final Logger LOG = LogFactory.getLogger(AndroidDriverFactory.class);
    private final int androidTimeout = 60 * 5;  //Default Android timeout

    DesiredCapabilities desiredCapabilities;
    URL url;
    WebDriver webDriver;
    private String deviceId;
    private String androidVersion;
    private String appPath;
    private String appPackage;
    private String appActivity;

    /**
     * This constructor needs deviceId of connected Android device, Android version and the path to Wispi app on current PC.
     * @param deviceId          Is received by running 'adb devices' in terminal.
     * @param androidVersion    Is specified in Android device's settings.
     * @param appPath           Path to the Wispi app on this PC.
     */
    public AndroidDriverFactory(String deviceId, String androidVersion, String appPath, String appPackage, String appActivity) {
        LOG.debug("Initializing AndroidDriver for deviceId " + deviceId + " on android version " + androidVersion);
        LOG.debug("Application to be executed: " + appPath);
        this.deviceId = deviceId;
        this.androidVersion = androidVersion;
        this.appPath = appPath;
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.webDriver = initializeAndroidDriver();
        configureAndroidDriver();
    }

    public WebDriver getAndroidDriver() {
        return webDriver;
    }

    /**
     * Setting all the necessary capabilities for AndroidDriver.
     * @return AndroidDriver
     */
    private AndroidDriver initializeAndroidDriver() {
        desiredCapabilities = DesiredCapabilities.android();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceId);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, androidVersion);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        //app instalation
        desiredCapabilities.setCapability("app", appPath);
        desiredCapabilities.setCapability("newCommandTimeout", androidTimeout);
        initURL();
        return new AndroidDriver(url, desiredCapabilities);
    }

    /**
     * Setting common implicit wait
     */
    private void configureAndroidDriver() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * URL to Appium server that should be running on the same machine
     */
    private void initURL() {
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
