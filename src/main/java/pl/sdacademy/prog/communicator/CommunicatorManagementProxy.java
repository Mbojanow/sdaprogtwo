package pl.sdacademy.prog.communicator;

import java.util.List;

public class CommunicatorManagementProxy implements CommunicatorService {

  private CommunicatorService communicatorService;
  private Communicator communicator;
  private User managingUser;

  public CommunicatorManagementProxy(final CommunicatorService communicatorService, final Communicator communicator, final User managingUser) {
    this.communicatorService = communicatorService;
    this.communicator = communicator;
    this.managingUser = managingUser;
  }

  @Override
  public void removeUserFromChannel(final User user, final Channel channel) {
    if (hasAccessType(AccessType.WRITE)) {
      communicatorService.removeUserFromChannel(user, channel);
    }
  }

  private boolean hasAccessType(final AccessType accessType) {
    return managingUser.getRole().getAccessTypes().contains(accessType);
  }

  @Override
  public void removeAllMessagesFromChannel(final Channel channel) {
    if (hasAccessType(AccessType.WRITE)) {
      communicatorService.removeAllMessagesFromChannel(channel);
    }
  }

  @Override
  public void removeChannel(final Channel channel) {
    if (hasAccessType(AccessType.WRITE)) {
      communicatorService.removeChannel(channel);
    }
  }

  @Override
  public void togglePrivateFlag(final Channel channel) {
    if (hasAccessType(AccessType.WRITE)) {
      communicatorService.togglePrivateFlag(channel);
    }
  }

  @Override
  public List<String> getAllUsers(final Channel channel) {
    if (hasAccessType(AccessType.READ)) {
      return communicatorService.getAllUsers(channel);
    }
    return List.of();
  }

  @Override
  public List<String> getAllMessages(final Channel channel) {
    if (hasAccessType(AccessType.READ)) {
      return communicatorService.getAllMessages(channel);
    }
    return List.of();
  }
}
