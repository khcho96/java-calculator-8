package calculator;

public class Calculator {
    private InputObj inputObj;
    private OutputObj outputObj;

    public Calculator(InputObj inputObj, OutputObj outputObj) {
        this.inputObj = inputObj;
        this.outputObj = outputObj;
    }

    public void calculate() {
        // TODO: 메인 로직
    }

    public boolean isCustom(String input) {
        return input.strip().matches("^//.+\\\\n.*");
    }
}
