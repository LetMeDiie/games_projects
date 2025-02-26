package helperclasses;

public enum AttackResult {
    MISS("Miss"),
    HIT("Hit"),
    SUNK("Ship sunk"),
    ALREADY_ATTACKED("Already attacked");
    private final String displayName;

    AttackResult(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
