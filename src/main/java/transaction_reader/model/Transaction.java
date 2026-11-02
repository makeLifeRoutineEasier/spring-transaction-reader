package transaction_reader.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    private final TransactionType type;

    private final float amount;

    private final LocalDateTime dateTime;

    private final String account;

    private final String category;

    @JsonCreator
    public Transaction(@JsonProperty("type") @JsonAlias({"transactionType"}) TransactionType type,
                       @JsonProperty("amount") @JsonAlias({"sum", "total"}) float amount,
                       @JsonProperty("date") @JsonAlias({"time"}) LocalDateTime dateTime,
                       @JsonProperty("account") @JsonAlias({"accountNumber"}) String account,
                       @JsonProperty("category") @JsonAlias({"transactionCategory", "group"}) String category) {
        this.type = type;
        this.amount = amount;
        this.dateTime = dateTime;
        this.account = account;
        this.category = category;
    }

    public TransactionType getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getAccount() {
        return account;
    }

    public String getCategory() {
        return category;
    }
}
