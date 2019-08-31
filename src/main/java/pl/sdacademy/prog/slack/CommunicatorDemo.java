package pl.sdacademy.prog.slack;

import java.io.IOException;
import java.util.ArrayList;

public class CommunicatorDemo {

  public static void main(String[] args) throws IOException {

    final Channel prog2 = new Channel("Prog2", "Programowanie2",
        new ArrayList<>(), new ArrayList<>(), false);
    final Communicator communicator = new Communicator(new ArrayList<>());
    final User userA = new User("asd@gmail.com", "Grazyna",
        new ArrayList<>(), communicator);
    final User userB = new User("asdx@gmail.com", "Janusz",
        new ArrayList<>(), communicator);

    communicator.addChannel(prog2);
    userA.subscribe("Prog2");
    userB.subscribe("Prog2");
    userA.sendMessage("Hej", "Prog2");
    userB.sendMessage("Grazyna przyniesz mi piwo", "Prog2");
  }
}
