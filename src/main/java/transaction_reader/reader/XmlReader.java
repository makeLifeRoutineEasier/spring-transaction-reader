package transaction_reader.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import transaction_reader.model.Transaction;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

@Component("xml")
public class XmlReader implements FileReader{

    private final XmlMapper xmlMapper = new XmlMapper();
    private XmlReader(){
        xmlMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public LinkedHashSet<Transaction> readFile(File file) throws IOException {
        return xmlMapper.readValue(file, new TypeReference<>() {
        });
    }
}
