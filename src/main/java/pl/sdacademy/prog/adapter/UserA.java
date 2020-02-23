package pl.sdacademy.prog.adapter;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserA {
  private String firstName;
  private String lastName;
  private String age;
  private Set<String> role;
}
