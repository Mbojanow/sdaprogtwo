package pl.sdacademy.prog;

import pl.sdacademy.prog.streams.SdaException;

public class UserValidator {
  private final AgeValidator ageValidator;
  private final EmailValidator emailValidator;

  public UserValidator(final AgeValidator ageValidator, final EmailValidator emailValidator) {
    this.ageValidator = ageValidator;
    this.emailValidator = emailValidator;
  }

  public void validateUser(final User user) {
    if (!ageValidator.isAgeValid(user.getAge())) {
      throw new SdaException("Age is invalid");
    }

    if (!emailValidator.isEmailValid(user.getEmail())) {
      throw new SdaException("Email is invalid");
    }
  }
}
