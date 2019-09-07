package pl.sdacademy.prog.multithreading;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreadingMain {

  public static volatile boolean isMamusiaCalling = false;

  public static void main(String[] args) throws InterruptedException {
    final Thread thrA = new Thread(new ThreadA("Ala"));
    final Thread thrB = new Thread(new ThreadB("Janusz"));

    thrA.start();
    thrB.start();

    Thread.sleep(5000L);
    //isMamusiaCalling = true;
    thrA.interrupt();
    thrB.interrupt();

    thrA.join();
    thrB.join();

//    final List<Thread> aTHreads = Stream.generate(() -> new Thread(new ThreadA("Ala"))).limit(32).collect(Collectors.toList());
//
//    for (final Thread t : aTHreads) {
//      t.start();
//    }
//
//    for (Thread aTHread : aTHreads) {
//      aTHread.join();
//    }

  }
}
