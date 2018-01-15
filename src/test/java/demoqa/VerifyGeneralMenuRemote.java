package demoqa;

import common.RemoteDriverFactory;
import common.RemoteTestBase;
import common.WebDriverFactory;
import enums.BrowserEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobject.demoqa.AboutUsPage;
import pageobject.demoqa.HomePage;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.open;

public class VerifyGeneralMenuRemote extends RemoteTestBase{

    private RemoteDriverFactory remoteDriverFactory;
    protected RemoteWebDriver remoteWebDriver;

    HomePage homePage;
    AboutUsPage aboutUsPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(BrowserEnum browser) throws MalformedURLException {
        remoteDriverFactory = new RemoteDriverFactory();
        remoteWebDriver = remoteDriverFactory.getInstance(browser);
        remoteDriver.set(remoteWebDriver);
    }

    @Test
    public void verifyHomePage() {
        driver().get(HomePage.URL);
        driver().findElement(By.cssSelector("#menu-item-158")).click();
        driver().findElement(By.cssSelector("#menu-item-155")).click();
        driver().findElement(By.cssSelector("#menu-item-65")).click();
        driver().findElement(By.cssSelector("#menu-item-64")).click();
        driver().findElement(By.cssSelector("#menu-item-374")).click();
    }

    @AfterClass
    public void tearDown() {
        driver().quit();
    }

    private RemoteWebDriver driver() {
        return remoteDriver.get();
    }

}
