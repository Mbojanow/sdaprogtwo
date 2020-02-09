package pl.sdacademy.prog.streams;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dummy {
  private String fieldA;
  private String fieldB;
  private List<Integer> ints;
}
