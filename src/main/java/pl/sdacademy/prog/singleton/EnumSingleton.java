package pl.sdacademy.prog.singleton;

public enum EnumSingleton {
  INSTANCE;

  private int count = 0;

  public void addOne() {
    count++;
  }

  public void addTwo() {
    count += 2;
  }

  public void addThree() {
    count += 3;
  }

  public int getCount() {
    return count;
  }
}
