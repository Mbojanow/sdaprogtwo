package pl.sdacademy.prog.adapter;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserB {
  private String name;
  private Long age;
  private List<String> roles;
}
