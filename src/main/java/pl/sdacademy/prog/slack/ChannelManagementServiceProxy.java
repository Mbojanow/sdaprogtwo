package pl.sdacademy.prog.slack;

import java.util.Collections;
import java.util.List;

public class ChannelManagementServiceProxy implements ChannelManagement {

  private ChannelManagement channelManagement;
  private User user;

  public ChannelManagementServiceProxy(final ChannelManagement channelManagement, final User user) {
    this.channelManagement = channelManagement;
    this.user = user;
  }

  @Override
  public void removeUserFromChannel(final User user, final String channelName) {
    if (hasAccessType(AccessType.WRITE)) {
      channelManagement.removeUserFromChannel(user, channelName);
    }
  }

  private boolean hasAccessType(final AccessType accessType) {
    return this.user.getRole().getAccessTypes().contains(accessType);
  }

  @Override
  public void removeAllMessages(final String channelName) {
    if (hasAccessType(AccessType.WRITE)) {
      channelManagement.removeAllMessages(channelName);
    }
  }

  @Override
  public void removeChannel(final String channelName) {
    if (hasAccessType(AccessType.WRITE)) {
      channelManagement.removeChannel(channelName);
    }
  }

  @Override
  public void switchToPublic(final String channelName) {
    if (hasAccessType(AccessType.WRITE)) {
      channelManagement.switchToPublic(channelName);
    }
  }

  @Override
  public void switchToPrivate(final String channelName) {
    if (hasAccessType(AccessType.WRITE)) {
      channelManagement.switchToPrivate(channelName);
    }
  }

  @Override
  public List<User> getAllUsersOnChannel(final String channelName) {
    if (hasAccessType(AccessType.READ)) {
      return channelManagement.getAllUsersOnChannel(channelName);
    }
    return Collections.emptyList();
  }

  @Override
  public List<String> getAllMessages(final String channelName) {
    if (hasAccessType(AccessType.READ)) {
      return channelManagement.getAllMessages(channelName);
    }
    return Collections.emptyList();
  }
}
