package credit.service;

import credit.model.InputData;
import credit.model.Rate;

import java.util.List;

public interface RateCalculationService {
    List<Rate> calculate(final InputData inputData);
}
