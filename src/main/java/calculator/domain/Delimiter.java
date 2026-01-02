package calculator.domain;

import java.util.List;

public class Delimiter {

    private static final String INIT_DELIMITER = ",:";

    private String delimiter;

    private Delimiter() {
        delimiter = INIT_DELIMITER;
    }

    public static Delimiter newInstance() {
        return new Delimiter();
    }

    public void addDelimiter(String customDelimiter) {
        delimiter += customDelimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public List<String> split(String target) {
        return null;
    }
}
