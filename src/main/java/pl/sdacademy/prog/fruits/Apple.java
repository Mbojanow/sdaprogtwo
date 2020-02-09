package pl.sdacademy.prog.fruits;

import java.util.Random;

public class Apple extends Fruit {

  public Apple(final Double weight) {
    super();
    this.weight = weight;
    this.color = new Random().nextBoolean() ? "GREEN" : "RED";
  }
}
