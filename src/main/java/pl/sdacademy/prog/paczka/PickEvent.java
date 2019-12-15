package pl.sdacademy.prog.paczka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PickEvent {
  @JsonProperty("id")
  private String id;

  @JsonProperty("timestamp")
  private String timestamp;

  @JsonProperty("picker")
  private Picker picker;

  @JsonProperty("article")
  private Article article;

  @JsonProperty("quantity")
  private int quantity;
}
