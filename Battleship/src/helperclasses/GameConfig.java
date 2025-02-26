package helperclasses;

public class GameConfig {
    // Board size
    public static final int BOARD_SIZE = 10;

    // Ship lengths
    public static final int SHIP_LENGTH_FOUR = 4;
    public static final int SHIP_LENGTH_THREE = 3;
    public static final int SHIP_LENGTH_TWO = 2;
    public static final int SHIP_LENGTH_ONE = 1;

    // Number of ships of each type
    public static final int COUNT_SHIP_FOUR = 1;
    public static final int COUNT_SHIP_THREE = 2;
    public static final int COUNT_SHIP_TWO = 3;
    public static final int COUNT_SHIP_ONE = 4;

    // Arrays for convenience
    public static final int[] SHIP_LENGTHS = {
            SHIP_LENGTH_FOUR,
            SHIP_LENGTH_THREE,
            SHIP_LENGTH_TWO,
            SHIP_LENGTH_ONE
    };

    public static final int[] SHIP_COUNTS = {
            COUNT_SHIP_FOUR,
            COUNT_SHIP_THREE,
            COUNT_SHIP_TWO,
            COUNT_SHIP_ONE
    };

    // Total number of ship cells
    public static final int TOTAL_SHIP_CELLS;

    static {
        // Calculate the total number of ship cells
        int total = 0;
        for (int i = 0; i < SHIP_LENGTHS.length; i++) {
            total += SHIP_LENGTHS[i] * SHIP_COUNTS[i];
        }
        TOTAL_SHIP_CELLS = total;
    }
}
