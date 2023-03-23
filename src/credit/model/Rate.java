package credit.model;

import java.math.BigDecimal;

public class Rate {
    private final TimePoint timePoint;
    private final BigDecimal rateNumber;
    private final RateAmounts rateAmounts;
    private final MortgageResidual mortgageResidual;

    public Rate(BigDecimal rateNumber,TimePoint timePoint , RateAmounts rateAmounts, MortgageResidual mortgageResidual) {
        this.rateNumber = rateNumber;
        this.timePoint = timePoint;
        this.rateAmounts = rateAmounts;
        this.mortgageResidual = mortgageResidual;
    }

    public TimePoint getTimePoint() {
        return timePoint;
    }

    public BigDecimal getRatePoint() {
        return rateNumber;
    }

    public RateAmounts getRateAmounts() {
        return rateAmounts;
    }

    public MortgageResidual getMortgageResidual() {
        return mortgageResidual;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "timePoint=" + timePoint +
                '}';
    }
}
