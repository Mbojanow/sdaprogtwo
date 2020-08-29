package pl.sdacademy.prog.integers;

public class IntegerIncrements {

  private static int value = 0;

  public static void main(String[] args) throws InterruptedException {
    System.out.println(Runtime.getRuntime().availableProcessors());
    Thread t1 = new Thread(new IncrementingThread());
    Thread t2 = new Thread(new IncrementingThread());
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(value);
  }

  static class IncrementingThread implements Runnable {
    @Override
    public void run() {
      for (int idx = 0; idx < 10000; idx++) {
        incrementValue();
        // TEZ POPRAWNE PODEJŚCIE
//        synchronized (IntegerIncrements.class) {
//          value++;
//        }
      }
    }
  }

  private synchronized static void incrementValue() {
    value++;
  }

}
