package calculator.domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Delimiter {

    private static final String INIT_DELIMITER = "[,:]";

    private String delimiter;

    private Delimiter() {
        delimiter = INIT_DELIMITER;
    }

    public static Delimiter newInstance() {
        return new Delimiter();
    }

    public void addDelimiter(String customDelimiter) {
        delimiter += "|" + Pattern.quote(customDelimiter);
    }

    public List<String> split(String target) {
        return Stream.of(target.split(delimiter))
                .toList();
    }
}
