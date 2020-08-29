package pl.sdacademy.prog.actions;

public class ThrowingMain {
  public static void main(String[] args) throws InterruptedException {
    if (1 == 1) {
      throw new InterruptedException();
    }
    System.out.println("hi");
  }
}
