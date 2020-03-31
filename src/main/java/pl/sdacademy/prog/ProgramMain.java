package pl.sdacademy.prog;

import java.util.Optional;

public class ProgramMain {
    public static void main(String[] args) {
        /*• W metodzie main wykorzystaj metodę, znajdującą indeks chara.
        Wykorzystaj metodę get() na Optionalu i wyświetl informacje o indeksie w przypadku jego znalezienia
         */

        /*
        W metodzie main wykorzystaj metodę szukającą pierwszą parzystą cyfrę,
         wypisz ją na ekran z odpowiednią informacją, wykorzystaj ifPresent
         */

        final OptionalBasicsPractice optionalBasicsPractice = new OptionalBasicsPractice();

        optionalBasicsPractice.findFirstEvenDigit(12345)
            .ifPresent((value) -> System.out.println("First even digit is " + value));

        //
        final Optional<Integer> firstEvenDigit = optionalBasicsPractice.findFirstEvenDigit(12345);

        firstEvenDigit.orElse(getSomeInt());
        firstEvenDigit.orElseGet(() -> getSomeInt());
    }

    private static int getSomeInt() {
        System.out.println("HELLO");
        return 1 + 1;
    }

}


//https://github.com/mbojanow/sdaprogtwo