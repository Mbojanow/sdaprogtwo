package pl.sdacademy.prog.threadsa;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadOne implements Runnable {

  private String name;

  public ThreadOne(final String name) {
    this.name = name;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000L);
      if (isMamusiaCalling()) {
        return;
      }
      System.out.println(name + " is waking up");
      Thread.sleep(2000L);

      if (isMamusiaCalling()) {
        return;
      }
      System.out.println(name + " is preparing breakfast");
      Thread.sleep(5000L);

      if (isMamusiaCalling()) {
        return;
      }
      System.out.println(name + " is coming back from school");
      Thread.sleep(1000L);

      if (isMamusiaCalling()) {
        return;
      }
      System.out.println(name + " is eating dinner");
      Thread.sleep(2000L);

      if (isMamusiaCalling()) {
        return;
      }
      System.out.println(name + " is doing homework");
    } catch (final InterruptedException exp) {
      isMamusiaCalling();
      System.out.println("Thread of " + name + " was interrupted");
      //log.warn("Thread of " + name + " was interrupted");
    }
  }

  private boolean isMamusiaCalling() {
    final boolean interrupted = Thread.currentThread().isInterrupted();
    System.out.println("Mamusia is " + (interrupted ? "" : "not") + " calling.");
    return interrupted;
  }
}
