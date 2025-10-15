package calculator;

public class Validator {

    public void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력이 유효하지 않습니다.");
        }
    }
}
