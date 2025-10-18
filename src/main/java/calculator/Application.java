package calculator;

import calculator.io.Input;
import calculator.io.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator(
                new Input(),
                new Output()
        );
        calculator.calculate();
    }
}
