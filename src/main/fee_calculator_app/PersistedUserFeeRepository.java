package fee_calculator_app;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fee_calculator_app.outbound_ports.ForGettingUserFeeRate;

public class PersistedUserFeeRepository implements ForGettingUserFeeRate {

  @Override
  public BigDecimal getUserFeeRate(Long userId) {
    ObjectMapper mapper = new ObjectMapper();

    try {
      InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("persistedUserFeeRateMap.json");

      Map<Long, BigDecimal> userFeeRateMap = mapper.readValue(inputStream, new TypeReference<Map<Long, BigDecimal>>() {
      });

      return userFeeRateMap.get(userId);
    } catch (Exception exception) {
      System.err.println("An error happened while trying to read the user fee rate map json file.");
      System.err.println(exception);

      return null;
    }
  }

}
