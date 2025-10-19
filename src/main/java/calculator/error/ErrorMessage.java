package calculator.error;

public enum ErrorMessage {
    INVALID_INPUT_ERROR("입력이 유효하지 않습니다."),
    INPUT_FORMAT_ERROR("잘못된 형식의 입력입니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
