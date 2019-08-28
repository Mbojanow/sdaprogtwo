package pl.sdacademy.prog.comm;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

  private LocalDateTime createdAt;
  private String from;
  private String value;

  public String toReadableMessage() {
    final String stringBuilder = from +
        " " +
        createdAt.toString() +
        "\n" +
        value +
        "\n";
    return stringBuilder;
  }
}
