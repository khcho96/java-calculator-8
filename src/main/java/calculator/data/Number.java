package calculator.data;

import static calculator.data.Format.isNotValidNumberFormat;
import static calculator.error.ErrorMessage.INPUT_FORMAT_ERROR;
import static calculator.util.NumberConverter.convertStringToNumber;

import java.math.BigInteger;

public class Number {
    private final BigInteger number;

    public Number(String value) {
        validateValue(value);
        this.number = convertStringToNumber(value);
    }

    public BigInteger getNumber() {
        return number;
    }

    public static void validateValue(String value) {
        if (isNotValidNumberFormat(value)) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR.getErrorMessage());
        }
    }
}
