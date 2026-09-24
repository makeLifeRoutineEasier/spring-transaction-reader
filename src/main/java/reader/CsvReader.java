package reader;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import model.Transaction;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

@Component("csv")
public class CsvReader implements FileReader {

    @Override
    public LinkedHashSet<Transaction> readFile(File file) throws IOException {

        LinkedHashSet<Transaction> transactions = new LinkedHashSet<>();

        CsvMapper csvMapper = new CsvMapper();

        CsvSchema csvSchema = csvMapper.schemaFor(Transaction.class).withHeader();

        //MappingIterator with a streaming loop for cleaner and faster approach
        try (MappingIterator<Transaction> it = csvMapper
                .readerFor(Transaction.class)
                .with(csvSchema)
                .readValues(file)) {
            while (it.hasNext()) {
                Transaction transaction = it.next();
                transactions.add(transaction);

            }
        } catch (IOException e) {
            throw new IOException("Failed to parse CSV file:  " + e.getMessage(), e);
        }

        return transactions;
    }
}
