package calculator;

public class Extractor {

    public static String extractCustomDelimiter(String input) {
        int beginIndex = input.indexOf("//") + 2;
        int endIndex = input.indexOf("\\n");
        return input.substring(beginIndex, endIndex);
    }
}
