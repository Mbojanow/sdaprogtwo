package pl.sdacademy.prog.slack;

public abstract class AbstractDemo {
  // nie moge zrobic new AbstractDemo();

  public abstract void toImplement();

  public void appliesSomeLogic() {
    printFromZeroToHundred();
    printFromHundredToZero();
  }

  private void printFromZeroToHundred() {
    for (int i = 0; i < 100; i++) {
      System.out.println(i);
    }
  }

  private void printFromHundredToZero() {
    for (int i = 100; i >= 0; i--) {
      System.out.println(i);
    }
  }
}
