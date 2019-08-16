package pl.sdacademy.prog.zadA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Box<T extends Fruit> {

    private List<T> fruits = new ArrayList<>();

    public void addFruit(final T fruit) {
        fruits.add(fruit);
    }

    public void removeRotten() {
        fruits = fruits.stream()
                .filter(fruit -> !fruit.isRotten())
                .collect(Collectors.toList());
    }

    public List<T> getFruits() {
        return fruits;
    }
}
