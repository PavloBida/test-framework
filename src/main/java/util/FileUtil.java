package util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static void copyFileToDirectory(File srcFile, File destDir) {
        try {
            FileUtils.copyDirectory(srcFile, destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        File folderToCopy = new File("/Users/pavlo/projects/test-framework/src/main/resources/appium_node_config");
        copyFileToDirectory(folderToCopy, new File("/Users/pavlo/projects/test-framework/src/main/resources/temp/".concat(folderToCopy.getName() + "test123")));
    }
}
