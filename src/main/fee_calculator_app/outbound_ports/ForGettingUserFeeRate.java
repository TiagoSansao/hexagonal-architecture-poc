package fee_calculator_app.outbound_ports;

import java.math.BigDecimal;

public interface ForGettingUserFeeRate {
  public BigDecimal getUserFeeRate(Long userId);
}