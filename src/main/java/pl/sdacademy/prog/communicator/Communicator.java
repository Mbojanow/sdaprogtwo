package pl.sdacademy.prog.communicator;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Communicator {
  private List<Channel> channels;

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
}
