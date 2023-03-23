package credit.service;

import credit.model.InputData;
import credit.model.Rate;

import java.util.List;

public class MortgageCalculationServiceImpl implements MortgageCalculationService {

    private final PrintingService printingService;

    private final RateCalculationService rateCalculationService;

    public MortgageCalculationServiceImpl(
            PrintingService printingService,
            RateCalculationService rateCalculationService) {
        this.printingService = printingService;
        this.rateCalculationService = rateCalculationService;
    }

    @Override
    public void calculate(InputData inputData) {
        printingService.printInputDatainfo(inputData);

        List<Rate> calculate = rateCalculationService.calculate(inputData);
    }
}
