package pl.sdacademy.prog.actions;

public class PupilThread implements Runnable {

  private String name;

  public PupilThread(final String name) {
    this.name = name;
  }

  @Override
  public void run() {
    // 1s, budzi sie, 2s -> sniadanie, 5s -> wraca ze szkoly, 1s -> obiad, 2s -> lekcje
    try {
      sleepAndExecuteAction(1000L, " is waking up");
      sleepAndExecuteAction(2000L, " is eating breakfast");
      sleepAndExecuteAction(5000L, " is coming back from school");
      sleepAndExecuteAction(1000L, " is eating dinner");
      sleepAndExecuteAction(2000L, " is doing homework");
    } catch (final InterruptedException exp) {
      System.out.println("Interrupted by something");
    }
  }

  private void sleepAndExecuteAction(final Long sleepTimeInMillis, final String actionDescription) throws InterruptedException {
    Thread.sleep(sleepTimeInMillis);
    throwIfMamusiaIsCalling();
    System.out.println(name + actionDescription);
  }

  private void throwIfMamusiaIsCalling() throws InterruptedException {
    if (Thread.interrupted()) {
      System.out.println("Mamusia is calling. Ending my day");
      throw new InterruptedException();
    }
  }
}
