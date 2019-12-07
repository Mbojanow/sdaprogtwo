package pl.sdacademy.prog.communicator;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Communicator {
  private List<Channel> channels;

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
