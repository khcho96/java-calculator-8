package calculator;

import java.util.List;
import java.util.stream.Stream;

public class Delimiter {

    public static final String DEFAULT_DELIMITER = ",:";
    private final String delimiter;

    public Delimiter() {
        this.delimiter = "[" + DEFAULT_DELIMITER + "]";
    }

    public Delimiter(String customDelimiter) {
        this.delimiter = "[" + DEFAULT_DELIMITER + customDelimiter + "]";
    }

    public List<String> split(String target) {
        return Stream.of(target.split(delimiter)).
                filter(s->!s.isBlank()).
                toList();
    }
}
