package pl.sdacademy.prog.communicator;

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
  private String value;
  private LocalDateTime createdAt;
  private String username;

  public String getReadable() {
    return createdAt.toString() + " " + username + "\n" + value;
  }
}
