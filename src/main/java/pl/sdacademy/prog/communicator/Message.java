package pl.sdacademy.prog.communicator;

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

  private static final DateTimeFormatter MESSAGE_DATETIME_FORMATTER =
      DateTimeFormatter.ofPattern("d MMM uuuu HH:mm");

  private String value;
  private LocalDateTime createDate;
  private String author;

  public String asReadable() {
    return author + MESSAGE_DATETIME_FORMATTER.format(createDate) + "\n" + value;
  }
}
