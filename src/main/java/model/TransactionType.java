package model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionType {
    @JsonProperty("type") @JsonAlias({"transactionType"})
    private final String name;
    @JsonCreator
    public TransactionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
