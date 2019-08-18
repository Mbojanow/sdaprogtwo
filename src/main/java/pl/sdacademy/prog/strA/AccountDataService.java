package pl.sdacademy.prog.strA;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AccountDataService {

    private static final String SEPARATOR = ",";
    private static final int MINIMUM_DATA_LEN = 3;
    private static final int COUNTRY_INDEX = 0;
    private static final int CURRENCY_FULL_NAME_INDEX = 1;
    private static final int CURRENCY_SHORT_NAME_INDEX = 2;
    private static final int AMOUNT_INDEX = 3;
    private static final int REQUIRED_ARGS_NUM = 4;

    public AccountDataService() {
    }

    public List<AccountData> readFromFile(final String path) throws IOException {
        return Files.readAllLines(Paths.get(path)).stream()
                .map(line -> line.split(SEPARATOR))
                .map(this::dataArrayToAccountData)
                .collect(Collectors.toList());
    }

    private AccountData dataArrayToAccountData(final String[] data) {
        if (data.length < MINIMUM_DATA_LEN) {
            throw new AccountDataException("Line does not contain required data");
        }

        return AccountData.builder()
                .country(data[COUNTRY_INDEX])
                .currencyFullName(data[CURRENCY_FULL_NAME_INDEX])
                .currencyShortName(data[CURRENCY_SHORT_NAME_INDEX])
                .amount(getAmount(data))
                .build();
    }

    private Double getAmount(final String[] data) {
        if (data.length >= REQUIRED_ARGS_NUM) {
            return Double.parseDouble(data[AMOUNT_INDEX]);
        }
        return new Random().nextDouble();
    }
}
