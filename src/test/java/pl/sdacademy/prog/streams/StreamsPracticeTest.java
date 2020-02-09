package pl.sdacademy.prog.streams;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamsPracticeTest {

  private StreamsPractice streamsPractice = new StreamsPractice();

  //mergeToSingleList
  // shouldDOSTHWhenCONDITIONS
  @Test
  void shouldMergeToSingleListWhenMultipleElementsAreAvailable() {
    final Dummy dummyA = Dummy.builder()
        .ints(List.of(1, 2, 3))
        .build();
    final Dummy dummyB = Dummy.builder()
        .ints(List.of(2, 7, 5))
        .build();

    final List<Integer> actualInts = streamsPractice.mergeToSingleList(List.of(dummyA, dummyB));

    Assertions.assertThat(actualInts).containsExactly(1, 2, 3, 2, 7, 5);
  }

  @Test
  void shouldSumElementsOnlyForListsWithEvenArgument() {
    final Dummy dummyA = Dummy.builder()
        .ints(List.of(1, 2, 3))
        .build();
    final Dummy dummyB = Dummy.builder()
        .ints(List.of(2, 7, 5))
        .build();
    final Dummy dummyC = Dummy.builder()
        .ints(List.of(1, 3, 5))
        .build();

    final Map<List<Integer>, Integer> listToItsSums =
        streamsPractice.sumElementsWithAtLeastOneSingleEven(List.of(dummyA, dummyB, dummyC));

    assertThat(listToItsSums).containsExactlyInAnyOrderEntriesOf(Map.of(
       List.of(1, 2, 3), 6, List.of(2, 7, 5), 14
    ));
  }

}