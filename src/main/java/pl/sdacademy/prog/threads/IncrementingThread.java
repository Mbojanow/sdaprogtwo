package pl.sdacademy.prog.threads;

import java.util.Random;

import pl.sdacademy.prog.stra.CountryCurrencyData;

public class IncrementingThread implements Runnable {

  private PackedInt packedInt;

  private static ThreadLocal<CountryCurrencyData> ccdThreadLocal = new ThreadLocal<>();

  public IncrementingThread(final PackedInt packedInt) {
    this.packedInt = packedInt;
  }

  @Override
  public void run() {
    final CountryCurrencyData countryCurrencyData = ccdThreadLocal.get();
    System.out.println(countryCurrencyData);
    ccdThreadLocal.set(CountryCurrencyData.builder()
        .amount(new Random().nextDouble())
        .build());
    System.out.println(ccdThreadLocal.get());

    for (int idx = 0; idx < 10000; idx++) {
      packedInt.increment();
//      try {
//        Thread.sleep(10L);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
    }
  }
}
