package pl.sdacademy.prog.paczka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Pick {
  @JsonProperty("article_name")
  private String articleName;

  @JsonProperty("timestamp")
  private String timestamp;
}
