package pl.sdacademy.prog.singleton;

public class MultiThreadedSingletonExample {

  private static MultiThreadedSingletonExample instance;

  private MultiThreadedSingletonExample() {
  }

  public static MultiThreadedSingletonExample getInstance() {
    if (instance == null) {
      synchronized (MultiThreadedSingletonExample.class) {
        if (instance == null) {
          instance = new MultiThreadedSingletonExample();
        }
      }
    }
    return instance;
  }


}
