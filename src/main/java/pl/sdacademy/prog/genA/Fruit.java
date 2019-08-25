package pl.sdacademy.prog.genA;

public interface Fruit {
  String getColor();
  Double getWeight();
  default boolean isRotten() {
    return false;
  }
}
