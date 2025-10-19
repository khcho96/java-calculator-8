package calculator.data;

import java.util.List;
import java.util.stream.Stream;

public class Delimiter {
    private static final String DEFAULT_DELIMITER = ",:";
    private String delimiter;
    private static Delimiter delimiterObj;

    private Delimiter() {
        this.delimiter = DEFAULT_DELIMITER;
    }

    public static Delimiter getInstance() {
        if (delimiterObj == null) {
            delimiterObj = new Delimiter();
        }
        return delimiterObj;
    }

    public void add(String customDelimiter) {
        this.delimiter = DEFAULT_DELIMITER + customDelimiter;
    }

    public Numbers splitAndMapToNumbers(String target) {
        wrap();
        List<Number> numbers = Stream.of(target.split(delimiter))
                .map(Number::new)
                .toList();
        return new Numbers(numbers);
    }

    private void wrap() {
        delimiter = "[" + delimiter + "]";
    }
}
