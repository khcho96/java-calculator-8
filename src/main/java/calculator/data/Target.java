package calculator.data;

public class Target {
    private final String target;

    public Target(String target) {
        this.target = target;
    }

    public Numbers split() {
        if (target.isBlank()) {
            return null;
        }
        return Delimiter.getInstance().splitAndMapToNumbers(target);
    }
}
