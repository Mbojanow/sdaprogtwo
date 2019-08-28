package pl.sdacademy.prog.comm;

import java.io.IOException;
import java.util.ArrayList;

public class CommunicatorDemo {

  public static void main(String[] args) throws IOException {
    final Communicator communicator = new Communicator();
    final Channel channel = new Channel("Programowanie2", "Powtarzamy wzorce projektowe", new ArrayList<>(), new ArrayList<>(), false);
    final User userA = new User("test1@gmail.com", "Andrzej Nowak", new ArrayList<>(), communicator);
    final User userB = new User("test2@gmail.com", "AnotherUser", new ArrayList<>(), communicator);

    communicator.addChannel(channel);
    userA.subscribe("Programowanie2");
    userB.subscribe("Programowanie2");
    userA.sendMessage("Hello", "Programowanie2");
    userB.sendMessage("Hi", "Programowanie2");
  }

}
