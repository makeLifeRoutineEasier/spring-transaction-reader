package reader;

import model.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

/*
*Strategy pattern is used to manage different file extensions
 */
public interface FileReader {
    public LinkedHashSet<Transaction> readFile(File file) throws IOException;
}
