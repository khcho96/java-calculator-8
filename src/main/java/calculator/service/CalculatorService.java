package calculator.service;

import calculator.domain.Numbers;
import calculator.domain.Parser;
import java.util.List;

public class CalculatorService {

    public int calculate(String input) {
        Parser parser = Parser.from(input);
        List<String> strings = parser.parseTarget();

        Numbers numbers = Numbers.from(strings);
        return numbers.calculateSum();
    }
}
