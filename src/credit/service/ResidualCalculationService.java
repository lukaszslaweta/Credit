package credit.service;

import credit.model.InputData;
import credit.model.MortgageResidual;
import credit.model.Rate;
import credit.model.RateAmounts;

public interface ResidualCalculationService {
    MortgageResidual calculate(RateAmounts rateAmounts, InputData inputData);

    MortgageResidual calculate(RateAmounts rateAmounts, Rate previousRate);

}
