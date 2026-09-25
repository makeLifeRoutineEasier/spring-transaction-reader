package test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reader.FileReader;
import reader.FileReaderFactory;
import reader.JsonReader;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {FileReaderFactory.class, JsonReader.class})
public class FileReaderFactoryIntegrationTest {
    @Autowired
    FileReaderFactory fileReaderFactory;

    @Test
    void shouldWireAndResolveCorrectJsonReaderStrategy() {
        FileReader result = fileReaderFactory.getFileReader("json");
        assertThat(result).isInstanceOf(JsonReader.class);
    }
}
