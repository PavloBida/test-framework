package enums;

/**
 * Created by Pavlo Bida in 2017
 * https://github.com/PavloBida
 */

public enum OSEnum {

    WINDOWS_86("src\\main\\resources\\drivers\\windows\\x86\\geckodriver.exe", "src\\main\\resources\\drivers\\windows\\x86\\chromedriver.exe"),
    WINDOWS_64("src\\main\\resources\\drivers\\windows\\x64\\geckodriver.exe", "src\\main\\resources\\drivers\\windows\\x86\\chromedriver.exe"),
    LINUX_86("src/main/resources/drivers/linux/x86/geckodriver", "src/main/resources/drivers/linux/x86/chromedriver"),
    LINUX_64("src/main/resources/drivers/linux/x64/geckodriver", "src/main/resources/drivers/linux/x64/chromedriver"),
    MACOS("src/main/resources/drivers/macos/geckodriver", "src/main/resources/drivers/macos/chromedriver");

    private String geckoDriverPath;
    private String chromeDriverPath;

    OSEnum(String geckoDriverPath, String chromeDriverPath) {
        this.geckoDriverPath = geckoDriverPath;
        this.chromeDriverPath = chromeDriverPath;
    }

    public String getGeckoDriverPath() {
        return geckoDriverPath;
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }
}
