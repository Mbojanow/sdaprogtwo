package pl.sdacademy.prog.zadA;

public class AlwaysYellowBanana implements Fruit {

    private int weight;

    public AlwaysYellowBanana(final int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeightInGrams() {
        return weight;
    }

    @Override
    public String getColor() {
        return "yellow";
    }
}
