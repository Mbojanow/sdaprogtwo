package pl.sdacademy.prog.memorymodel;

public class ThreadLocalDemo {
  public static void main(String[] args) throws InterruptedException {
    final Thread t1 = new Thread(new SimpleThread());
    final Thread t2 = new Thread(new SimpleThread());
    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }
}
