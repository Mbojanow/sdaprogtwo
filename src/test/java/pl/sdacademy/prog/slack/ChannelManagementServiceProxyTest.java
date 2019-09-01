package pl.sdacademy.prog.slack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // dla Junit5
// RunWith(MockitoJunitRunner.class - dla Junit4
class ChannelManagementServiceProxyTest {

  @Mock
  private ChannelManagement channelManagement; // = mock(ChannelManagement.class)

  @Mock
  private User user;

  @Mock
  private Role role;

  @InjectMocks
  private ChannelManagementServiceProxy proxy;// = new ChannelManagementServiceProxy(channelManagement, user);

  @Test
  void shouldRemoveUserFromChannelWhenHasWriteAccessType() {
    final User userToRemove = new User();
    final String channelName = "Prog2";
    when(this.user.getRole()).thenReturn(Role.ADMIN);
    doNothing().when(channelManagement).removeUserFromChannel(userToRemove, channelName);

    proxy.removeUserFromChannel(userToRemove, channelName);

    verify(user).getRole();
    verify(channelManagement).removeUserFromChannel(userToRemove, channelName);
  }

  @Test
  void shouldNotRemoveUserFromChannelWhenUserHasNoWriteAccessType() {
    final User userToRemove = new User();
    final String channelName = "Prog2";
    when(this.user.getRole()).thenReturn(Role.USER);

    proxy.removeUserFromChannel(userToRemove, channelName);

    verify(user).getRole();
    verifyZeroInteractions(channelManagement);
  }

  @Test
  void shouldGetAllUsersOnChannelWhenUserHasReadAccessType() {
    final String channelName = "siemaZiom";
    when(user.getRole()).thenReturn(Role.USER);
    final List<User> users = Collections.singletonList(new User());
    // any() zamiast channelName - raczej nie używać
    when(channelManagement.getAllUsersOnChannel(channelName)).thenReturn(users);

    final List<User> allUsersOnChannel = proxy.getAllUsersOnChannel(channelName);

    assertThat(allUsersOnChannel).isEqualTo(users);
    verify(user).getRole();
    verify(channelManagement).getAllUsersOnChannel(channelName);
  }

  @Test
  void shouldGetNoneUsersWhenHasNoReadAccessType() {
    final String channelName = "siemaZiom";
    when(user.getRole()).thenReturn(role);
    // thenReturn(Collections.singletonList(AccessType.WRITE)); - też okej
    when(role.getAccessTypes()).thenReturn(Collections.emptyList());

    final List<User> allUsersOnChannel = proxy.getAllUsersOnChannel(channelName);

    assertThat(allUsersOnChannel).isEmpty();
    verify(user).getRole();
    verify(role).getAccessTypes();
    verifyZeroInteractions(channelManagement);
  }

  // verifyZeroInteractions()
}