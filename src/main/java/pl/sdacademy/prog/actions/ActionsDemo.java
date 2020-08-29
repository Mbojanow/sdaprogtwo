package pl.sdacademy.prog.actions;

public class ActionsDemo {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(new PupilThread("Ala"));
    Thread t2 = new Thread(new WorkerThread("Jan"));
    t1.start();
    t2.start();
    Thread.sleep(6000L);
    t1.interrupt();
    t1.join();
    t2.join();
  }
}
