package pl.sdacademy.prog.communicator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public enum Communicator {
  INSTANCE;

  private List<Channel> channels;

  Communicator() {
    channels = new ArrayList<>();
  }


  public List<Channel> getPublicChannels() {
    return channels.stream()
        .filter(channel -> !channel.isPrivate())
        .collect(Collectors.toList());
  }

  public void createChannel(final Channel channel) {
    final boolean channelWithNameDoesNotExist = channels.stream()
        .noneMatch(existingChannel -> existingChannel.getName().equals(channel.getName()));
    if (channelWithNameDoesNotExist) {
      channels.add(channel);
    }
  }
}
