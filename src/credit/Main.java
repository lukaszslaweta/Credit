package credit;

import credit.model.InputData;
import credit.service.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        InputData inputData = new InputData()
                .witherAmount(new BigDecimal("298000"))
                .witherMounthDuration(BigDecimal.valueOf(160));

        PrintingService printingService = new PrintingServiceImpl();
        RateCalculationService rateCalculationService = new RateCalculationServiceImpl(
                new TimePointServiceImpl(),
                new AmountCalculationServiceImpl(),
                new ResidualCalculationServiceImpl();

        );

        MortgageCalculationService mortgageCalculationService = new MortgageCalculationServiceImpl(
                printingService,
                rateCalculationService
        );
        mortgageCalculationService.calculate(inputData);

    }
}