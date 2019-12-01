package pl.sdacademy.prog.generics;

import java.util.Random;

public abstract class Fruit {

  private String color;
  private Double weight;
  protected boolean rotten;

  protected Fruit(final String color, final Double weight, final boolean rotten) {
    this.color = color;
    this.weight = weight;
    this.rotten = rotten;
  }

  public String getColor() {
    return color;
  }

  public Double getWeight() {
    return weight;
  }

  public boolean isRotten() {
    if (rotten) {
      return rotten;
    }
    rotten = new Random().nextBoolean();
    return rotten;
  }
}
