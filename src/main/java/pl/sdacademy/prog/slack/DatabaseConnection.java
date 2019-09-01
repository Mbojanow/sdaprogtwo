package pl.sdacademy.prog.slack;

public class DatabaseConnection {

  private boolean open;

  public boolean isOpen() {
    return open;
  }

  public void open() {
    open = true;
  }

  public void close() {
    open = false;
  }
}
