package pl.sdacademy.prog.multithreading.counting;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import pl.sdacademy.prog.slack.Communicator;
import pl.sdacademy.prog.slack.Role;
import pl.sdacademy.prog.slack.User;

public class IncrementingThread implements Runnable {

  private static int value = 0;
  private static final int ITERATION_NUM = 10000;

  private static final ThreadLocal<User> threadLocal = new ThreadLocal<>();

  private static synchronized void safeIncrement() {
    value++;
  }

  @Override
  public void run() {
    System.out.println(threadLocal.get());
    threadLocal.set(new User("test@gmail.com", "Andrzej",
        new ArrayList<>(), new Communicator(), Role.ADMIN));
    System.out.println(threadLocal.get());

    for (int idx = 0; idx < ITERATION_NUM; idx++) {
      safeIncrement();
    }
  }

  public static int getValue() {
    return value;
  }
}
