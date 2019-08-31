package pl.sdacademy.prog.slack;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Channel {

  private String name;
  private String topic;
  private List<User> users;
  private List<Message> messages;
  private boolean isPrivate;

  // ta metoda - observer design pattern. Kanal wie o userach
  public void sendMessage(final User user, final String messageContent) {
    if (users.contains(user)) {
      final Message message = new Message(messageContent, LocalDateTime.now(), user.getDisplayName());
      messages.add(message);
      users.forEach(usr -> usr.onMessageSend(message, this));
    }
  }

  public void addUser(final User user) {
    final boolean userExists = users.stream()
        .anyMatch(usr -> usr.getDisplayName().equalsIgnoreCase(user.getDisplayName()));
    if (!userExists) {
      users.add(user);
    }
  }

  public List<String> getAllMessagesAsString() {
    return messages.stream()
        .map(Message::getReadableMessage)
        .collect(Collectors.toList());
  }
}
