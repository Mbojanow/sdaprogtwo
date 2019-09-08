package pl.sdacademy.prog.day6.strategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
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
class FileContentModificationServiceTest {

  private static final String TYPE_ARG = "tdyfcggcffcKEBAB_CASE";
  private static final String FILE_ARG = "/Users/michalbojanowski/work/spam/sdaprogtwo/src/test/resouces/test";
  private static final String[] ARGUMENTS = { TYPE_ARG, FILE_ARG };

  @Mock
  private TextModificationStrategyProvider provider;

  @Mock
  private CustomCommandLineParser parser;

  @Mock
  private TextModificationStrategy strategy;

  @InjectMocks
  private FileContentModificationService service;

  // sluzy do wyłapywania wartosci argumentow metody z mocka
  @Captor
  private ArgumentCaptor<String> stringArgumentCaptor;

  @Test
  void shouldProcessFile() {
    doNothing().when(parser).parseArguments(ARGUMENTS);
    when(parser.getFilePathArgValue()).thenReturn(FILE_ARG);
    when(parser.getModificationTypeArgValue()).thenReturn(TYPE_ARG);
    when(provider.getStrategyByType(TYPE_ARG)).thenReturn(strategy);

    service.processFile(ARGUMENTS);

    verify(strategy).process(stringArgumentCaptor.capture());
    assertThat(stringArgumentCaptor.getValue()).isEqualTo(
        "dasdsa ddsahkdshkeqw dasDSadd das--dasDQWdadas"
    );

  }

}