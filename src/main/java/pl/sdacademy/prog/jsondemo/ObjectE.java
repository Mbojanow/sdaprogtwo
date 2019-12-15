package pl.sdacademy.prog.jsondemo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectE {
  private String str;
  private Map<String, String> someMap;
}
