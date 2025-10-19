package calculator.data;

import static calculator.data.Format.isCustom;
import static calculator.data.Format.isNotValidInputFormat;
import static calculator.error.ErrorMessage.INPUT_FORMAT_ERROR;
import static calculator.error.ErrorMessage.INVALID_INPUT_ERROR;
import static calculator.util.Extractor.extractCustomDelimiter;
import static calculator.util.Extractor.extractTarget;

public class InputParser {
    private final String input;

    public InputParser(String input) {
        this.input = input;
        validateNull(input);
        validateInputFormat(input);
    }

    private static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR.getErrorMessage());
        }
    }

    private static void validateInputFormat(String input) {
        if (isNotValidInputFormat(input)) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR.getErrorMessage());
        }
    }

    public Target getTargetIfCustom() {
        if (isCustom(input)) {
            String customDelimiter = extractCustomDelimiter(input);
            Delimiter.getInstance().add(customDelimiter);

            String target = extractTarget(input);
            return new Target(target);
        }

        return new Target(input);
    }
}
