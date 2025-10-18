package calculator;

import calculator.io.Input;
import calculator.io.Output;
import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input inputObj = new Input();
        Output outputObj = new Output();

        // 사용자로부터 입력을 받는다.
        String input = inputObj.readInput();

        // 계산 결과를 얻는다.
        BigInteger result = new Calculator().calculate(input);

        // 결과를 출력한다.
        outputObj.printResult(result);
    }
}
