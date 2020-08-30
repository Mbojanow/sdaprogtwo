package pl.sdacademy.prog.currencies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyData {
  private String country;
  private String currencyName;
  private String currencySymbol;
  private Double amount;
}
