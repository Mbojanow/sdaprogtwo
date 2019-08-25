package pl.sdacademy.prog.genB;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;

class NumbersUtilTest {

  @Test
  void shouldFindMedianWhenEvenNumbersInInput() {
    final Collection<Integer> values = Arrays.asList(1, 2, 5, 5);
    final Double expectedMedian = 3.5;

    final Double actualMedian = NumbersUtil.findMedian(values);

    assertThat(actualMedian).isEqualTo(expectedMedian);
    //assertEquals(2.5 - 3.8, -1.3, 0.01);
  }

  @Test
  void shouldThrowExceptionWhenInputCollectionIsEmpty() {
    final Collection<Integer> values = Collections.emptyList();

    final RuntimeException exception = assertThrows(RuntimeException.class,
        () -> NumbersUtil.findMedian(values));

    assertThat(exception.getMessage())
        .isEqualTo("Cannot calculate median from no values");
    //assertThatExceptionOfType()
  }

  @Test // wersja z JUNIT5
  void shouldThrowExceptionWhenInputCollectionContainsInvalidValue() {
    final Collection<Integer> values = Collections.singletonList(1001);

    final RuntimeException exception = assertThrows(RuntimeException.class,
        () -> NumbersUtil.findMedian(values));

    assertThat(exception.getMessage())
        .isEqualTo("At least one incorrect value detected");
  }

  @Test // wersja z assertJ
  void shouldThrowExceptionWhenInputCollectionContainsInvalidValueV2() {
    final Collection<Integer> values = Collections.singletonList(1001);

    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> NumbersUtil.findMedian(values))
    .withMessage("At least one incorrect value detected");
  }

  @Test
  void testA() {
    final List<Number> input = Arrays.asList(1, 2.2, 3L);
    final Double exepectedMedian = 2.2;

    final Double medianGeneric = NumbersUtil.findMedianGeneric(input);

    assertThat(medianGeneric).isEqualTo(exepectedMedian);
  }

  @Test
  void testB() {
    final List<Number> input = Arrays.asList(1, 3L);
    final Double exepectedMedian = 2.0;

    final Double medianGeneric = NumbersUtil.findMedianGeneric(input);

    assertThat(medianGeneric).isEqualTo(exepectedMedian);
  }

  //@Parameters({1,2,3,4})
  @ParameterizedTest
  @MethodSource("getMedianParams")
  void shouldCalculateMedianFromGeneric(final List<Number> input, final Double expected) {
    final Double medianGeneric = NumbersUtil.findMedianGeneric(input);

    assertThat(medianGeneric).isEqualTo(expected);
  }

  public static Stream<Arguments> getMedianParams() {
    return Stream.of(
        Arguments.of(Arrays.asList(1, 2.2, 3L), 2.2),
        Arguments.of(Arrays.asList(1, 3L), 2.0)
    );
  }
}