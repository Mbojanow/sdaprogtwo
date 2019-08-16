package pl.sdacademy.prog.examples.generics;

import pl.sdacademy.prog.examples.animals.nogenerics.Animal;

public class Transporter<T extends Animal> {
    private T animal;

    public Transporter(final T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public Double getWeightInKg() {
        return animal.getWeight();
    }
}
