package pl.sdacademy.prog.comm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private String email;
  private String displayName;
  private List<Channel> observedChannels;
  private Communicator communicator;

  public void sendMessage(final String message, final String channelName) throws IOException {
    final Optional<Channel> observedChannel = findChannelByName(observedChannels, channelName);
    if (observedChannel.isPresent()) {
      observedChannel.get().sendMessage(this, message);
    } else {
      subscribe(channelName).ifPresent(channel -> channel.sendMessage(this, message));
    }
  }

  private Optional<Channel> findChannelByName(final Collection<Channel> source, final String channelName) {
    return source.stream()
        .filter(channel -> channel.getName().equals(channelName))
        .findFirst();
  }

  public Optional<Channel> subscribe(final String channelName) throws IOException {
    final Optional<Channel> channelByName = findChannelByName(communicator.getAllPublicChannels(), channelName);
    if (!channelByName.isPresent()) {
      return Optional.empty();
    }
    final Channel channel = channelByName.get();
    channel.addUser(this);
    Files.write(Paths.get(getChannelFileNameForUser(channel)), channel.getAllMessages(), StandardOpenOption.CREATE);
    return channelByName;
  }

  private String getChannelFileNameForUser(final Channel channel) {
    return CommunicatorAppConsts.BASE_DIR + "/" + channel.getName() + "_" + displayName;
  }

  public void onMessageSent(final Channel channel, final Message message) {
    try {
      Files.write(Paths.get(getChannelFileNameForUser(channel)), Collections.singletonList(message.toReadableMessage()), StandardOpenOption.APPEND);
    } catch (IOException e) {
      throw new RuntimeException("msg");
    }
  }
}
