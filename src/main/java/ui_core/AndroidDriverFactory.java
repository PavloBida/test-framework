package ui_core;

import core.LogFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pavlo Bida in 2017
 * https://github.com/PavloBida
 */

public class AndroidDriverFactory {

    private static final Logger LOG = LogFactory.getLogger(AndroidDriverFactory.class);
    private final int androidTimeout = 60 * 5;  //Default Android timeout

    private DesiredCapabilities desiredCapabilities;
    private URL url;
    private AndroidDriver webDriver;
    private String deviceId;
    private String androidVersion;
    private String appPath;
    private String appPackage;
    private String appActivity;
    private String browserName;

    /**
     * App testing
     * This constructor needs deviceId of connected Android device, Android version and the path to an app on current PC.
     * @param deviceId          Is received by running 'adb devices' in terminal.
     * @param androidVersion    Is specified in Android device's settings.
     * @param appPath           Path to an app on this PC.
     */
    public AndroidDriverFactory(String deviceId, String androidVersion, String appPath, String appPackage, String appActivity, String url) {
        LOG.debug("Initializing AndroidDriver for deviceId " + deviceId + " on android version " + androidVersion);
        LOG.debug("Application to be executed: " + appPath);
        this.deviceId = deviceId;
        this.androidVersion = androidVersion;
        this.appPath = appPath;
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.url = transformIntoURL(url);
        this.webDriver = initializeAndroidDriver();
        configureAndroidDriver();
    }

    /**
     * Browser testing
     * @param deviceId          Is received by running 'adb devices' in terminal.
     * @param androidVersion    Is specified in Android device's settings.
     * @param browserName       Browser to run the test on
     */
    public AndroidDriverFactory(String deviceId, String androidVersion, String browserName, String url) {
        LOG.debug("Initializing AndroidDriver for deviceId " + deviceId + " on android version " + androidVersion);
        LOG.debug("Executing test on browser " + browserName);
        this.deviceId = deviceId;
        this.androidVersion = androidVersion;
        this.url = transformIntoURL(url);
        this.browserName = browserName;
        this.webDriver = initializeAndroidDriver();
        configureAndroidDriver();
    }

    public AndroidDriver getAndroidDriver() {
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
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, androidTimeout);
        /*
            configures either mobile native or browser AndroidDriver
         */
        if(browserName!=null) {
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            desiredCapabilities.setCapability("appPackage", appPackage);
            desiredCapabilities.setCapability("appActivity", appActivity);
            desiredCapabilities.setCapability("app", appPath);
        }
        return new AndroidDriver(url, desiredCapabilities);
    }

    /**
     * Setting common implicit wait
     */
    private void configureAndroidDriver() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private URL transformIntoURL(String url) {
        URL result = null;
        try {
            result =  new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if(result == null) {
            throw new RuntimeException("Couldn't initialize URL from this string: " + url);
        }
        return result;
    }
}
