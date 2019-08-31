package pl.sdacademy.prog.slack;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

public enum Communicator {
  INSTANCE;

  private List<Channel> channels = new ArrayList<>();

  // POPRAWNIE STWORZONY SINGLETON TYPU DOUBLE CHECKED
//  private static Communicator instance;
//
//  // double checked
//  public static Communicator getInstance() {
//    // rownowazne instance == null
//    if (isNull(instance)) {
//      synchronized (Communicator.class) {
//        if (isNull(instance)) {
//          instance = new Communicator();
//        }
//      }
//    }
//    return instance;
//  }
//
//  private Communicator() {
//  }

  public List<Channel> getPublicChannels() {
    return channels.stream()
        .filter(channel -> !channel.isPrivate())
        .collect(Collectors.toList());
  }

  public void addChannel(final Channel channel) {
    final boolean nameAlreadyExists = channels.stream()
        .anyMatch(ch -> ch.getName().equalsIgnoreCase(channel.getName()));
    if (!nameAlreadyExists) {
      channels.add(channel);
    }
  }
}
