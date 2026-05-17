package test.fee_calculator_app;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import fee_calculator_app.outbound_ports.ForGettingUserFeeRate;

class MockedUserFeeRepository implements ForGettingUserFeeRate {

  @Override
  public BigDecimal getUserFeeRate(Long userId) {
    Map<Long, BigDecimal> userFeeRateMap = new HashMap<Long, BigDecimal>();
    userFeeRateMap.put(0L, BigDecimal.valueOf(0.005));
    userFeeRateMap.put(1L, BigDecimal.valueOf(0.01));
    userFeeRateMap.put(2L, BigDecimal.valueOf(0.02));
    userFeeRateMap.put(3L, BigDecimal.valueOf(0.03));

    BigDecimal userFeeRate = (BigDecimal) userFeeRateMap.get(userId);

    return userFeeRate;
  }

}
