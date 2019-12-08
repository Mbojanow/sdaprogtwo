package pl.sdacademy.prog.strategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TextProcessingFacadeTest {
  @Mock
  private CustomCommandLineParser customCommandLineParser;

  @Mock
  private FileContentProvider fileContentProvider;

  @Mock
  private ConversionStrategyProvider conversionStrategyProvider;

  @InjectMocks
  private TextProcessingFacade textProcessingFacade;

  @Captor
  private ArgumentCaptor<String> captor;

  @Mock
  private TextConversionStrategy textConversionStrategy;

  @Test
  void shouldProvideProperModificationStrategy() {
    final String[] args = new String[] {"-t=KEBAB_CASE", "-f=/Users/sometext"};
    doNothing().when(customCommandLineParser).parse(args);
    when(customCommandLineParser.getConversionTypeArgValue())
        .thenReturn(ConversionType.KEBAB_CASE);
    when(customCommandLineParser.getFilePathArgValue())
        .thenReturn("/Users/sometext");
    when(fileContentProvider.readContent("/Users/sometext"))
        .thenReturn("someFileContent");
    when(conversionStrategyProvider.getStrategy(ConversionType.KEBAB_CASE))
        .thenReturn(textConversionStrategy);
    when(textConversionStrategy.modify("someFileContent"))
        .thenReturn("output");

    textProcessingFacade.process(args);

    verify(textConversionStrategy).modify(captor.capture());
    assertThat(captor.getValue()).isEqualTo("someFileContent");
  }
}