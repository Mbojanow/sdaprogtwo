package pl.sdacademy.prog.slack;

import java.util.List;

public class ChannelManagementService {

  private Communicator communicator;

  public ChannelManagementService(final Communicator communicator) {
    this.communicator = communicator;
  }

  public void removeUserFromChannel(final User user, final String channelName) {

  }

  public void removeAllMessages(final String channelName) {

  }

  public void removeChannel(final String channelName) {

  }

  public void switchToPublic(final String channelName) {

  }

  public void switchToPrivate(final String channelName) {

  }

  public List<User> getAllUsersOnChannel(final String channelName) {

  }

  public List<String> getAllMessages(final String channelName) {

  }
}
