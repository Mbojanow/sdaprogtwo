package pl.sdacademy.prog.singleresponsibility;

public class ServiceB {

  private static ServiceB instance = new ServiceB();

  public static ServiceB getInstance() {
    return instance;
  }

  public void doSomeOtherWork() {
    System.out.println("Doing some B work");
  }
}
