package reader;

import model.Transaction;

import java.io.File;
import java.util.List;

public class CsvReader implements FileReader {
    @Override
    public List<Transaction> convertFile(File file) {
        return List.of();
    }
}
