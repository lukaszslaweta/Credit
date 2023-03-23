package credit.service;

import credit.model.InputData;
import credit.model.Rate;
import credit.model.RateAmounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AmountCalculationServiceImpl implements AmountCalculationService{

    private static final BigDecimal YEAR = BigDecimal.valueOf(12);
    @Override
    public RateAmounts calculate(InputData inputData) {
        switch (inputData.getRateType()){
            case CONSTANT:
                return calculateConstantRate(inputData);
            case DECREASING:
                return calculateDecreasingRate(inputData);
            default:
                throw new RuntimeException("Case not handled");
        }
    }

    @Override
    public RateAmounts calculate(InputData inputData, Rate previousRate) {
        switch (inputData.getRateType()){
            case CONSTANT:
                return calculateConstantRate(inputData,previousRate);
            case DECREASING:
                return calculateDecreasingRate(inputData,previousRate);
            default:
                throw new RuntimeException("Case not handled");
        }
    }

    private RateAmounts calculateConstantRate(InputData inputData) {
        BigDecimal residualAmount = inputData.getAmount();
        BigDecimal interestPercent = inputData.getInterestPercent();

        BigDecimal q = calculateQ(inputData.getInterestPercent());

        BigDecimal rateAmount =calculateConstantRateAmount(q, inputData.getAmount(), inputData.getMonthsDuration());
        BigDecimal interestAmount = calculateInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateConstantCapitalAmount(rateAmount,interestAmount);

        return new RateAmounts(rateAmount, interestAmount, capitalAmount);
    }

    private RateAmounts calculateConstantRate(InputData inputData, Rate previousRate) {
        BigDecimal residualAmount = previousRate.getMortgageResidual().getAmount();
        BigDecimal interestPercent = inputData.getInterestPercent();

        BigDecimal q = calculateQ(inputData.getInterestPercent());

        BigDecimal rateAmount =calculateConstantRateAmount(q, inputData.getAmount(), inputData.getMonthsDuration());
        BigDecimal interestAmount = calculateInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateConstantCapitalAmount(rateAmount,interestAmount);

        return new RateAmounts(rateAmount, interestAmount, capitalAmount);
    }
    private RateAmounts calculateDecreasingRate(InputData inputData) {
        BigDecimal residualAmount = inputData.getAmount();
        BigDecimal interestPercent = inputData.getInterestPercent();

        BigDecimal interestAmount = calculateInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateDeacreasingCapitalAmount(residualAmount, inputData.getMonthsDuration());
        BigDecimal rateAmount =capitalAmount.add(interestAmount);

        return new RateAmounts(rateAmount, interestAmount, capitalAmount);
    }

    private RateAmounts calculateDecreasingRate(InputData inputData, Rate previousRate) {
        BigDecimal residualAmount = previousRate.getMortgageResidual().getAmount();
        BigDecimal interestPercent = inputData.getInterestPercent();

        BigDecimal interestAmount = calculateInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateDeacreasingCapitalAmount(residualAmount, inputData.getMonthsDuration()));
        BigDecimal rateAmount =capitalAmount.add(interestAmount);

        return new RateAmounts(rateAmount, interestAmount, capitalAmount);
    }

    private BigDecimal calculateQ(BigDecimal interestPercent) {
        return interestPercent.divide(YEAR,10, RoundingMode.HALF_UP).add(BigDecimal.ONE);
    }

    private BigDecimal calculateConstantRateAmount(BigDecimal q, BigDecimal amount, BigDecimal monthsDuration) {
        return amount
                .multiply(q.pow(monthsDuration.intValue()))
                .multiply(q.subtract(BigDecimal.ONE))
                .divide(q.pow(monthsDuration.intValue()).subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);

    }

    private BigDecimal calculateConstantCapitalAmount(BigDecimal rateAmount, BigDecimal interestAmount) {
        return rateAmount.subtract(interestAmount);
    }
    private BigDecimal calculateInterestAmount(BigDecimal residualAmount, BigDecimal interestPercent) {
        return residualAmount.multiply(interestPercent).divide(YEAR, 2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateDeacreasingCapitalAmount(BigDecimal amount, BigDecimal monthsDuration) {
        return amount.divide(monthsDuration, 2, RoundingMode.HALF_UP);
    }



}
