package calculator.data;

import static calculator.data.Format.isCustom;
import static calculator.data.Format.isNotValidInputFormat;
import static calculator.error.ErrorMessage.INPUT_FORMAT_ERROR;
import static calculator.error.ErrorMessage.INVALID_INPUT_ERROR;
import static calculator.util.Extractor.extractCustomDelimiter;
import static calculator.util.Extractor.extractTarget;

/**
 * RawInputValue 보다 좋은 이름 찾고 싶다..!!
 */
public class RawInputValue {
    private final String input;

    public RawInputValue(String input) {
        this.input = input;
        validateNull(input);
        validateInputFormat(input);
    }

    private static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    private static void validateInputFormat(String input) {
        if (isNotValidInputFormat(input)) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR);
        }
    }

    public Target getTargetIfCustom() {
        if (isCustom(input)) {
            // 커스텀 구분자가 지정되었다면 커스텀 구분자를 추출 및 기본 구분자에 추가한다.
            String customDelimiter = extractCustomDelimiter(input);
            Delimiter.getInstance().add(customDelimiter);

            // 타겟 문자열을 추출한다.
            String target = extractTarget(input);
            return new Target(target);
        }

        return new Target(input);
    }
}
