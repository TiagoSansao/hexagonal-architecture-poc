package fee_calculator_app.inbound_ports;

import java.math.BigDecimal;

import fee_calculator_app.UserNotFoundException;

public interface ForCalculatingUserTransactionFee {
  public BigDecimal calculateFee(Long userId, BigDecimal transactionValue)
      throws UserNotFoundException;
}