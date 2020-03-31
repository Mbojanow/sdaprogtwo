package pl.sdacademy.prog;

/*Stwórz klasę, która wykorzystuje metodę OptionalBasicsPractice jako zależność (pamiętaj o soliD).
 Niech klasa ta ma metodę
 która na wejście przyjmuje String i char, a następnie zwraca inta - indeks chara w wejściowy Stringu.
 W przypadku nieznalezienia chara w Stringu wyrzuć wyjątek własnego typu unchecked.

 */
public class OptionalAdvancedPractice {

  private OptionalBasicsPractice optionalBasicsPractice;

  //dobry
  // zależności do klasy przychodzą z zewnątrz
  public OptionalAdvancedPractice(final OptionalBasicsPractice optionalBasicsPractice) {
    this.optionalBasicsPractice = optionalBasicsPractice;
  }

//  // zło
//  public OptionalAdvancedPractice() {
//    this.optionalBasicsPractice = new OptionalBasicsPractice();
//  }

  // checked - Exception
  // unchecked - RuntimeException

  public Integer getFirstCharInString(final String toCheck, final char c) {
    return optionalBasicsPractice.findCharIndex(toCheck, c)
        .orElseThrow(() -> new SdaException("Char not found"));
  }

}
