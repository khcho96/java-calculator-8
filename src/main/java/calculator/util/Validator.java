package calculator.util;

import calculator.constant.ErrorMessage;

public final class Validator {

    private static final String FORMAT = "(//[^\\d,:/\\n]\\\\n)?.*";

    private Validator() {}


    public static void validateInputFormat(String input) {
        if (!input.matches(FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }
}
