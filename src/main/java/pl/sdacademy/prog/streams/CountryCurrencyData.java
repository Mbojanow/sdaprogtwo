package pl.sdacademy.prog.streams;

import java.util.concurrent.CountDownLatch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CountryCurrencyData {

  private String country;
  private String currencyFullName;
  private String currencyShortName;
  private Double amount;
}
