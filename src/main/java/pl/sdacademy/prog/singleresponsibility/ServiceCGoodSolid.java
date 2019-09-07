package pl.sdacademy.prog.singleresponsibility;

public class ServiceCGoodSolid {

  private final ServiceA serviceA;
  private final ServiceB serviceB;

  public ServiceCGoodSolid(final ServiceA serviceA, final ServiceB serviceB) {
    this.serviceA = serviceA;
    this.serviceB = serviceB;
  }

  public void doWork() {
    serviceA.doSomeWork();
    serviceB.doSomeOtherWork();
  }
}
