package pl.sdacademy.prog;

public class EmailValidator {

  public boolean isEmailValid(final String email) {
    return email.contains("@") && email.split("@").length == 2;
  }
}
