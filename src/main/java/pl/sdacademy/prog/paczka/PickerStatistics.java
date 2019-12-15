package pl.sdacademy.prog.paczka;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PickerStatistics {

  @JsonIgnore
  private String pickerId;

  @JsonProperty("picker_name")
  private String name;

  @JsonProperty("active_since")
  private String activeSince;

  @JsonProperty("picks")
  private List<Pick> picks;
}
