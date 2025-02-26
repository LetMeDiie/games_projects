package board.shipplacment;

import board.Board;

import java.util.List;
/**
 * Interface defining the contract for ship placement logic on a game board.
 */
public interface ShipPlacementLogic {

    /**
     * Method signature to place ships on the board.
     * @param board The game board object on which ships are to be placed
     */
    void placeShip(Board board);
}