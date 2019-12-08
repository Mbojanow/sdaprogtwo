package pl.sdacademy.prog.communicator;

import java.util.ArrayList;

public class CommunicatorDemo {

  public static void main(String[] args) {
    final Communicator communicator = Communicator.INSTANCE;
    final Channel channel = Channel.builder()
        .isPrivate(false)
        .messages(new ArrayList<>())
        .name("programowanie2")
        .topic("whatever")
        .users(new ArrayList<>())
        .build();

    final User userA = User.builder()
        .communicator(communicator)
        .email("andrzej@test.com")
        .name("Andrzej")
        .subscribedChannels(new ArrayList<>())
        .build();
    final User userB = User.builder()
        .communicator(communicator)
        .email("michau@test.com")
        .name("Michau")
        .subscribedChannels(new ArrayList<>())
        .build();
    final User userC = User.builder()
        .communicator(communicator)
        .email("ala@test.com")
        .name("Ala")
        .subscribedChannels(new ArrayList<>())
        .build();
    communicator.createChannel(channel);

    userA.subscribe("programowanie2");
    userB.subscribe("programowanie2");

    userA.sendMessage("Hello", "programowanie2");
    userB.sendMessage("Hi! How do you like the class?",
        "programowanie2");
    userC.subscribe("programowanie2");
    userC.sendMessage("It sucks tbh", "programowanie2");
  }
}
