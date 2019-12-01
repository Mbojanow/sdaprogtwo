package pl.sdacademy.prog.generics;

public class MagicalGrapefruit extends Fruit {
  public MagicalGrapefruit(final String color, final Double weight) {
    super(color, weight, false);
  }

  @Override
  public boolean isRotten() {
    return rotten;
  }
}
