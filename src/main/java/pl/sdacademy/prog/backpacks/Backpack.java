package pl.sdacademy.prog.backpacks;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Backpack {
  private final int index;
  private final List<TestExecutionInfo> testExecutionInfos = new ArrayList<>();

  public long getSumOfExecutionsTimes() {
    return testExecutionInfos.stream()
        .mapToLong(TestExecutionInfo::getExecutionTimeInMillis)
        .sum();
  }

  // po to żeby użytkownik nie musiał x.getTestExecutionInfos().add(info)
  public void addTestExecutionInfo(final TestExecutionInfo info) {
    testExecutionInfos.add(info);
  }
}
