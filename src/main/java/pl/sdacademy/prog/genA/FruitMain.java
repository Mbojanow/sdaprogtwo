package pl.sdacademy.prog.genA;

public class FruitMain {

  public static void main(String[] args) {
    final Fruit apple = new Apple("GREEN", 2.3);
    final Fruit banana = new AlwaysYellowBanana(2.5);
    final Fruit grapefruit = new MagicalGrapefruit("PINK", 4.5);

    final FruitBox<Fruit> fruitBox = new FruitBox<>(); // dowolne owoce;
    final FruitBox<Apple> appleFruitBox = new FruitBox<>(); // tylko jablka
    final FruitBox<AlwaysYellowBanana> bananaBo = new FruitBox<>(); // banany

    fruitBox.addFruit(apple);
    fruitBox.addFruit(banana);
    fruitBox.addFruit(grapefruit);
    fruitBox.removeRotten();
  }
}
