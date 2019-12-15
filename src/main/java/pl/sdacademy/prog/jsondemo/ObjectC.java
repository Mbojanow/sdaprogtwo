package pl.sdacademy.prog.jsondemo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectC {
  private double valueA;
  private double valueB;
  private List<String> strings;
}
