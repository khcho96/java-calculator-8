package calculator.data;

import java.math.BigInteger;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public BigInteger calculateSum() {
        return numbers.stream()
                .map(Number::getNumber)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
