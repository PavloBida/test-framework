package android;

import common.BaseSetup;
import org.testng.annotations.Test;

public class AndroidTest extends BaseSetup {

    /**
     * This is just a placeholder test for proof of concept
     */
    @Test
    public void test() {
        getDriver().get("http://google.com");
    }
}
