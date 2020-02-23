package pl.sdacademy.prog.adapter;

import java.util.Set;

public interface User {
  String getFirstName();
  String getLastName();
  int getAge();
  Set<String> getRoles();
}
