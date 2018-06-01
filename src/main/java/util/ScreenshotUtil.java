package util;

import common.LogFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by Pavlo Bida in 2018
 * https://github.com/PavloBida
 */

public class ScreenshotUtil {

    private static final Logger LOG = LogFactory.getLogger(ScreenshotUtil.class);

    private WebDriver driver;

    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot() {
        String screenshotName = String.format("target/my_screenshot%s.png", LocalDateTime.now().toString());
        try {
            FileUtils.copyFile(
                    ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),
                    new File(screenshotName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOG.info("Screenshot has been taken: " + screenshotName);
    }

}
