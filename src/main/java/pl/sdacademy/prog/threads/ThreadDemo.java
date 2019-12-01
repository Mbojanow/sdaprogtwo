package pl.sdacademy.prog.threads;

public class ThreadDemo {

  public static void main(String[] args) throws InterruptedException {
    final Thread thrA = new Thread(new ThreadA("Ala"));
    final Thread thrB = new Thread(new ThreadB("Janusz"));

    thrA.start();
    thrB.start();

    thrA.join();
    thrB.join();
  }
}
