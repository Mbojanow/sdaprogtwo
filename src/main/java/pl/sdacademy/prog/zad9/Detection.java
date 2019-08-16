package pl.sdacademy.prog.zad9;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detection {
    @JsonProperty("language")
    private String language;

    @JsonProperty("isReliable")
    private boolean isReliable;

    @JsonProperty("confidence")
    private Double confidence;
}
