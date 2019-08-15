package pl.sdacademy.prog.zad6;

public class TestDataLineValidator {

    private static final int EXPECTED_SPLIT_DATA_LEN = 2;
    static final int VALUE_INDEX = 1;
    static final int NAME_INDEX = 0;

    public boolean validate(final String line, final String separator) {
        final String[] splitLineData = line.split(separator);
        if (splitLineData.length != EXPECTED_SPLIT_DATA_LEN) {
            return false;
        }

        try {
            Long.valueOf(splitLineData[VALUE_INDEX]);
        } catch (final NumberFormatException exp) {
            return false;
        }
        return true;
    }
}
