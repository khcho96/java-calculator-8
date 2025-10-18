package calculator.util;

import static calculator.data.Format.getCustomDelimiterBeginIndex;
import static calculator.data.Format.getCustomDelimiterEndIndex;
import static calculator.data.Format.getTargetBeginIndex;

public class Extractor {

    public static String extractCustomDelimiter(String input) {
        int beginIndex = getCustomDelimiterBeginIndex(input);
        int endIndex = getCustomDelimiterEndIndex(input);
        return input.substring(beginIndex, endIndex);
    }

    public static String extractTarget(String input) {
        int beginIndex = getTargetBeginIndex(input);
        return input.substring(beginIndex);
    }
}
