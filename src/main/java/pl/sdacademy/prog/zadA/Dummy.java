package pl.sdacademy.prog.zadA;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dummy {
  private String name;
  private int age;
  private List<Integer> grades;
}
