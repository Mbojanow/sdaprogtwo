package pl.sdacademy.prog.adapter;

import java.util.HashSet;
import java.util.Set;

public class UserBAdapter implements User {

  private final UserB userB;

  public UserBAdapter(final UserB userB) {
    this.userB = userB;
  }

  @Override
  public String getFirstName() {
    return userB.getName().split(" ")[0];
  }

  @Override
  public String getLastName() {
    return userB.getName().split(" ")[1];
  }

  @Override
  public int getAge() {
    return Integer.parseInt(userB.getAge().toString());
  }

  @Override
  public Set<String> getRoles() {
    return new HashSet<>(userB.getRoles());
  }
}
