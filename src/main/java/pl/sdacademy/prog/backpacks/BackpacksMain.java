package pl.sdacademy.prog.backpacks;

import java.util.List;

import org.apache.commons.cli.CommandLineParser;

public class BackpacksMain {

  public static void main(String[] args) {
    ///Users/michalbojanowski/work/spam/sdaprogtwo/src/main/resources/testtimes.txt
    // /Users/michalbojanowski/work/spam/sdaprogtwo/src/main/resources
    // 4
//    final String inputFile = args[0];
//    final String outputDir = args[1];
//    final int backpacksNum = Integer.parseInt(args[2]);


    //-f=/Users/michalbojanowski/work/spam/sdaprogtwo/src/main/resources/testtimes.txt
    // -o=/Users/michalbojanowski/work/spam/sdaprogtwo/src/main/resources
    // -n=4
    final TestExecutionInfoLoader loader = new TestExecutionInfoLoader();
    final TestDivider testDivider = new TestDivider();
    final SplitTestExecutionInfoPersister persister = new SplitTestExecutionInfoPersister();
    final BackpacksCommandLineParser parser = new BackpacksCommandLineParser();
    final BackpacksProcessingFacade facade
        = new BackpacksProcessingFacade(testDivider, loader, persister, parser);
    facade.process(args);
//    final List<TestExecutionInfo> inputTests = loader.load(inputFile);
//    final List<List<TestExecutionInfo>> splitTests = testDivider.divide(inputTests, backpacksNum);
//    persister.saveSplitBackpacks(splitTests, outputDir);
  }
}
