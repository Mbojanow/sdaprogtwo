package pl.sdacademy.prog.communicator;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
  private String name;
  private String topic;
  private List<User> subscribedUsers;
  private List<Message> messages;
  private boolean isPrivate;

  public void addMessage(final User user, final String messageContent) {
    if (subscribedUsers.contains(user)) {
      final Message message = createMessage(user, messageContent);
      messages.add(message);
      subscribedUsers.forEach(u -> u.handleNewMessage(message, name));
    }
  }

  private Message createMessage(final User user, final String messageContent) {
    return Message.builder()
        .author(user.getUsername())
        .value(messageContent)
        .createDate(LocalDateTime.now())
        .build();
  }

  public void subscribe(final User user) {
    if (!subscribedUsers.contains(user)) {
      subscribedUsers.add(user);
    }
  }

}
