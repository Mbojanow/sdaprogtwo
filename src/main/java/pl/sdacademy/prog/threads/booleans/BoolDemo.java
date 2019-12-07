package pl.sdacademy.prog.threads.booleans;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BoolDemo {
  public static void main(String[] args) {
    final PackedBool packedBool = new PackedBool();

    final List<Thread> threads = Stream
        .generate(() -> new Thread(new SwitchingThread(packedBool)))
        .limit(4).collect(Collectors.toList());
    threads.forEach(Thread::start);
    threads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    System.out.println(packedBool.getValue());
  }
}
