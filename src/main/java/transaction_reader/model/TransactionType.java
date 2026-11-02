package transaction_reader.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum TransactionType {
    INBOUND("INBOUND"),
    OUTBAND("OUTBOUND");

    private final String name;

    TransactionType(@JsonProperty("type") @JsonAlias({"transactionType"}) String name) {
        this.name = name;
    }

    @JsonCreator
    public static TransactionType fromString(String value) {
        return switch (value.toLowerCase()) {
            case "inbound", "debit", "incoming" -> INBOUND;
            case "outbound", "credit", "outgoing" -> OUTBAND;
            default -> throw new IllegalArgumentException(String.format("Cannot define transaction type: %s", value));
        };

    }


    public String getName() {
        return name;
    }
}
