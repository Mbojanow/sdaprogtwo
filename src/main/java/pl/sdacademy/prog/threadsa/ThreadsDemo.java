package pl.sdacademy.prog.threadsa;

public class ThreadsDemo {
  public static void main(String[] args) throws InterruptedException {
                            // przeciążenie Thread(Runnable)
    final Thread threadA = new Thread(new ThreadOne("Ala"));
    final Thread threadB = new Thread(new ThreadTwo("Andrzej"));

    threadA.start();
    threadB.start();

    Thread.sleep(2);
    threadA.interrupt();

    threadA.join();
    threadB.join();
    System.out.println("EXITING");
  }

  public static void methodThatThrowsCheckedException() {
    try {
      throw new OurException();
    } catch (final OurException exp) {

    }
  }
}

class OurException extends Exception {
  public OurException() {
  }
}
