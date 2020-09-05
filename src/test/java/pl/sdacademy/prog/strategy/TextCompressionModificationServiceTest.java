package pl.sdacademy.prog.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TextCompressionModificationServiceTest {

  private final TextCompressionModificationService service = TextCompressionModificationService.INSTANCE;

  @Test
  void shouldCompressTest() {
    //given
    final String sentenceToCompress = " to jest jakies zdanie. ";
    final String expectedSentence = "toJestJakiesZdanie";

    //when
    final String actualResult = service.modify(sentenceToCompress);

    //then
    assertThat(actualResult).isEqualTo(expectedSentence);
  }

  @Test
  void shouldCompressTextWithStrangeChars() {
    final String sentenceToCompress = " To Jest;dziwne  zdanie-.&^%$z DZIWNYMI znakami   .";
    final String expectedSentence = "ToJestDziwneZdanieZDZIWNYMIZnakami";

    //when
    final String actualResult = service.modify(sentenceToCompress);

    //then
    assertThat(actualResult).isEqualTo(expectedSentence);
  }
}