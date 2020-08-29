package pl.sdacademy.prog.actions;

public class WorkerThread implements Runnable {

  private final String name;

  public WorkerThread(final String name) {
    this.name = name;
  }

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
      System.out.println("My day was interrupted said " + name);
    }
  }

}
