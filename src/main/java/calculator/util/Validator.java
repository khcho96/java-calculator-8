package calculator.util;

import static calculator.error.ErrorMessage.INPUT_FORMAT_ERROR;
import static calculator.error.ErrorMessage.INVALID_INPUT_ERROR;
import static calculator.data.Format.NUMBER_FORMAT;
import static calculator.data.Format.VALID_INPUT_FORMAT;

import java.util.List;

public class Validator {

    public static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public static void validateInputFormat(String input) {
        if (!input.strip().matches(VALID_INPUT_FORMAT)) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR);
        }
    }

    public static void validateNumber(List<String> values) {
        for (String value : values) {
            if (!value.strip().matches(NUMBER_FORMAT) || value.strip().equals("0")) {
                throw new IllegalArgumentException(INPUT_FORMAT_ERROR);
            }
        }
    }
}
