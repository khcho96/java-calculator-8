package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Parser {

    private final Delimiter delimiter;
    private final String input;

    private Parser(Delimiter delimiter, String input) {
        this.delimiter = delimiter;
        this.input = input;
    }

    public static Parser from(String input) {
        Delimiter delimiter = Delimiter.newInstance();
        return new Parser(delimiter, input);
    }

    public List<String> parseTarget() {
        String target = input;

        if (isCustom()) {
            String customDelimiter = extractCustomDelimiter(input);
            delimiter.addDelimiter(customDelimiter);
            target = parseInput(input);
        }

        return delimiter.split(target);
    }

    private boolean isCustom() {
        return input.startsWith("/");
    }

    private String extractCustomDelimiter(String input) {
        int beginIndex = input.lastIndexOf("/") + 1;
        int endIndex = input.indexOf("\\") - 1;
        return input.substring(beginIndex, endIndex);
    }

    private String parseInput(String input) {
        int beginIndex = input.indexOf("n") + 1;
        return input.substring(beginIndex);
    }
}
