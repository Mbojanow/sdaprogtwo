package pl.sdacademy.prog.examples.animals.nogenerics;

public class Dog implements Animal {
    private String name;

    public Dog(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Double getWeight() {
        return 7.1;
    }
}
