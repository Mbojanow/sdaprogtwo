package pl.sdacademy.prog.strategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TextModificationProcessFacadeTest {
  @Mock
  private CustomCommandLineParser customCommandLineParser;

  @Mock
  private FileContentReader fileContentReader;

  @Mock
  private TextModificationStrategySelector strategySelector;

  @InjectMocks
  private TextModificationProcessFacade facade;

  @Test
  void shouldProcessTextModification() throws ParseException {
    final String[] args = {"doesNotMatter", "thisValueReallyDoesNotMatterAtAll"};
    doNothing().when(customCommandLineParser).parse(args);
    when(customCommandLineParser.getTypeOptionValue()).thenReturn(Optional.of("someType"));
    when(customCommandLineParser.getFileOptionValue()).thenReturn(Optional.of("someFilePath"));
    final TextModificationStrategy strategy = NoOpModificationStrategy.getInstance();
    when(strategySelector.getTextModificationStrategy("someType"))
        .thenReturn(strategy);
    when(fileContentReader.readContent("someFilePath")).thenReturn("someFileContent");

    final String output = facade.process(args);

    assertThat(output).isEqualTo("someFileContent");
  }
}