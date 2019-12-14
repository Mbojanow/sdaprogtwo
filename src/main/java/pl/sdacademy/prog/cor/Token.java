package pl.sdacademy.prog.cor;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Token {
  private String name;
  private UUID value;
  private LocalDateTime expirationTime;
}
