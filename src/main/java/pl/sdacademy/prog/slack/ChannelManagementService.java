package pl.sdacademy.prog.slack;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChannelManagementService implements ChannelManagement {

  private Communicator communicator;

  public ChannelManagementService(final Communicator communicator) {
    this.communicator = communicator;
  }

  public void removeUserFromChannel(final User user, final String channelName) {
    findChannelByName(channelName)
        .ifPresent(channel -> channel.getUsers().remove(user));
  }

  private Optional<Channel> findChannelByName(final String channelName) {
    return communicator.getChannels().stream()
        .filter(channel -> channel.getName().equalsIgnoreCase(channelName))
        .findFirst();
  }

  public void removeAllMessages(final String channelName) {
    findChannelByName(channelName)
        .ifPresent(channel -> channel.getMessages().clear());
  }

  public void removeChannel(final String channelName) {
    findChannelByName(channelName)
        .ifPresent(channel -> communicator.getChannels().remove(channel));
  }

  public void switchToPublic(final String channelName) {
    switchChannelStatus(channelName, false);
  }

  private void switchChannelStatus(final String channelName, final boolean isPrivate) {
    findChannelByName(channelName)
        .ifPresent(channel -> channel.setPrivate(isPrivate));
  }

  public void switchToPrivate(final String channelName) {
    switchChannelStatus(channelName, true);
  }

  public List<User> getAllUsersOnChannel(final String channelName) {
    final Optional<Channel> optionalChannel = findChannelByName(channelName);
    // samo map na optionalu -> zwraca ciągle optional
    // ALE jak dodamy orElseGet -> map wypakowywuje optional
    // orElseGet daje nam możliwość zwrócenia obiektu jeżeli optional jest pusty
    return optionalChannel
        .map(Channel::getUsers)
        .orElseGet(Collections::emptyList);
//    if (optionalChannel.isPresent()) {
//      return optionalChannel.get().getUsers();
//    }
//    // java11 return List.of();
//    return Collections.emptyList();
  }

  public List<String> getAllMessages(final String channelName) {
    final Optional<Channel> optionalChannel = findChannelByName(channelName);
    if (optionalChannel.isPresent()) {
      return optionalChannel.get().getMessages().stream()
          .map(Message::getReadableMessage)
          .collect(Collectors.toList());
    }
    return Collections.emptyList();
  }
}
