package transaction_reader.model;

import java.util.Collection;

public class AnalysedResult {
    private final float revenue;
    private final float expenditure;

    public AnalysedResult(Collection<Transaction> transactions) {
        this.revenue = (float) transactions.stream()
                .filter(t -> t.getType().getName().equalsIgnoreCase("inbound"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        this.expenditure = (float) transactions.stream()
                .filter(t -> t.getType().getName().equalsIgnoreCase("outbound"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public float getRevenue() {
        return revenue;
    }

    public float getExpenditure() {
        return expenditure;
    }

}

