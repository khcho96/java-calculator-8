package calculator;

public class Delimiter {
    private static final String DEFAULT_DELIMITER = ",:";
    private String delimiter;

    public Delimiter() {
        this.delimiter = DEFAULT_DELIMITER;
    }

    public void add(String customDelimiter) {
        this.delimiter = DEFAULT_DELIMITER + customDelimiter;
    }
}
