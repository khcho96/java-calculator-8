package calculator.util;

import java.math.BigInteger;
import java.util.List;

public class Adder {

    public static BigInteger getSum(List<BigInteger> numbers) {
        return numbers.stream()
                .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
