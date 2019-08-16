package pl.sdacademy.prog.examples.animals.nogenerics;

public class Cat implements Animal {

    private String name;

    public Cat(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Double getWeight() {
        return 5.5;
    }
}
