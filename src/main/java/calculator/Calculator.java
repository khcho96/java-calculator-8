package calculator;

import static calculator.Adder.getSum;
import static calculator.Custom.isCustom;
import static calculator.Extractor.*;
import static calculator.NumberConverter.convertStringToNumber;
import static calculator.Validator.*;

import java.math.BigInteger;
import java.util.List;

public class Calculator {
    private final Input inputObj;
    private final Output outputObj;

    public Calculator(Input inputObj, Output outputObj) {
        this.inputObj = inputObj;
        this.outputObj = outputObj;
    }

    public void calculate() {
        // 사용자로부터 입력을 받는다.
        String input = inputObj.readInput();

        // 입력값을 검증한다.
        validateNull(input);
        validateInputFormat(input);

        // 구분자 객체 생성
        Delimiter delimiter = new Delimiter();

        // 커스텀 구분자가 지정되었다면 커스텈 구분자를 추출 및 기본 구분자에 추가한다.
        if (isCustom(input)) {
            String customDelimiter = extractCustomDelimiter(input);
            delimiter.add(customDelimiter);
        }

        // 타겟 문자열을 추출한다.
        String target = extractTarget(input);

        // 타겟 문자열을 구분자로 분리한다.
        List<String> splitValues = delimiter.split(target);

        // 분리한 값들을 검증한다.
        validateNumber(splitValues);

        // 검증한 값들을 양수로 변환한다.
        List<BigInteger> numbers = convertStringToNumber(splitValues);

        // 양수 값들을 모두 더해 결과를 산출한다.
        BigInteger result = getSum(numbers);

        // 결과를 출력한다.
        outputObj.printResult(result);
    }
}
