package pl.sdacademy.prog.multithreading;

import static pl.sdacademy.prog.multithreading.ThreadingMain.isMamusiaCalling;

public class ThreadA implements Runnable {

  private String name;

  public ThreadA(final String name) {
    this.name = name;
  }

  @Override
  public void run() {
    try {
//      2;
//      true;
//      "asd";
      // lapiemy do zmiennej z bo linijka w javie 'true'; sie nie kompiluje
      final boolean mamusiaCalled = executeTaskIfMamusiaNotCalling(1000L , " is waking up") &&
      executeTaskIfMamusiaNotCalling(2000L , " is preparing breakfast") &&
      executeTaskIfMamusiaNotCalling(5000L , " is coming back from school") &&
      executeTaskIfMamusiaNotCalling(1000L , " is eating dinner") &&
      executeTaskIfMamusiaNotCalling(2000L , " is doing homework");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private boolean executeTaskIfMamusiaNotCalling(final long sleepTime, final String taskDescription) throws InterruptedException {
    Thread.sleep(sleepTime);
    if (isMamusiaCalling) {
      System.out.println("Mamusia is calling. Calling it a day");
      return false;
    }
    System.out.println(name +  taskDescription);
    return true;
  }
}
