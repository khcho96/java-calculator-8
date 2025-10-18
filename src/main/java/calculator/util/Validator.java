package calculator.util;

import static calculator.data.Format.isNotValidInputFormat;
import static calculator.data.Format.isNotValidNumberFormat;
import static calculator.error.ErrorMessage.INPUT_FORMAT_ERROR;
import static calculator.error.ErrorMessage.INVALID_INPUT_ERROR;

import java.util.List;

public class Validator {

    public static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public static void validateInputFormat(String input) {
        if (isNotValidInputFormat(input)) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR);
        }
    }

    public static void validateNumber(List<String> values) {
        for (String value : values) {
            if (isNotValidNumberFormat(value)) {
                throw new IllegalArgumentException(INPUT_FORMAT_ERROR);
            }
        }
    }
}
