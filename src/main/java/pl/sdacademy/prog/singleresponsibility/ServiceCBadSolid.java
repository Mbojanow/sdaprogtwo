package pl.sdacademy.prog.singleresponsibility;

public class ServiceCBadSolid {

  public ServiceCBadSolid() {

  }

  public void doWork() {
    ServiceA.getInstance().doSomeWork();
    ServiceB.getInstance().doSomeOtherWork();
  }

}
