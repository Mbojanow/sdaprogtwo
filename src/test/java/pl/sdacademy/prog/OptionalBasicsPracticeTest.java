package pl.sdacademy.prog;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class OptionalBasicsPracticeTest {

  private final OptionalBasicsPractice optionalBasicsPractice = new OptionalBasicsPractice();

  @Test
  void shouldGet() {
    final Optional<Integer> firstEvenDigit = optionalBasicsPractice.findFirstEvenDigit(12345);

    assertThat(firstEvenDigit).isPresent()
        .hasValue(2);
  }
}