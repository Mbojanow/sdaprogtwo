package pl.sdacademy.prog.strA;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountData {
    private String country;
    private String currencyFullName;
    private String currencyShortName;
    private Double amount;
}
