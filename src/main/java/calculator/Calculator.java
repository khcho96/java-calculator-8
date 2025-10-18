package calculator;

import calculator.data.Numbers;
import calculator.data.InputParser;
import calculator.data.Target;
import java.math.BigInteger;

public class Calculator {

    public BigInteger calculate(String input) {
        // 입력 문자열이 커스텀 문자열이면 타겟 문자열을 추출한다.
        Target target = new InputParser(input).getTargetIfCustom();

        // 타겟 문자열을 구분자로 분리한다.
        Numbers numbers = target.split();

        // 양수 값들을 모두 더해 결과를 산출한다.
        return numbers.calculateSum();
    }
}
