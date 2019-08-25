package pl.sdacademy.prog.genA;

import java.util.Random;

public class Apple implements Fruit {
  private String color;
  private Double weight;
  private boolean rotten;

  public Apple(final String color, final Double weight) {
    this.color = color;
    this.weight = weight;
  }

  @Override
  public String getColor() {
    return color;
  }

  @Override
  public Double getWeight() {
    return weight;
  }

  @Override
  public boolean isRotten() {
    if (rotten) {
      return rotten;
    }
    rotten = new Random().nextBoolean();
    return rotten;
  }
}
