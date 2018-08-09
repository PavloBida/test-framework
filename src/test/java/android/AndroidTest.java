package android;

import org.testng.annotations.Test;

public class AndroidTest extends AndroidWebBase {

    /**
     * This is just a placeholder test for proof of concept
     */
    @Test
    public void test() {
        getDriver().get("http://google.com");
    }
}
