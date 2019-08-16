package pl.sdacademy.prog.zadA;

public class Apple implements Fruit {

    private int weight;
    private String color;

    public Apple(final int weight, final String color) {
        this.weight = weight;
        this.color = color;
    }

    @Override
    public int getWeightInGrams() {
        return weight;
    }

    @Override
    public String getColor() {
        return color;
    }
}
