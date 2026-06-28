package reader;

import model.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileReader {
    public List<Transaction> convertFile(File file) throws IOException;
}
