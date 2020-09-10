package ui_core;

import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteTestBase {

    protected ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<>();

}
