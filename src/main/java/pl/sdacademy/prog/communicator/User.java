package pl.sdacademy.prog.communicator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sdacademy.prog.streams.SdaException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private String email;
  private String username;
  private List<Channel> subscribedChannels;
  private Communicator communicator;

  public Optional<Channel> subscribe(final String channelName) {
    final Optional<Channel> optionalChannel = findChannelByName(channelName);
    optionalChannel.ifPresent(channel -> handleChannelSubscription(channel, channelName));
    return optionalChannel;
  }

  private Optional<Channel> findChannelByName(final String channelName) {
    return communicator.getPublicChannels().stream()
        .filter(channel -> channel.getName().equals(channelName))
        .findFirst();
  }

  private void handleChannelSubscription(final Channel channel, final String channelName) {
    subscribedChannels.add(channel);
    channel.subscribe(this);
    final List<String> messages = getChannelMessagesAsReadable(channel);
    saveMessagesToFile(channelName, messages, StandardOpenOption.CREATE);
  }

  private List<String> getChannelMessagesAsReadable(final Channel channel) {
    return channel.getMessages().stream()
        .map(Message::asReadable)
        .collect(Collectors.toList());
  }

  private String getUsersChannelFilePath(final String channelName) {
    return CommunicatorConsts.APP_DATA + "/" + channelName + "_" + username + ".txt";
  }

  private void saveMessagesToFile(final String channelName, final List<String> messages,
                                  final OpenOption openOption) {
    try {
      Files.write(Paths.get(getUsersChannelFilePath(channelName)),
          messages, openOption );
    } catch (IOException e) {
      throw new SdaException("Could not subscribe to channel" + channelName
          + " by user " + username, e);
    }
  }

  public void sendMessage(final String messageContent, final String channelName) {
    final Optional<Channel> optionalChannel = findChannelByName(channelName);
    optionalChannel.ifPresent(channel -> sendMessage(messageContent, channel));
  }

  private void sendMessage(final String messageContent, final Channel channel) {
    if (!subscribedChannels.contains(channel)) {
      subscribe(channel.getName());
    }
    channel.addMessage(this, messageContent);
  }

  public void handleNewMessage(final Message message, final String channelName) {
    saveMessagesToFile(channelName, List.of(message.asReadable()), StandardOpenOption.APPEND);
  }
}
