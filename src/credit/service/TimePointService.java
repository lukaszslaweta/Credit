package credit.service;

import credit.model.InputData;
import credit.model.TimePoint;

import java.math.BigDecimal;

public interface TimePointService {

    TimePoint calculate(BigDecimal rateNumber, InputData inputData);
}
