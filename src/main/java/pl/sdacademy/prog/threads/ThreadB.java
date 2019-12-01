package pl.sdacademy.prog.threads;

public class ThreadB implements Runnable {

  private String name;

  public ThreadB(final String name) {
    this.name = name;
  }

  /*
  • 0.5s, je śniadanie
  • 4s, je obiad
  • 2.5s, je deser
  • 2s, ogląda telewizję • 2s, pije piwo
   */
  @Override
  public void run() {
    try {
      Thread.sleep(500L);
      System.out.println(name + " is eating breakfast");
      Thread.sleep(4000L);
      System.out.println(name + " is eating dinner");
      Thread.sleep(2500L);
      System.out.println(name + " is eating dessert");
      Thread.sleep(2000L);
      System.out.println(name + " is watching TV");
      Thread.sleep(2000L);
      System.out.println(name + " is drinking beer");
    } catch (final InterruptedException exp) {

    }
  }
}
