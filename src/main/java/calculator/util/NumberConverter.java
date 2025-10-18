package calculator.util;

import java.math.BigInteger;

public class NumberConverter {

    public static BigInteger convertStringToNumber(String value) {
        return new BigInteger(value.strip());
    }
}
