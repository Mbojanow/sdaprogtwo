package pl.sdacademy.prog.template;

public class TestDemo {
  public static void main(String[] args) {
    final PerformanceTestTemplate test = new SortingNumbersPerformanceTest();
    // też działa ALE łamiemy zasadę SOLID - L
    //SortingNumbersPerformanceTest test = new SortingNumbersPerformanceTest();
    //test.run();

    final PerformanceTestTemplate stringTest = new StringContatenationPerformanceTest();
    stringTest.run();
  }
}
