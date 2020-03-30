package pl.sdacademy.prog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
  private String firstName;
  private String middleName;
  private String lastName;
  private Integer age;
}
