package reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader implements FileReader{

    private final ObjectMapper mapper = new ObjectMapper();

    public JsonReader(){
        mapper.registerModule(new JavaTimeModule());
    }
    @Override
    public List<Transaction> convertFile(File file) throws IOException {
        return mapper.readValue(file, new TypeReference<>() {
        });
    }
}
