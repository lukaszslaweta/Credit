package credit.service;

import credit.model.InputData;
import credit.model.MortgageResidual;
import credit.model.Rate;
import credit.model.RateAmounts;

public class ResidualCalculationServiceImpl implements ResidualCalculationService {
    @Override
    public MortgageResidual calculate(RateAmounts rateAmounts, InputData inputData) {
        return null;
    }

    @Override
    public MortgageResidual calculate(RateAmounts rateAmounts, Rate previousRate) {
        return null;
    }
}
