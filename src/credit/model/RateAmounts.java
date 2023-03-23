package credit.model;

import java.math.BigDecimal;

public class RateAmounts {
    private final BigDecimal rateAmount;
    private final BigDecimal interestAmount;
    private final BigDecimal capilatAmount;

    public RateAmounts(BigDecimal rateAmount, BigDecimal interestAmount, BigDecimal capilatAmount) {
        this.rateAmount = rateAmount;
        this.interestAmount = interestAmount;
        this.capilatAmount = capilatAmount;
    }

    public BigDecimal getRateAmount() {
        return rateAmount;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public BigDecimal getCapilatAmount() {
        return capilatAmount;
    }
}
