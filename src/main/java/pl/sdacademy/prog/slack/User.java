package pl.sdacademy.prog.slack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
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
  private List<Channel> subscribedChannels;
  private Communicator communicator;
  private Role role;

  // design patterns - observer
  public void onMessageSend(final Message message, final Channel channel) {
    if (!subscribedChannels.contains(channel)) {
      return;
    }

    try {
      Files.write(createChannelOutputPathForUser(channel),
          /*wczesniej była tu List<String> lub tablica byte[]*/
          Collections.singletonList(message.getReadableMessage()),
          /*StandardOpenOptions implementuje OpenOptions*/
          StandardOpenOption.APPEND);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public Optional<Channel> subscribe(final String channelName) throws IOException {
    final Optional<Channel> optionalChannel = findPublicChannelByName(channelName);
    if (!optionalChannel.isPresent()) {
      return Optional.empty();
    }
    final Channel channel = optionalChannel.get();
    if (!subscribedChannels.contains(channel)) {
      subscribedChannels.add(channel);
      channel.addUser(this);
      saveChannelMessagesToNewFile(channel);
      return optionalChannel;
    }
    return Optional.empty();
  }

  private void saveChannelMessagesToNewFile(final Channel channel) throws IOException {
    Files.write(createChannelOutputPathForUser(channel), channel.getAllMessagesAsString(),
        StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);
  }

  private Path createChannelOutputPathForUser(final Channel channel) {
    return Paths.get(ApplicationConsts.CHANNEL_OUTPUT_PATH + "/" + channel.getName()
        + "_" + displayName + ".txt");
  }

  public void sendMessage(final String messageContent, final String channelName) throws IOException {
    final Optional<Channel> optionalChannel = findPublicChannelByName(channelName);
    optionalChannel.ifPresent(channel -> sendMessage(channel, messageContent));
    subscribe(channelName).ifPresent(channel -> sendMessage(channel, messageContent));
  }

  private void sendMessage(final Channel channel, final String messageContent) {
    channel.sendMessage(this, messageContent);
  }

  private Optional<Channel> findPublicChannelByName(final String channelName) {
    return communicator.getPublicChannels().stream()
        .filter(channel -> channel.getName().equalsIgnoreCase(channelName))
        .findFirst();
  }
}
