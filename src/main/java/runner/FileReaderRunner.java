package runner;

import model.AnalysedResult;
import model.Transaction;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reader.FileReader;
import reader.FileReaderFactory;
import validation.FileChecker;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;

@Component
public class FileReaderRunner implements CommandLineRunner {

    private final FileReaderFactory fileReaderFactory;

    public FileReaderRunner(FileReaderFactory fileReaderFactory) {
        this.fileReaderFactory = fileReaderFactory;
    }

    //example for current files
    @Override
    public void run(String @NonNull ... args) throws Exception {

        File input1 = new File("src/main/resources/transactions_example.json");
        readFile(input1);
        File input2 = new File("src/main/resources/transactions_example.csv");
        readFile(input2);
        File input3 = new File("src/main/resources/transactions_example.xml");
        readFile(input3);
    }

    private void readFile(File file) throws Exception {

        String fileExtension = FileChecker.getExtension(file.getName());

        if (!FileChecker.checkExtension(file)) {
            throw new IllegalArgumentException("No support file extension for \"" + file.getName() + "\"");
        }

        FileReader reader = fileReaderFactory.getFileReader(fileExtension);

        LinkedHashSet<Transaction> parsedResult = reader.readFile(file);
        AnalysedResult result = new AnalysedResult(parsedResult);

        for (Transaction t : parsedResult) {

            String dateStr = t.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            System.out.printf("""
                    
                    Transaction
                    Transaction type: %s
                    Amount: %f
                    Account: %s
                    Category: %s
                    Date: %s
                    %n""", t.getType().getName(), t.getAmount(), t.getAccount(), t.getCategory(), dateStr);
        }

        System.out.printf("""
                
                Analysed result:
                Revenue: %f
                Expenditure: %f
                 %n""", result.getRevenue(), result.getExpenditure());
    }
}

