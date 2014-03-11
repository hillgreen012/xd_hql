import java.util.ArrayList;

/**
 * ParseException.
 *
 */
public class ParseException extends Exception {

  private static final long serialVersionUID = 1L;
  ArrayList<ParseError> errors;

  public ParseException(ArrayList<ParseError> errors) {
    super();
    this.errors = errors;
  }

  @Override
  public String getMessage() {

    StringBuilder sb = new StringBuilder();
    for (ParseError err : errors) {
      sb.append(err.getMessage());
      sb.append("\n");
    }

    return sb.toString();
  }

}
