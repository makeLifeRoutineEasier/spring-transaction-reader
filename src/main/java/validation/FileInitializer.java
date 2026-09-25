package validation;

import config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class FileInitializer {

    private static final Logger logger = LoggerFactory.getLogger(FileInitializer.class);

    public static boolean checkExtension(File file) throws IOException {
        logger.info("Checking extension for file: {}", file.getAbsolutePath());

        String fileName = file.getName();
        String extension = getExtension(fileName);
        logger.debug("Extracted extension: {}", extension);

        Set<String> availableExtensions = ConfigManager.loadConfig().getAvailableExtensions();
        logger.info("Available extensions: {}", availableExtensions);
        boolean isAvailable = availableExtensions.contains(extension);

        if (isAvailable) {
            logger.info("Extension '{}' is valid for file: {}", extension, fileName);
        } else {
            logger.warn("Extension '{}' is NOT allowed for file: {}", extension, fileName);
        }

        return isAvailable;
    }

    public static String getExtension(String fileName){
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}

