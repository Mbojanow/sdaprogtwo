package pl.sdacademy.prog.zadA;

public class MagicalGrapefruit implements Fruit {

    private int weight;
    private String color;

    public MagicalGrapefruit(final int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeightInGrams() {
        return weight;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean isRotten() {
        return false;
    }
}
