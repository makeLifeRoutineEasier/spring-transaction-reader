import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import transaction_reader.reader.FileReader;
import transaction_reader.reader.FileReaderFactory;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FileReaderFactoryTest {
    private FileReaderFactory fileReaderFactory;
    private FileReader mockFileReader;

    @BeforeEach
    void setUp() {
        Map<String, FileReader> fileReaderRegistry = new HashMap<>();
        mockFileReader = Mockito.mock(FileReader.class);
        fileReaderRegistry.put("json", mockFileReader);
        fileReaderFactory = new FileReaderFactory(fileReaderRegistry);

    }

    @Test
    public void shouldReturnCorrectStrategy_WhenExtensionMatches() {
        FileReader result = fileReaderFactory.getFileReader("json");
        assertThat(result).isSameAs(mockFileReader);

    }

    @Test
    public void shouldThrowException_WhenNoFoundStrategyByExtension() {
        assertThatThrownBy(() -> fileReaderFactory.getFileReader("xlsx"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
