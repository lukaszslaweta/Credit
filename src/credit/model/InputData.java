package credit.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class InputData {
    private static final BigDecimal PERCENT = BigDecimal.valueOf(100);
    private LocalDate repaymentStartDate = LocalDate.of(2022,1,6);
    private BigDecimal wiborPercent = new BigDecimal("1.80");
    private BigDecimal amount = new BigDecimal("300000");
    private BigDecimal mounthDuration = BigDecimal.valueOf(180);
    private RateType rateType = RateType.CONSTANT;
    private BigDecimal bankMarginPercent = new BigDecimal("1.9");



    public InputData witherRepaymentStartDate(LocalDate repaymentStartDate){
        this.repaymentStartDate = repaymentStartDate;
        return this;
    }
    public InputData witherWiborPercent(BigDecimal wiborPercent){
        this.wiborPercent = wiborPercent;
        return this;
    }
    public InputData witherAmount(BigDecimal amount){
        this.amount = amount;
        return this;
    }
    public InputData witherMounthDuration(BigDecimal mounthDuration){
        this.mounthDuration = mounthDuration;
        return this;
    }
    public InputData witherRateType(RateType rateType){
        this.rateType = rateType;
        return this;
    }
    public InputData witherBankMarginPercent(BigDecimal bankMarginPercent){
        this.bankMarginPercent = bankMarginPercent;
        return this;
    }


    public LocalDate getRepaymentStartDate() {
        return repaymentStartDate;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getMonthsDuration() {
        return mounthDuration;
    }

    public RateType getRateType() {
        return rateType;
    }
    public BigDecimal getInterestPercent() {
        return wiborPercent.add(bankMarginPercent).divide(PERCENT,2, RoundingMode.HALF_UP);
    }
    public BigDecimal getInterestDisplay() {
        return wiborPercent.add(bankMarginPercent).setScale(2,RoundingMode.HALF_UP);
    }
}
