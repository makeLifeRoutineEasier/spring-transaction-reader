package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import model.FileConfig;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private static final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
    private static final String filePath = "src/config/AvailableExtensions.yaml";

    public static FileConfig loadConfig() throws IOException {
        try {
            File rawFileConfig = new File(filePath);
            return yamlMapper.readValue(rawFileConfig, FileConfig.class);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
