package calculator.domain;

import calculator.constant.ErrorMessage;
import calculator.util.NumberConvertor;

public class Number {

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number from(String s) {
        validateNumber(s);
        return new Number(NumberConvertor.convertToNumber(s));
    }

    private static void validateNumber(String s) {
        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }

    public int addNumber(int addNumber) {
        return addNumber + number;
    }
}
