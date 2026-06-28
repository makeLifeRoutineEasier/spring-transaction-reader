package model;

import java.time.LocalDateTime;

public class AnalysedResult {
    private final float revenue;
    private final float expenditure;
    private final LocalDateTime mostProfitablePeriod;
    private final LocalDateTime mostUnprofitablePeriod;

    public AnalysedResult(float revenue, float expenditure, LocalDateTime mostProfitablePeriod, LocalDateTime mostUnprofitablePeriod) {
        this.revenue = revenue;
        this.expenditure = expenditure;
        this.mostProfitablePeriod = mostProfitablePeriod;
        this.mostUnprofitablePeriod = mostUnprofitablePeriod;
    }
}
