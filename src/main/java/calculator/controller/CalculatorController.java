package calculator.controller;

import calculator.service.CalculatorService;
import calculator.util.InputParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void run() {
        String rawInput = InputView.readInput();
        String input = InputParser.parseInput(rawInput);

        int sum = calculatorService.calculate(input);

        OutputView.printSum(sum);
    }
}

