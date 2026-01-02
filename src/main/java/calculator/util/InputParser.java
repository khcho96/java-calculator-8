package calculator.util;

public final class InputParser {

    private InputParser() {
    }

    public static String parseInput(String rawInput) {
        rawInput = rawInput.strip();

        Validator.validateInputFormat(rawInput);

        return rawInput;
    }
}
