package pl.sdacademy.prog.multithreading;

import static pl.sdacademy.prog.multithreading.ThreadingMain.isMamusiaCalling;

public class ThreadB implements Runnable {

  private String name;

  public ThreadB(final String name) {
    this.name = name;
  }

  @Override
  public void run() {
    try {
      final boolean mamusiaCalled = executeTaskIfMamusiaNotCalling(500L, " is drinking beer") &&
          executeTaskIfMamusiaNotCalling(4000L, " is eating breakfast") &&
          executeTaskIfMamusiaNotCalling(2500L, " is eating dinner") &&
          executeTaskIfMamusiaNotCalling(2500L, " is eating dessert") &&
          executeTaskIfMamusiaNotCalling(2000L, " is watching TV");
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
    System.out.println(name + taskDescription);
    return true;
  }
}
