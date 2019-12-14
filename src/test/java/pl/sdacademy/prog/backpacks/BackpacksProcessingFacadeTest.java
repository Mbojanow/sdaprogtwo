package pl.sdacademy.prog.backpacks;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BackpacksProcessingFacadeTest {

  @Mock
  private TestDivider testDivider;

  @Mock
  private TestExecutionInfoLoader testExecutionInfoLoader;

  @Mock
  private SplitTestExecutionInfoPersister splitTestExecutionInfoPersister;

  @Mock
  private BackpacksCommandLineParser backpacksCommandLineParser;

  @InjectMocks
  private BackpacksProcessingFacade facade;

  @Test
  void shouldProcessBackpacksSplit() {
    final int backpackNum = 4;
    final String input = "/input";
    final String output = "/output";
    final TestExecutionInfo testExecutionInfoA
        = new TestExecutionInfo("test1", 1L);
    final TestExecutionInfo testExecutionInfoB
        = new TestExecutionInfo("test2", 2L);
    final List<List<TestExecutionInfo>> testExecutionInfos =
        List.of(List.of(testExecutionInfoA), List.of(testExecutionInfoB));
    doNothing().when(backpacksCommandLineParser).parse(any());
    when(backpacksCommandLineParser.getBackpacksArgValue()).thenReturn(backpackNum);
    when(backpacksCommandLineParser.getInputFileArgValue()).thenReturn(input);
    when(backpacksCommandLineParser.getOutputFileArgValue()).thenReturn(output);
    when(testExecutionInfoLoader.load(input))
        .thenReturn(List.of(testExecutionInfoA, testExecutionInfoB));
    when(testDivider.divide(List.of(testExecutionInfoA, testExecutionInfoB),
        backpackNum))
        .thenReturn(testExecutionInfos);
    doNothing().when(splitTestExecutionInfoPersister)
         .saveSplitBackpacks(testExecutionInfos, output);

    facade.process(null);
  }



}