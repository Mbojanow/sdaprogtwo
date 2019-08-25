package pl.sdacademy.prog.genA;

import java.util.Random;

public class AlwaysYellowBanana implements Fruit {

  private static final String YELLOW_COLOR = "YELLOW";

  private Double weight;
  private boolean rotten;

  public AlwaysYellowBanana(final Double weight) {
    this.weight = weight;
  }

  @Override
  public String getColor() {
    return YELLOW_COLOR;
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
