/** Lab 9 - Basic 1: enum with a switch that prints advice. */
public enum Level {
    LOW, MEDIUM, HIGH;

    public static void main(String[] args) {
        for (Level level : Level.values()) {
            advise(level);
        }
    }

    static void advise(Level level) {
        // Arrow-switch on an enum: no break needed, and the compiler checks all cases are covered
        String advice = switch (level) {
            case LOW    -> "Relax, everything is under control.";
            case MEDIUM -> "Keep an eye on things and plan ahead.";
            case HIGH   -> "Act now - this needs immediate attention!";
        };
        System.out.println(level + " (ordinal " + level.ordinal() + "): " + advice);
    }
}
