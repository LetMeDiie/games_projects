package board.cell;

import helperclasses.AttackResult;

/**
 * Represents a cell on the game board that does not contain a ship.
 * Extends the abstract class Cell.
 */
public class WaterCell extends Cell {

    /**
     * Gets the result of an attack on this cell.
     * @return The result of the attack as a string.
     */
    @Override
    protected String getAttackResult() {
        AttackResult attackResult = AttackResult.ALREADY_ATTACKED;
        if (!wasAttacked) {
            attackResult = AttackResult.MISS;
        }
        return attackResult.toString();
    }

    @Override
    protected boolean upDateCell() {
        if(wasAttacked)return true;
        wasAttacked=true;
        return false;

    }

    /**
     * Checks if a ship can be placed next to this cell.
     * @return Always returns true since ships can be placed next to water cells.
     */
    @Override
    public boolean canPlaceShipNextTo() {
        return true;
    }

    @Override
    public int getPointOfCell() {
        return -1;
    }

    /**
     * Converts the WaterCell to its string representation.
     * Displays 'X' if the cell has been attacked, indicating a miss.
     * Displays '_' if the cell has not been attacked, hiding details from the opponent.
     * @return String representation of the WaterCell.
     */
    @Override
    public String toString() {
        return wasAttacked ? "X" : "_";
    }
}
