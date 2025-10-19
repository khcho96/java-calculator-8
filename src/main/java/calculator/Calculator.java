package calculator;

import calculator.data.Numbers;
import calculator.data.InputParser;
import calculator.data.Target;
import java.math.BigInteger;

public class Calculator {

    public BigInteger calculate(String input) {
        Target target = new InputParser(input).getTargetIfCustom();

        Numbers numbers = target.split();

        return numbers.calculateSum();
    }
}
