package pl.sdacademy.prog.template;

public abstract class PerformanceTestTemplate {

  //ilosc iteracji rozgrzewkowych
  protected abstract int getWarmupIterationsNum();

  // ilosc iteracji mierzonyvh
  protected abstract int getIterationsNum();

  // kawalek kodu ktorego czas bede mierzyl - pojedyczna iteracja
  protected abstract void testIteration();

  // szkielet algorytmu - TEMPLATE design pattern - zależnosci miedzy zachowaniem metod (np kolejnosc)
  public void run() {
    for (int idx = 0; idx < getWarmupIterationsNum(); idx++) {
      testIteration();
    }

    final long startTime = System.currentTimeMillis();
    for (int idx = 0; idx < getIterationsNum(); idx++) {
      testIteration();
    }
    final long endTime = System.currentTimeMillis();
    final double avg = (endTime - startTime) / (double)getIterationsNum();
    System.out.println("Avg iteration time took " + avg);
  }
}
