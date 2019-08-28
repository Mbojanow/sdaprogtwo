package pl.sdacademy.prog.comm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Communicator {

  private List<Channel> channels = new ArrayList<>();

  public List<Channel> getAllPublicChannels() {
    return channels.stream()
        .filter(channel -> !channel.isPrivate())
        .collect(Collectors.toList());
  }

  public void addChannel(final Channel channel) {
    if (channels.stream().noneMatch(ch -> ch.getName().equals(channel.getName()))) {
      channels.add(channel);
    }
  }
}
