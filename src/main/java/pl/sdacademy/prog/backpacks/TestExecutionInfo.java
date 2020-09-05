package pl.sdacademy.prog.backpacks;

import lombok.Data;

@Data // -> składa się: @Getter, @Setter, @EqualsAndHashCode, @RequiredArgsConstructor
public class TestExecutionInfo {
  private final String name;
  private final Long executionTimeInMillis;
}
