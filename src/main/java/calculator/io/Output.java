package calculator.io;

import java.math.BigInteger;

public class Output {
    private static final String RESULT_MESSAGE = "결과 : ";

    public void printResult(BigInteger result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
