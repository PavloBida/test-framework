package common;

import enums.BrowserEnum;
import enums.OSEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by Pavlo Bida in 2017
 * https://github.com/PavloBida
 */

public class WebDriverFactory {

    private static final Logger LOG = LogFactory.getLogger(WebDriverFactory.class);

    private WebDriver webDriver;
    private BrowserEnum browserEnum;
    private DesiredCapabilities desiredCapabilities;

    /**
     * Initializes class for the specified browser
     * @param browserEnum   desired browser
     */
    public WebDriverFactory(BrowserEnum browserEnum) {
        this.browserEnum = browserEnum;
        this.webDriver = initWebDriver();
    }

    /**
     * Initializes class for the specified browser, with specified capabilities
     * @param browserEnum           desired broeser
     * @param desiredCapabilities   desired capabilities
     */
    public WebDriverFactory(BrowserEnum browserEnum, DesiredCapabilities desiredCapabilities) {
        this.browserEnum = browserEnum;
        this.desiredCapabilities = desiredCapabilities;
        this.webDriver = initWebDriver();
    }

    /**
     * @return  A WebDriver instance
     */
    public WebDriver getWebdriver() {
        return this.webDriver;
    }

    /**
     * Initializes a WebDriver instance for desired browser and capabilities.
     * Capabilities are set in a client class before instantiating this class and passed through the constructor.
     * @return  WebDriver instance
     */
    public WebDriver initWebDriver() {
        if(browserEnum != null) {
            if(browserEnum.equals(BrowserEnum.FIREFOX)) {
                System.setProperty("webdriver.gecko.driver", getOS().getGeckoDriverPath());
                if(desiredCapabilities != null) {
                    webDriver = new FirefoxDriver(desiredCapabilities);
                } else {
                    webDriver = new FirefoxDriver();
                }
            } else if (browserEnum.equals(BrowserEnum.CHROME)) {
                System.setProperty("webdriver.chrome.driver", getOS().getChromeDriverPath());
                if(desiredCapabilities != null) {
                    webDriver = new ChromeDriver(desiredCapabilities);
                } else {
                    webDriver = new ChromeDriver();
                }
            }
        } else {
            throw new IllegalArgumentException("No browser provided");
        }
        manageTimeouts();
        LOG.info("Initializing webdriver for browser: " + browserEnum + ", OS: " + getOS());
        return webDriver;
    }

    /**
     * Defines operating system and returns the corresponding enum.
     * @return OSEnum           current operating system enum
     * @throws RuntimeException in case os.name property doesn't match any of the specified
     */
    private static OSEnum getOS() throws RuntimeException {
        String osName = System.getProperty("os.name");
        String osArch = System.getProperty("os.arch");

        if (osName.toLowerCase().contains("windows")) {
            if(osArch.contains("86")) {
                return OSEnum.WINDOWS_86;
            } else {
                return OSEnum.WINDOWS_64;
            }
        } else if (osName.toLowerCase().contains("nux") || osName.toLowerCase().contains("nix")) {
            if(osArch.contains("86")) {
                return OSEnum.LINUX_86;
            } else {
                return OSEnum.LINUX_64;
            }
        } else if (osName.toLowerCase().contains("mac")) {
            return OSEnum.MACOS;
        } else {
            throw new RuntimeException("Unable to define operating system");
        }
    }

    /**
     * Sets default implicit wait timeout
     */
    private void manageTimeouts() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void setProperties() {
        System.setProperty("webdriver.gecko.driver", getOS().getGeckoDriverPath());
        System.setProperty("webdriver.chrome.driver", getOS().getChromeDriverPath());
    }

}
