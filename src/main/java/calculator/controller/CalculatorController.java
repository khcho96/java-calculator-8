package calculator.controller;

import calculator.service.CalculatorService;
import calculator.util.InputParser;
import calculator.view.InputView;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void run() {
        String rawInput = InputView.readInput();
        String input = InputParser.parseInput(rawInput);
    }
}

