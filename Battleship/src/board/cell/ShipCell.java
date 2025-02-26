package board.cell;

import helperclasses.AttackResult;
import helperclasses.GameStatus;

/**
 * Represents a cell on the game board that contains a ship.
 * Extends the abstract class Cell.
 */
public class ShipCell extends Cell {
    private Ship ship;           // The ship placed in this cell
    /**
     * Constructs a ShipCell with a specified ship.
     * @param ship The ship to be placed in this cell.
     */
    public ShipCell(Ship ship) {
        this.ship = ship;
    }

    /**
     * Gets the result of an attack on this cell.
     * @return The result of the attack as a string.
     */
    @Override
    protected String getAttackResult() {
        if (wasAttacked) {
            return AttackResult.ALREADY_ATTACKED.toString();
        } else {
            ship.hit();
            if (!ship.isAliveShip()) {
                return AttackResult.SUNK.toString();
            } else {
                return AttackResult.HIT.toString();
            }
        }
    }

    @Override
    protected boolean upDateCell() {
        if(wasAttacked) return true;
        wasAttacked=true;
        return true;
    }

    @Override
    public int getPointOfCell() {
        return 1;
    }

    /**
     * Checks if a ship can be placed next to this cell.
     * @return Always returns false since ships cannot be placed next to each other.
     */
    @Override
    public boolean canPlaceShipNextTo() {
        return false;
    }

    /**
     * Converts the ShipCell to its string representation.
     * Depending on the game status and attack status, displays either the ship or a hiding symbol.
     * @return String representation of the ShipCell.
     */
    @Override
    public String toString() {
        if (GameStatus.getInstance().isGameStarted() && !wasAttacked) {
            return "_"; // Hide ship details if game is started and cell hasn't been attacked
        }
        return ship.toString(); // Show ship details or status if cell has been attacked
    }

}
