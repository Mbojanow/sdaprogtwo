package pl.sdacademy.prog.fruits;

import java.util.Random;

import lombok.Getter;

@Getter
public abstract class Fruit {

  public Fruit() {
    this.isRotten = false;
  }

  protected String color;
  protected Double weight;
  private boolean isRotten;

  public boolean isRotten() {
    if (!isRotten) {
      isRotten = new Random().nextBoolean();
    }
    return isRotten;
  }
}
