package helperclasses;

import board.shipplacment.*;

/**
 * Enum representing different strategies for ship placement on the game board.
 */
public enum ShipPlacementType {
    MANUAL(1, "Manual Ship Placement") {
        @Override
        public ShipPlacementLogic createShipPlacementLogic() {
            return new ManualShipPlacement();
        }
    },
    RANDOM(2, "Random Ship Placement") {
        @Override
        public ShipPlacementLogic createShipPlacementLogic() {
            return new RandomShipPlacement();
        }
    };

    private final int id;        // Unique identifier for each ship placement strategy
    private final String name;   // Human-readable name of the ship placement strategy

    /**
     * Constructor for ShipPlacementType enum constants.
     * @param id Unique identifier for the ship placement strategy.
     * @param name Human-readable name of the ship placement strategy.
     */
    ShipPlacementType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Get the unique identifier of the ship placement strategy.
     * @return The ID of the ship placement strategy.
     */
    public int getId() {
        return id;
    }

    /**
     * Get the human-readable name of the ship placement strategy.
     * @return The name of the ship placement strategy.
     */
    public String getName() {
        return name;
    }

    /**
     * Abstract method to create ShipPlacementLogic based on the enum value.
     * Each enum constant overrides this method to provide its specific implementation.
     * @return The corresponding ShipPlacementLogic object for the strategy.
     */
    public abstract ShipPlacementLogic createShipPlacementLogic();
}
