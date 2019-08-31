package pl.sdacademy.prog.slack;

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

  public void addChannel(final Channel channel) {
    final boolean nameAlreadyExists = channels.stream()
        .anyMatch(ch -> ch.getName().equalsIgnoreCase(channel.getName()));
    if (!nameAlreadyExists) {
      channels.add(channel);
    }
  }
}
