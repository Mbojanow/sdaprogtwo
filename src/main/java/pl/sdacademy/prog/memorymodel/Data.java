package pl.sdacademy.prog.memorymodel;

import lombok.AllArgsConstructor;

@lombok.Data // gettery, settery, equals i hashcode
@AllArgsConstructor
public class Data {
  private String key;
  private String value;
}
