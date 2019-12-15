package pl.sdacademy.prog.jsondemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectD {
  private Float floatValue;
  private int[] ints = new int[]{1, 2, 3};

  public ObjectD(final Float floatValue) {
    this.floatValue = floatValue;
  }
}
