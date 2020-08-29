package pl.sdacademy.prog.spam;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    final CountDownLatch cdl = new CountDownLatch(5);
    final List<Thread> thrs = Stream.generate(() -> new Thread(new Thr(cdl))).limit(5)
        .collect(Collectors.toList());

    thrs.forEach(thr -> thr.start());
    System.out.println("Awainting");
    cdl.await();
    System.out.println("Finally...");
  }
}
