package transaction_reader.runner;

import transaction_reader.model.AnalysedResult;
import transaction_reader.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;
import transaction_reader.reader.FileReader;
import transaction_reader.reader.FileReaderFactory;
import transaction_reader.validation.FileChecker;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;

@Component
public class FileReaderRunner implements CommandLineRunner {

    private final FileReaderFactory fileReaderFactory;
    private static final Logger log = LoggerFactory.getLogger(FileReaderRunner.class);

    public FileReaderRunner(FileReaderFactory fileReaderFactory) {
        this.fileReaderFactory = fileReaderFactory;
    }

    //example for current files
    @Override
    public void run(String ... args) throws Exception {

        File input1 = new File("src/main/resources/transactions_example.json");
        readFile(input1);
        File input2 = new File("src/main/resources/transactions_example.csv");
        readFile(input2);
        File input3 = new File("src/main/resources/transactions_example.xml");
        readFile(input3);
    }

    private void readFile(File file) throws Exception {

        String fileExtension = FileChecker.getExtension(file.getName());
        log.info("Reading file with {} extension", fileExtension);

        if (!FileChecker.checkExtension(file)) {
            throw new IllegalArgumentException("No support file extension for \"" + file.getName() + "\"");
        }

        FileReader reader = fileReaderFactory.getFileReader(fileExtension);
        if (reader == null){
            throw new IllegalStateException("Reader is not defined. Check reader factory and file extension");
        }

        LinkedHashSet<Transaction> parsedResult = reader.readFile(file);
        log.info("Successfully read {} transactions from file: {}", parsedResult.size(), file.getName());

        AnalysedResult result = new AnalysedResult(parsedResult);

        for (Transaction t : parsedResult) {

            String dateStr = t.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            //show result about transactions
            log.info("\nTransaction\nTransaction type: {}\nAmount: {}\nAccount: {}\nCategory: {}\nDate: {}\n",
                    t.getType().getName(), t.getAmount(), t.getAccount(), t.getCategory(), dateStr);
        }

        //show computed result about transactions
        log.info("\nAnalysed result:\nRevenue: {}\nExpenditure: {}\n",
                result.getRevenue(), result.getExpenditure());
    }
}

