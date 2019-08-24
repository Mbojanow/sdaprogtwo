package pl.sdacademy.prog.zadA;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyData {
  private String countryName;
  private String currencyShortName;
  private String currencyFullName;
  private Double amount;
}
