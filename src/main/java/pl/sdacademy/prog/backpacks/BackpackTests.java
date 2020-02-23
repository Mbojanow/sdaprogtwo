package pl.sdacademy.prog.backpacks;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BackpackTests {
  private List<TestExecutionInfo> testInfos;

  public Long sumExecutionTimes() {
    return testInfos.stream()
        .mapToLong(TestExecutionInfo::getExecutionTime)
        .sum();
  }

  public void addTestInfo(final TestExecutionInfo testExecutionInfo) {
    testInfos.add(testExecutionInfo);
  }
}
