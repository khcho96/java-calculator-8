package calculator;

public class Custom {

    private static boolean isCustom(String input) {
        return input.strip().matches("^//.+?\\\\n.*");
    }
}
