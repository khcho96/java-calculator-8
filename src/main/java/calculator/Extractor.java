package calculator;

public class Extractor {

    public static String extractCustomDelimiter(String input) {
        int beginIndex = input.indexOf("//") + "//".length();
        int endIndex = input.indexOf("\\n");
        return input.substring(beginIndex, endIndex);
    }

    public static String extractTarget(String input) {
        int beginIndex = input.indexOf("\\n") + "\\n".length();
        return input.substring(beginIndex);
    }
}
