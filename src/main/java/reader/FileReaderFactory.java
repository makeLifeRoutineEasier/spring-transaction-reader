package reader;


import org.springframework.stereotype.Component;

import java.util.Map;

/*
*Define which concrete strategy need to use
 */
@Component
public class FileReaderFactory {
    private final Map<String, FileReader> fileReaderRegistry;

    public FileReaderFactory(Map<String, FileReader> fileReaderRegistry) {
        this.fileReaderRegistry = fileReaderRegistry;
    }

    public FileReader getFileReader(String extension) {
        FileReader fileReader = fileReaderRegistry.get(extension.toLowerCase());
        if (fileReader == null) {
            throw new IllegalArgumentException("Unsupported file extension: " + extension);
        }
        return fileReader;
    }
}

