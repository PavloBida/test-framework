package demoqa;

import common.LogFactory;
import common.TestBase;
import org.slf4j.Logger;
import org.testng.annotations.Test;

public class VerifyHomePage extends TestBase {

    private static final Logger LOG = LogFactory.getLogger(VerifyHomePage.class);

    @Test
    public void verifyHomePage() {

        LOG.info("The test has started.");

    }

}
