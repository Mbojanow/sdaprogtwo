package pl.sdacademy.prog.threads;

import java.util.Optional;

public class ThreadA implements Runnable {

  private String name;

  public ThreadA(final String name) {
    this.name = name;
  }

  /*
  • 1s, budzi się
  • 2s, przygotowywuje śniadanie
  • 5s, wraca ze szkoły
  • 1s, je obiad
  • 2s, odrabia lekcje
   */
  @Override
  public void run() {
    try {
      Thread.sleep(1000L);
      callItADayIfMamusiaIsCalling().orElseThrow();
      System.out.println(name + " is waking up");
      Thread.sleep(2000L);
      callItADayIfMamusiaIsCalling().orElseThrow();
      System.out.println(name + " is eating breakfast");
      Thread.sleep(5000L);
      callItADayIfMamusiaIsCalling().orElseThrow();
      System.out.println(name + " is coming back from school");
      Thread.sleep(1000L);
      callItADayIfMamusiaIsCalling().orElseThrow();
      System.out.println(name + " is eating dinner");
      Thread.sleep(2000L);
      callItADayIfMamusiaIsCalling().orElseThrow();
      System.out.println(name + " is doing homework");
    } catch (final InterruptedException exp) {
      System.out.println("Mamusia is calling. I am done.");
    }
  }

  private Optional<Boolean> callItADayIfMamusiaIsCalling() {
    if (Thread.currentThread().isInterrupted()) {
      System.out.println("Mamusia is calling. I am done.");
      return Optional.empty();
    }
    return Optional.of(true);
  }
}
