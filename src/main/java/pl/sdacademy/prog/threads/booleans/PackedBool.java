package pl.sdacademy.prog.threads.booleans;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class PackedBool {
  private AtomicBoolean value;

  public PackedBool() {
    value = new AtomicBoolean(new Random().nextBoolean());
    System.out.println("Random value is " + value.get());
  }

  public Boolean getValue() {
    return value.get();
  }

  public synchronized void switchValue() {
    value.set(!value.get());
  }
}
