package pl.sdacademy.prog.zadA;

import java.util.Random;

public interface Fruit {

    boolean previousRottenState = false;

    int getWeightInGrams();
    String getColor();
    default boolean isRotten() {
        if (previousRottenState) {
            return true;
        }
        return new Random().nextBoolean();
    }

}
