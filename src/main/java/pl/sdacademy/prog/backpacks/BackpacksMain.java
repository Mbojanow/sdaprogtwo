package pl.sdacademy.prog.backpacks;

import java.util.List;

public class BackpacksMain {

  public static void main(String[] args) {
    ///Users/michalbojanowski/work/spam/sdaprogtwo/src/main/resources/testtimes.txt
    // /Users/michalbojanowski/work/spam/sdaprogtwo/src/main/resources
    // 4
    final String inputFile = args[0];
    final String outputDir = args[1];
    final int backpacksNum = Integer.parseInt(args[2]);

    final TestExecutionInfoLoader loader = new TestExecutionInfoLoader();
    final TestDivider testDivider = new TestDivider();
    final SplitTestExecutionInfoPersister persister = new SplitTestExecutionInfoPersister();

    final List<TestExecutionInfo> inputTests = loader.load(inputFile);
    final List<List<TestExecutionInfo>> splitTests = testDivider.divide(inputTests, backpacksNum);
    persister.saveSplitBackpacks(splitTests, outputDir);
  }
}
