package pl.sdacademy.prog.examples.generics;

import pl.sdacademy.prog.examples.animals.nogenerics.Cat;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {
    public static void main(String[] args) {

        Cat cat = new Cat("Puszek");
        Transporter<Cat> catTransporter = new Transporter<>(cat);
    }
}
