package pl.sdacademy.prog.generics;

import java.util.Random;

public class Apple extends Fruit {

  public Apple(final Double weight, final boolean rotten) {
    super(new Random().nextBoolean() ? "GREEN" : "RED", weight, rotten);
  }
}
