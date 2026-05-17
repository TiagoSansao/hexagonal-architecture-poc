package test.fee_calculator_app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;

import fee_calculator_app.FeeCalculationService;
import fee_calculator_app.UserNotFoundException;
import fee_calculator_app.inbound_ports.ForCalculatingUserTransactionFee;
import fee_calculator_app.outbound_ports.ForGettingUserFeeRate;

public class FeeCalculationServiceTest {

  private final ForGettingUserFeeRate mockedUserFeeRepository = new MockedUserFeeRepository();
  private final ForCalculatingUserTransactionFee feeCalculationService = new FeeCalculationService(
      mockedUserFeeRepository);

  @Test
  public void givenValidUserWhenCalculateFeeThenReturnCalculatedFee() {
    BigDecimal actualFeeValue = feeCalculationService.calculateFee(1L, BigDecimal.valueOf(1000));
    BigDecimal expectedFeeValue = new BigDecimal("10.00");

    assertEquals(actualFeeValue, expectedFeeValue);
  }

  @Test
  public void givenInexistentUserWhenCalculateFeeThenThrowUserNotFoundException() {
    assertThrows(UserNotFoundException.class, () -> {
      feeCalculationService.calculateFee(999L, BigDecimal.valueOf(1000));
    });
  }
}
