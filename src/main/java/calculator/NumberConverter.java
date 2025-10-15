package calculator;

import java.math.BigInteger;
import java.util.List;

public class NumberConverter {

    public static List<BigInteger> convertStringToNumber(List<String> strings) {
        return strings.stream()
                .map(String::strip)
                .map(BigInteger::new)
                .toList();
    }
}
