package calculator;

import calculator.io.Input;
import calculator.io.Output;
import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input inputObj = new Input();
        Output outputObj = new Output();

        String input = inputObj.readInput();

        BigInteger result = new Calculator().calculate(input);

        outputObj.printResult(result);
    }
}
