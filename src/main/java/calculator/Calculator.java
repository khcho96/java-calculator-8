package calculator;

import calculator.data.Numbers;
import calculator.data.InputParser;
import calculator.data.Target;
import java.math.BigInteger;

public class Calculator {

    public BigInteger calculate(String input) {
        InputParser inputParser = new InputParser(input);

        Target target = inputParser.getTargetIfCustom();

        Numbers numbers = target.split();

        if (numbers == null) {
            return BigInteger.ZERO;
        }
        return numbers.calculateSum();
    }
}
