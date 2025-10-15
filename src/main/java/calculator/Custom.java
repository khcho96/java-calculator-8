package calculator;

public class Custom {

    public static boolean isCustom(String input) {
        return input.strip().matches("^//.+?\\\\n.*");
    }
}
