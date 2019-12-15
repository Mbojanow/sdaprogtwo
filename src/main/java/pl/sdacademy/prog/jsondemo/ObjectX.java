package pl.sdacademy.prog.jsondemo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectX {

  @JsonProperty("str-a")
  private String strA;
  @JsonProperty("val-x")
  private int valX;

  private List<String> strings;

  @JsonIgnore
  public String getSomething() {
    return "randomstr";
  }

  @JsonIgnore
  public boolean isValid() {
    return true;
  }
}
//{"strA":"dsadas","valX":183,"something":"randomstr","valid":true}
