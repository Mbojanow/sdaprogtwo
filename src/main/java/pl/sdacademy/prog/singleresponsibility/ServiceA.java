package pl.sdacademy.prog.singleresponsibility;

public class ServiceA {

  private static ServiceA instance = new ServiceA();

  public static ServiceA getInstance() {
    return instance;
  }

  public void doSomeWork() {
    System.out.println("Doing some A work");
  }
}
