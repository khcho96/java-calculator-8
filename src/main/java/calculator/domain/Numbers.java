package calculator.domain;

import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(List<String> strings) {
        List<Number> numbers = strings.stream()
                .map(Number::from)
                .toList();
        return new Numbers(numbers);
    }

    public int calculateSum() {
        int sum = 0;
        for (Number number : numbers) {
            sum = number.addNumber(sum);
        }
        return sum;
    }
}
