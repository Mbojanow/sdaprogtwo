package pl.sdacademy.prog.fruits;

public class FruitDemo {
  public static void main(String[] args) {
    final Fruit apple = new Apple(1.2);
    final Fruit banana = new YellowBanana(2.2);
    final Fruit grapefruit = new MagicalGrapefruit(5000.0);

    final FruitBox<Apple> appleFruitBox = new FruitBox<>();
    // appleFruitBox.addFruitToBox(banana);
    //final FruitBox<Object> fruitBox = new FruitBox<Object>(); Object nie rozszerza klasy Fruit
    final FruitBox<Fruit> fruitBox = new FruitBox<>();
    fruitBox.addFruitToBox(apple);
    fruitBox.addFruitToBox(banana);
    fruitBox.addFruitToBox(grapefruit);

    System.out.println(fruitBox.getTotalWeight());
    fruitBox.removeRotten();
    System.out.println(fruitBox.getTotalWeight());
  }
}
