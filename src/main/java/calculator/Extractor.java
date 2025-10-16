package calculator;

import static calculator.Format.*;

public class Extractor {

    public static String extractCustomDelimiter(String input) {
        int beginIndex = input.indexOf(CUSTOM_FORMAT_PREFIX) + CUSTOM_FORMAT_PREFIX.length();
        int endIndex = input.indexOf(CUSTOM_FORMAT_SUFFIX);
        return input.substring(beginIndex, endIndex);
    }

    public static String extractTarget(String input) {
        int beginIndex = input.indexOf(CUSTOM_FORMAT_SUFFIX) + CUSTOM_FORMAT_SUFFIX.length();
        return input.substring(beginIndex);
    }
}
