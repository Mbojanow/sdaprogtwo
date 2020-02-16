package pl.sdacademy.prog.communicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommunicatorManagementService {

  private final Communicator communicator;

  public CommunicatorManagementService(final Communicator communicator) {
    this.communicator = communicator;
  }

  public void removeUserFromChannel(final User user, final Channel channel) {
    findChannelInCommunicator(channel)
        .ifPresent(ch -> ch.getSubscribedUsers().remove(user));
  }

  private Optional<Channel> findChannelInCommunicator(final Channel channel) {
    return communicator.getChannels().stream()
        .filter(ch -> ch.equals(channel))
        .findFirst();
  }

  public void removeAllMessagesFromChannel(final Channel channel) {
    findChannelInCommunicator(channel)
        .ifPresent(ch -> ch.getMessages().clear());
  }

  public void removeChannel(final Channel channel) {
    communicator.getChannels().remove(channel);
  }

  public void togglePrivateFlag(final Channel channel) {
    findChannelInCommunicator(channel)
        .ifPresent(ch -> ch.setPrivate(!ch.isPrivate()));
  }

  public List<String> getAllUsers(final Channel channel) {
    final Optional<Channel> foundChannel = findChannelInCommunicator(channel);
//    foundChannel.map(value -> value.getSubscribedUsers().stream()
//        .map(User::getUsername)
//        .collect(Collectors.toList())).orElseGet(List::of);
    if (foundChannel.isPresent()) {
      return foundChannel.get().getSubscribedUsers().stream()
          .map(User::getUsername)
          .collect(Collectors.toList());
    }
    return List.of();
  }

  public List<String> getAllMessages(final Channel channel) {
    final Optional<Channel> optionalChannel = findChannelInCommunicator(channel);
    if (optionalChannel.isPresent()) {
      return optionalChannel.get().getMessages().stream()
          .map(Message::asReadable)
          .collect(Collectors.toList());
    }
    return List.of();
  }
}
