package pl.sdacademy.prog.communicator;

import java.util.List;

public interface CommunicatorService {

  void removeUserFromChannel(final User user, final Channel channel);

  void removeAllMessagesFromChannel(final Channel channel);

  void removeChannel(final Channel channel);

  void togglePrivateFlag(final Channel channel);

  List<String> getAllUsers(final Channel channel);

  List<String> getAllMessages(final Channel channel);
}
