package pl.sdacademy.prog.communicator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum Communicator {
  INSTANCE;

  private List<Channel> channels = new ArrayList<>();

  public List<Channel> getPublicChannels() {
    return channels.stream()
        .filter(channel -> !channel.isPrivate())
        .collect(Collectors.toList());
  }

  public void createChannel(final Channel channel) {
    if (channelWithNameDoesNotExist(channel.getName())) {
      channels.add(channel);
    }
  }

  private boolean channelWithNameDoesNotExist(final String name) {
    return channels.stream()
        .noneMatch(existingChannel -> existingChannel.getName().equals(name));
  }

  public List<Channel> getChannels() {
    return channels;
  }
}
