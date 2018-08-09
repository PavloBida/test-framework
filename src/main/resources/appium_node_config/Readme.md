### Here's a way to execute tests on two Appium sessions simultaneously
##### 1. Download Selenium Standalone Server from [Selenium Website](https://www.seleniumhq.org/download/) or you can get the one from [current project](https://github.com/PavloBida/test-framework/blob/master/src/main/resources/selenium-server-standalone-3.13.0.jar).
##### 2. Start Selenium Hub like this:
```
java -jar selenium-server-standalone-3.13.0.jar -role hub -port 4445
```
- Be sure to specify correct server version in accordance with one you've just downloaded
- Note that the Selenium Hub port is 4445, not the default one (you can change it if you need to, but then you need to change it in node_1 and node_2 configs as well)
##### 3. Start two emulators on your local machine or connect two devices.
##### 4. Start two Appium instances using configs in current package:
Like this:
```
- appium --nodeconfig ~/projects/test-framework/src/main/resources/appium_node_config/node_1 --chromedriver-executable ~/projects/test-framework/src/main/resources/drivers/android/chrome_55/chromedriver -p 4723 --suppress-adb-kill-server --bootstrap-port 4823 --chromedriver-port 4923 -U emulator-5556
```
```
- appium --nodeconfig ~/projects/test-framework/src/main/resources/appium_node_config/node_2 --chromedriver-executable ~/projects/test-framework/src/main/resources/drivers/android/chrome_55/chromedriver -p 4724 --suppress-adb-kill-server --bootstrap-port 4824 --chromedriver-port 4924 -U emulator-5554
```
- Be sure to specify correct path to node_1 and node_2 files.
- Be sure to review node_1 and node_2 configs and edit them in accordance with your environment.
- Be sure to specify correct devices that are currently available on your local pc. You can find them out with: 'adb devices' command.
- Be sure that the version of Selenium Standalone Server you've downloaded corresponds the Selenium Java Client version in your pom.xml/build.gradle.
##### 5. That's it. You can execute tests on multiple Android devices at a time.
For an example, please take a look [here](https://github.com/PavloBida/test-framework/blob/master/src/test/resources/android_multithread.xml)
