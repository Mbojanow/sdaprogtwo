package pl.sdacademy.prog.adapter;

import java.util.Set;

public class UserAAdapter implements User {

  private final UserA userA;

  public UserAAdapter(final UserA userA) {
    this.userA = userA;
  }

  @Override
  public String getFirstName() {
    return userA.getFirstName();
  }

  @Override
  public String getLastName() {
    return userA.getLastName();
  }

  @Override
  public int getAge() {
    return Integer.parseInt(userA.getAge());
  }

  @Override
  public Set<String> getRoles() {
    return userA.getRole();
  }
}
