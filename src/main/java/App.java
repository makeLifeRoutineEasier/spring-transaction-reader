import model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reader.FileReader;
import reader.Filter;
import reader.JsonReader;

import java.io.File;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        Logger logger = LoggerFactory.getLogger(App.class);
        File input = new File("src/test/with_BOM_and_symbols.json");
        File filtered = Filter.filterFile(input);

        FileReader reader = new JsonReader();

        List<Transaction> parsedResult = reader.convertFile(input);
        for (Transaction t : parsedResult){
            logger.info("""
                    --------------------------
                    Transaction type: %s
                    Amount: %f
                    Account: %s
                    Category: %s
                    """.formatted(t.getType().getName(), t.getAmount(), t.getAccount(), t.getCategory()));

        }
    }
}
