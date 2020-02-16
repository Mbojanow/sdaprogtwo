package pl.sdacademy.prog.communicator;

import java.util.ArrayList;

public class CommunicatorDemo {

  public static void main(String[] args) {
    final Communicator communicator = Communicator.INSTANCE;
    final Channel channel = new Channel("prog2", "Programowanie 2",
        new ArrayList<>(), new ArrayList<>(), false);
    communicator.createChannel(channel);

    final User userA = new User("andrzej@gmail.com", "andrzej", new ArrayList<>(), communicator);
    final User userB = new User("ala@gmail.com", "ala", new ArrayList<>(), communicator);
    final User userC = new User("janusz@gmail.com", "janusz", new ArrayList<>(), communicator);

    userA.subscribe("prog2");
    userB.subscribe("prog2");
    userA.sendMessage("Hi", "prog2");
    userB.sendMessage("Hello", "prog2");
    userC.subscribe("prog2");
    userC.sendMessage("Hello All!", "prog2");
  }
}
