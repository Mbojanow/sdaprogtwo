package pl.sdacademy.prog.genA;

public class MagicalGrapefruit implements Fruit {

  private String color;
  private Double weight;

  public MagicalGrapefruit(final String color, final Double weight) {
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
}
