package pl.sdacademy.prog.backpacks;

import java.util.List;

//@RequiredArgsConstructor - konstruktor z finalami
public class BackpacksProcessingFacade {

  private final TestDivider testDivider;
  private final TestExecutionInfoLoader testExecutionInfoLoader;
  private final SplitTestExecutionInfoPersister splitTestExecutionInfoPersister;

  public BackpacksProcessingFacade(final TestDivider testDivider,
                                   final TestExecutionInfoLoader testExecutionInfoLoader,
                                   final SplitTestExecutionInfoPersister splitTestExecutionInfoPersister) {
    this.testDivider = testDivider;
    this.testExecutionInfoLoader = testExecutionInfoLoader;
    this.splitTestExecutionInfoPersister = splitTestExecutionInfoPersister;
  }

  public void process(final String[] args) {
    final String inputFile = args[0];
    final String outputDir = args[1];
    final int backpacksNum = Integer.parseInt(args[2]);

    final List<TestExecutionInfo> loadedInfo
        = testExecutionInfoLoader.load(inputFile);
    final List<List<TestExecutionInfo>> backpacks
        = testDivider.divide(loadedInfo, backpacksNum);
    splitTestExecutionInfoPersister.saveSplitBackpacks(backpacks, outputDir);
  }
}
