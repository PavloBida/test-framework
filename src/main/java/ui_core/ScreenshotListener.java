package ui_core;

import org.testng.*;
import util.ScreenshotUtil;

public class ScreenshotListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        new ScreenshotUtil(WebTestBase.getDriver()).takeScreenshot();
    }
}
