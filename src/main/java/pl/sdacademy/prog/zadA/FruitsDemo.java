package pl.sdacademy.prog.zadA;

public class FruitsDemo {

    public static void main(String[] args) {

        final Box<Fruit> fruitBox = new Box<>();

        fruitBox.addFruit(new Apple(20, "green"));
        fruitBox.addFruit(new AlwaysYellowBanana(13));
        fruitBox.addFruit(new MagicalGrapefruit(80));

        fruitBox.removeRotten();

        System.out.println(fruitBox.getFruits().size());
    }
}
