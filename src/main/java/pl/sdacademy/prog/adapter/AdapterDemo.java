package pl.sdacademy.prog.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AdapterDemo {
  public static void main(String[] args) {
    final List<User> users = new ArrayList<>();

    final UserA userA = new UserA("adnrzej", "nowak", "16", Set.of("ADMIN"));
    final UserB userB = new UserB("Janusz Tracz", 22L, List.of("USER"));

    users.add(new UserAAdapter(userA));
    users.add(new UserBAdapter(userB));

    for (final User user : users) {
      System.out.println(user.getFirstName());
      System.out.println(user.getLastName());
      System.out.println(user.getAge());
      System.out.println(user.getRoles());
    }
  }
}
