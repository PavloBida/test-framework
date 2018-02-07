# Test Framework
#### A set of most efficient tools that represent modern test framework implementation
####Main features:
- [WebDriverFactory](https://github.com/PavloBida/test-framework/blob/master/src/main/java/common/WebDriverFactory.java) - automatically defines the OS, and instantiates a WebDriver for the browser, specified in testng.xml file, which the tests are being executed from.
- [AndroidDriverFactory](https://github.com/PavloBida/test-framework/blob/master/src/main/java/common/AndroidDriverFactory.java) - instantiates AndroidDriver. basing on the arguments, passed into the constructor.
- [RemoteDriverFactory](https://github.com/PavloBida/test-framework/blob/master/src/main/java/common/RemoteDriverFactory.java) - instantiates RemoteWebDriver for running tests in Selenium Grid.