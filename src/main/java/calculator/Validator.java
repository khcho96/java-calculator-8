package calculator;

import java.util.List;

public class Validator {

    public static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력이 유효하지 않습니다.");
        }
    }

    public static void validateInputFormat(String input) {
        if (!input.strip().matches("^(//.+?\\\\n)?.*")) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        }
    }

    public static void validateNumber(List<String> values) {
        for (String value : values) {
            if (!value.strip().matches("\\d+")) {
                throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
            }
        }
    }
}
