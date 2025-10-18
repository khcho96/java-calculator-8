package calculator.data;

public class Format {
    public static final String IS_CUSTOM = "^//.+?\\\\n.*";
    public static final String CUSTOM_FORMAT_PREFIX = "//";
    public static final String CUSTOM_FORMAT_SUFFIX = "\\n";
    public static final String VALID_INPUT_FORMAT = "^(//.+?\\\\n)?.*";
    public static final String NUMBER_FORMAT = "\\d+";

    public static boolean isCustom(String input) {
        return input.strip().matches(IS_CUSTOM);
    }
}
