package pl.sdacademy.prog.slack;

public class NotAbstractDemo  extends AbstractDemo {
  @Override
  public void toImplement() {
    System.out.println("Nothing");
  }

  public void hello() {
    System.out.println("hello");
  }
}
