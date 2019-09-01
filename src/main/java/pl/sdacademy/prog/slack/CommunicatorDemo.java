package pl.sdacademy.prog.slack;

import java.io.IOException;
import java.util.ArrayList;

public class CommunicatorDemo {

  public static void main(String[] args) throws IOException {

    final Channel prog2 = new Channel("Prog2", "Programowanie2",
        new ArrayList<>(), new ArrayList<>(), false);
    final Communicator communicator = new Communicator(new ArrayList<>());
    final User userA = new User("asd@gmail.com", "Grazyna",
        new ArrayList<>(), communicator, Role.ADMIN);
    final User userB = new User("asdx@gmail.com", "Janusz",
        new ArrayList<>(), communicator, Role.USER);

    communicator.addChannel(prog2);
//    userA.subscribe("Prog2");
//    userB.subscribe("Prog2");
//    userA.sendMessage("Hej", "Prog2");
//    userB.sendMessage("Grazyna przyniesz mi piwo", "Prog2");
    prog2.addUser(userA);
    prog2.addUser(userB);

    final ChannelManagement channelManagementReal = new ChannelManagementService(communicator);
    final ChannelManagement channelManagementProxy
        = new ChannelManagementServiceProxy(channelManagementReal, userA);

    channelManagementProxy.removeChannel("Prog2");
    System.out.println(communicator.getChannels().size());
  }
}
