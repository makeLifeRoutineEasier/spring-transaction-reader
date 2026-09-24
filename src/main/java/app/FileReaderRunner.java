package app;

import handler.Filtering;
import model.AnalysedResult;
import model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import reader.FileReader;
import reader.FileReaderFactory;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.validation.FileInitializer;

public class FileReaderRunner implements CommandLineRunner {

    private final FileReaderFactory fileReaderFactory;
    private final Logger log = LoggerFactory.getLogger(FileReaderRunner.class);

    private FileReaderRunner(FileReaderFactory fileReaderFactory) {
        this.fileReaderFactory = fileReaderFactory;
    }

    //example for current files
    @Override
    public void run(String... args) throws Exception {

        File input1 = new File("src/test/transactions_example.json");
        readFile(input1);
        File input2 = new File("src/test/transactions_example.json");
        readFile(input2);
        File input3 = new File("src/test/transactions_example.json");
        readFile(input3);
    }

    private void readFile(File file) throws Exception {
        File filtered = Filtering.filterFile(file);

        FileReader reader = fileReaderFactory.getFileReader(FileInitializer.getExtension(filtered.getName()));

        LinkedHashSet<Transaction> parsedResult = reader.readFile(filtered);
        AnalysedResult result = new AnalysedResult(parsedResult);

        LocalDateTime now = LocalDateTime.now();

        for (Transaction t : parsedResult) {

            String dateStr = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            log.info("""
                     \s
                     Transaction
                     Transaction type: %s
                     Amount: %f
                     Account: %s
                     Category: %s
                     Date: %s
                    \s""".formatted(t.getType().getName(), t.getAmount(), t.getAccount(), t.getCategory(), dateStr));
        }

        log.info("""
                \s
                Analysed result:
                Revenue: %f
                Expenditure: %f
                \s""".formatted(result.getRevenue(), result.getExpenditure()));
    }
}

