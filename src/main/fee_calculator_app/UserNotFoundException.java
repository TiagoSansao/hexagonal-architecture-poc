package fee_calculator_app;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}
