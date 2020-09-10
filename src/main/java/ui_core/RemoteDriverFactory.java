package ui_core;

import enums.BrowserEnum;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverFactory {

    public RemoteWebDriver getInstance(BrowserEnum browser) throws MalformedURLException {
        DesiredCapabilities capabilities;

        if (browser.equals(BrowserEnum.CHROME)) {
            capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
        } else if (browser.equals(BrowserEnum.FIREFOX)) {
            capabilities = DesiredCapabilities.firefox();
            capabilities.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
        } else throw new RuntimeException("invalid browser setup");
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }
}
