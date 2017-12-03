package util;

import common.LogFactory;
import org.slf4j.Logger;

import java.io.IOException;

public class BashUtil {

    private static final Logger LOG = LogFactory.getLogger(BashUtil.class);

    public static final void exevuteShell(String command, String argument) {
        try {
            LOG.info("Executing script: " + command + " " + argument);
            Process p = new ProcessBuilder(command, argument).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
