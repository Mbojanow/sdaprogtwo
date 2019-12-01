package pl.sdacademy.prog.generics;

public class FruitBoxDemo {

  public static void main(String[] args) {
    final FruitBox<Fruit> fruitBox = new FruitBox<>();

    fruitBox.addFruit(new AlwaysYellowBanana(22.0, false));
    fruitBox.addFruit(new Apple(55.1, false));
    fruitBox.addFruit(new MagicalGrapefruit("PINK", 10000000.0));

    fruitBox.getFruits().forEach(System.out::println);
    fruitBox.removeRotten();
    fruitBox.getFruits().forEach(System.out::println);

  }
}
