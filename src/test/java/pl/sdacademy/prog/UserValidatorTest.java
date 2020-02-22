package pl.sdacademy.prog;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.sdacademy.prog.streams.SdaException;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitExtension) - junit4
class UserValidatorTest {

  @Mock
  private AgeValidator ageValidator;

  @Mock//(lenient = true)
  private EmailValidator emailValidator;

  @InjectMocks
  private UserValidator userValidator;// = new UserValidator(ageValidator, emailValidator);

  @Test
  void shouldValidateUser() {
    final Long age = 16L;
    final String email = "notRealEmail";
    final User user = new User(1L, "Andrzej", age, email);
    when(ageValidator.isAgeValid(age)).thenReturn(true);
    when(emailValidator.isEmailValid(email)).thenReturn(true);
    //when(emailValidator.isEmailValid("asdweqewq")).thenReturn(true);

    userValidator.validateUser(user);

    //then
//    verify(ageValidator).isAgeValid(age);
//    verify(emailValidator).isEmailValid(email);
  }

  @Test
  void shouldThrowExceptionWhenAgeIsInvalid() {
    final Long age = 16L;
    final String email = "notRealEmail";
    final User user = new User(1L, "Andrzej", age, email);
    when(ageValidator.isAgeValid(age)).thenReturn(false);

    assertThatExceptionOfType(SdaException.class)
        .isThrownBy(() -> userValidator.validateUser(user))
        .withMessage("Age is invalid")
        .withNoCause();
        //.withCause(null);
  }

  @Test
  void shouldThrowExceptionWhenEmailIsInvalid() {
    final Long age = 16L;
    final String email = "notRealEmail";
    final User user = new User(1L, "Andrzej", age, email);
    when(ageValidator.isAgeValid(age)).thenReturn(true);
    when(emailValidator.isEmailValid(email)).thenReturn(false);

    assertThatThrownBy(() -> userValidator.validateUser(user))
        .hasMessageContaining("Email")
        .hasNoCause();
  }
}