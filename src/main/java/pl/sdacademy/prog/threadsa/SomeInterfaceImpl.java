package pl.sdacademy.prog.threadsa;

public class SomeInterfaceImpl implements SomeInterface {
  @Override
  public void someMethod() throws OurException {
    throw new OurException();
  }
}
