package pl.sdacademy.prog.backpacks;

import java.util.List;

//@RequiredArgsConstructor - konstruktor z finalami
public class BackpacksProcessingFacade {

  private final TestDivider testDivider;
  private final TestExecutionInfoLoader testExecutionInfoLoader;
  private final SplitTestExecutionInfoPersister splitTestExecutionInfoPersister;
  private final BackpacksCommandLineParser backpacksCommandLineParser;

  public BackpacksProcessingFacade(final TestDivider testDivider,
                                   final TestExecutionInfoLoader testExecutionInfoLoader,
                                   final SplitTestExecutionInfoPersister splitTestExecutionInfoPersister,
                                   final BackpacksCommandLineParser backpacksCommandLineParser) {
    this.testDivider = testDivider;
    this.testExecutionInfoLoader = testExecutionInfoLoader;
    this.splitTestExecutionInfoPersister = splitTestExecutionInfoPersister;
    this.backpacksCommandLineParser = backpacksCommandLineParser;
  }

  public void process(final String[] args) {
    backpacksCommandLineParser.parse(args);
    final String inputFile = backpacksCommandLineParser.getInputFileArgValue();
    final String outputDir = backpacksCommandLineParser.getOutputFileArgValue();
    final int backpacksNum = backpacksCommandLineParser.getBackpacksArgValue();

    final List<TestExecutionInfo> loadedInfo
        = testExecutionInfoLoader.load(inputFile);
    final List<List<TestExecutionInfo>> backpacks
        = testDivider.divide(loadedInfo, backpacksNum);
    splitTestExecutionInfoPersister.saveSplitBackpacks(backpacks, outputDir);
  }
}
