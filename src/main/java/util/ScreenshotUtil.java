package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ScreenshotUtil {

    private WebDriver driver;

    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot() {
        try {
            FileUtils.copyFile(
                    ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),
                    new File(String.format("target/my_screenshot%s.png", LocalDateTime.now().toString())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
