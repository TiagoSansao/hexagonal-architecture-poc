import java.math.BigDecimal;

import fee_calculator_app.FeeCalculationService;
import fee_calculator_app.PersistedUserFeeRepository;
import fee_calculator_app.inbound_ports.ForCalculatingUserTransactionFee;
import fee_calculator_app.outbound_ports.ForGettingUserFeeRate;

public class Main {
  public static void main(String[] args) {
    ForGettingUserFeeRate persistedUserFeeRepository = new PersistedUserFeeRepository();
    ForCalculatingUserTransactionFee feeCalculationService = new FeeCalculationService(persistedUserFeeRepository);

    BigDecimal calculatedFee = feeCalculationService.calculateFee(1L, new BigDecimal(2000)); // Should be 40
    System.out.println("The calculated fee was: %s".formatted(calculatedFee));
  }
}