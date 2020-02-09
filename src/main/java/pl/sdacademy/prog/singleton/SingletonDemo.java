package pl.sdacademy.prog.singleton;

public class SingletonDemo {
  public static void main(String[] args) {
    final MultiThreadedSingletonExample singleton = MultiThreadedSingletonExample.getInstance();

    final EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
    enumSingleton.addOne();
    enumSingleton.addTwo();
    enumSingleton.addThree();
    System.out.println(enumSingleton.getCount());
  }
}
