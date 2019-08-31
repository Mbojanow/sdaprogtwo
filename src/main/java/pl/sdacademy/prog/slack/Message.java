package pl.sdacademy.prog.slack;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
  private String content;
  private LocalDateTime createdAt;
  private String author;

  public String getReadableMessage() {
    return createdAt.toString() + " " + author + "\n" + content;
  }
}
