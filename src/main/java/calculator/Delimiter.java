package calculator;

import java.util.List;
import java.util.stream.Stream;

public class Delimiter {
    private static final String DEFAULT_DELIMITER = ",:";
    private String delimiter;

    public Delimiter() {
        this.delimiter = DEFAULT_DELIMITER;
    }

    public void add(String customDelimiter) {
        this.delimiter = DEFAULT_DELIMITER + customDelimiter;
    }

    public List<String> split(String input) {
        wrap();
        return Stream.of(input.split(delimiter))
                .filter(s -> !s.isBlank())
                .toList();
    }

    private void wrap() {
        delimiter = "[" + delimiter + "]";
    }
}
