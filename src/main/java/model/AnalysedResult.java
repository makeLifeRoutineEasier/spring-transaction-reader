package model;

import java.util.Collection;

public class AnalysedResult {
    private final float revenue;
    private final float expenditure;

    public AnalysedResult(Collection<Transaction> transactions) {
        this.revenue = (float) transactions.stream()
                .filter(t -> t.getType().getName().equals("INBOUND"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        this.expenditure = (float) transactions.stream()
                .filter(t -> t.getType().getName().equals("OUTBOUND"))
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

