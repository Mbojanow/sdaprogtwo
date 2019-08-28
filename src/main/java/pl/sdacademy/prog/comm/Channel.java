package pl.sdacademy.prog.comm;

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

  public void sendMessage(final User user, final String messageValue) {
    if (!users.contains(user)) {
      return;
    }

    final Message message = Message.builder()
        .createdAt(LocalDateTime.now())
        .from(user.getDisplayName())
        .value(messageValue)
        .build();
    messages.add(message);
    users.forEach(usr -> usr.onMessageSent(this, message));
  }

  public List<String> getAllMessages() {
    return messages.stream()
        .map(Message::toReadableMessage)
        .collect(Collectors.toList());
  }

  public void addUser(final User user) {
    if (!users.contains(user)) {
      users.add(user);
    }
  }
}
