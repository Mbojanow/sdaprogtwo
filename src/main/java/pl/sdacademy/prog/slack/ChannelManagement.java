package pl.sdacademy.prog.slack;

import java.util.List;

public interface ChannelManagement {

  void removeUserFromChannel(final User user, final String channelName);
  void removeAllMessages(final String channelName);
  void removeChannel(final String channelName);
  void switchToPublic(final String channelName);
  void switchToPrivate(final String channelName);
  List<User> getAllUsersOnChannel(final String channelName);
  List<String> getAllMessages(final String channelName);
}
