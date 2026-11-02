package transaction_reader.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import transaction_reader.model.Transaction;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

@Component("json")
public class JsonReader implements FileReader {

    private final ObjectMapper mapper = new ObjectMapper();

    public JsonReader() {
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public LinkedHashSet<Transaction> readFile(File file) throws IOException {
        return mapper.readValue(file, new TypeReference<>() {
        });
    }
}

