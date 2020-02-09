package pl.sdacademy.prog.fruits;

public class MagicalGrapefruit extends Fruit {

  public MagicalGrapefruit(final Double weight) {
    super();
    color = "PINK";
    this.weight = weight;
  }

  @Override
  public boolean isRotten() {
    return false;
  }
}

