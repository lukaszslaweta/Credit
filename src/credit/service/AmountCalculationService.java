package credit.service;

import credit.model.InputData;
import credit.model.Rate;
import credit.model.RateAmounts;

public interface AmountCalculationService {
    RateAmounts calculate(InputData inputData);

    RateAmounts calculate(InputData inputData, Rate previousRate);
}
