package pl.sdacademy.prog.pl.sdacademy.prog.zad9;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageData {

    @JsonProperty("data")
    private Detections detections;
}
