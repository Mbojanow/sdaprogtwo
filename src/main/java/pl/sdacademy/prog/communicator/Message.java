package pl.sdacademy.prog.communicator;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    final DateTimeFormatter dateTimeFormatter = DateTimeFormatter
        .ofPattern("dd-MM-yyyy hh:mm");
    return createdAt.format(dateTimeFormatter) + " " + username + "\n" + value;
  }
}
