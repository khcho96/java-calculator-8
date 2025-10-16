package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Input {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String readInput() {
        System.out.println(INPUT_MESSAGE);
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
