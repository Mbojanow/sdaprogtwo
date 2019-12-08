package pl.sdacademy.prog.communicator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@ToString(exclude = {"users"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class Channel {
  private String name;
  private String topic;
  private List<User> users;
  private List<Message> messages;
  private boolean isPrivate;

  public void sendMessage(final User user, final String messageText) {
    if (!users.contains(user)) {
      log.info("User " + user.getName() + " is not on channel "
          + name + " and message cannot be sent");
      return;
    }

    final Message message = Message.builder()
        .username(user.getName())
        .createdAt(LocalDateTime.now())
        .value(messageText)
        .build();

    messages.add(message);
    users.forEach(subscribedUser -> subscribedUser.handleNewMessage(name, message));
  }

  public void subscribe(final User user) {
    final boolean usernameNotSubscribed = users.stream()
        .noneMatch(subscribedUser -> subscribedUser.getName().equals(user.getName()));
    if (usernameNotSubscribed) {
      users.add(user);
    }
  }

  public List<String> getAllReadableMessages() {
    return messages.stream()
        .map(Message::getReadable)
        .collect(Collectors.toList());
  }
}
