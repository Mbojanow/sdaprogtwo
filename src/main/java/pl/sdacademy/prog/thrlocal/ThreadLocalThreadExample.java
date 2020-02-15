package pl.sdacademy.prog.thrlocal;

import pl.sdacademy.prog.fruits.Apple;
import pl.sdacademy.prog.fruits.Fruit;

public class ThreadLocalThreadExample implements Runnable {

  private static ThreadLocal<Fruit> fruit = new ThreadLocal<>();

  @Override
  public void run() {
    final Fruit fruitFromThreadLocalBefore = fruit.get();
    System.out.println(fruitFromThreadLocalBefore);
    fruit.set(new Apple(2.0D));
    final Fruit fruitFromThreadLocalAfter = fruit.get();
    System.out.println(fruitFromThreadLocalAfter);
  }
}
