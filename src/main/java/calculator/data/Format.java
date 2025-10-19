package calculator.data;

public class Format {
    private static final String IS_CUSTOM = "^//.+?\\\\n.*";
    private static final String CUSTOM_FORMAT_PREFIX = "//";
    private static final String CUSTOM_FORMAT_SUFFIX = "\\n";
    private static final String VALID_INPUT_FORMAT = "^(//.+?\\\\n)?((\\d+).*(\\d+))*$";
    private static final String NUMBER_FORMAT = "\\d+";
    private static final String ZERO_FORMAT = "0";

    public static boolean isCustom(String input) {
        return input.strip().matches(IS_CUSTOM);
    }

    public static int getCustomDelimiterBeginIndex(String input) {
        return input.indexOf(CUSTOM_FORMAT_PREFIX) + CUSTOM_FORMAT_PREFIX.length();
    }

    public static int getCustomDelimiterEndIndex(String input) {
        return input.indexOf(CUSTOM_FORMAT_SUFFIX);
    }

    public static int getTargetBeginIndex(String input) {
        return input.indexOf(CUSTOM_FORMAT_SUFFIX) + CUSTOM_FORMAT_SUFFIX.length();
    }

    public static boolean isNotValidInputFormat(String input) {
        return !input.strip().matches(VALID_INPUT_FORMAT);
    }

    public static boolean isNotValidNumberFormat(String value) {
        return !value.strip().matches(NUMBER_FORMAT) || value.strip().equals(ZERO_FORMAT);
    }
}
