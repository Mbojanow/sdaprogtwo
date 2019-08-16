package pl.sdacademy.prog.zad9;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detections {
    @JsonProperty("detections")
    private List<Detection> detections;
}
