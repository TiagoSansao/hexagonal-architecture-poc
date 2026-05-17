package fee_calculator_app;

import java.math.BigDecimal;

import fee_calculator_app.inbound_ports.ForCalculatingUserTransactionFee;
import fee_calculator_app.outbound_ports.ForGettingUserFeeRate;

public class FeeCalculationService implements ForCalculatingUserTransactionFee {

  private ForGettingUserFeeRate userFeeRateRepository;

  public FeeCalculationService(ForGettingUserFeeRate userFeeRateRepository) {
    this.userFeeRateRepository = userFeeRateRepository;
  }

  @Override
  public BigDecimal calculateFee(Long userId, BigDecimal transactionValue) throws UserNotFoundException {
    BigDecimal userFeeRate = userFeeRateRepository.getUserFeeRate(userId);
    if (userFeeRate == null)
      throw new UserNotFoundException("User %d does not have a negotiated fee rate.".formatted(userId));

    BigDecimal feeValue = transactionValue.multiply(userFeeRate);

    return feeValue;
  }

}