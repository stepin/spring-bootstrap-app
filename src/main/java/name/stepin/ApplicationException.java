package name.stepin;

public class ApplicationException extends RuntimeException {

  public ApplicationException(String message) {
    super(message);
  }

  public ApplicationException(Throwable cause) {
    super(cause);
  }

}
