package board.shipplacment;

import board.Board;
import helperclasses.GameConfig;
import java.util.Random;

/**
 * A class that implements ShipPlacementLogic to randomly place ships on the board.
 */
public class RandomShipPlacement implements ShipPlacementLogic {

    /**
     * Method to place ships randomly on the board.
     * @param board The game board object on which ships are to be randomly placed
     */
    @Override
    public void placeShip(Board board) {
        Random random = new Random();

        // Iterate over each ship length and count from GameConfig
        for (int i = 0; i < GameConfig.SHIP_LENGTHS.length; i++) {
            int length = GameConfig.SHIP_LENGTHS[i];
            int count = GameConfig.SHIP_COUNTS[i];

            // Place 'count' number of ships of length 'length'
            for (int j = 0; j < count; j++) {
                boolean placed = false;
                while (!placed) {
                    // Generate random coordinates and orientation
                    int x = random.nextInt(GameConfig.BOARD_SIZE);
                    int y = random.nextInt(GameConfig.BOARD_SIZE);
                    boolean horizontal = random.nextBoolean();

                    // Attempt to place the ship on the board using ShipUtils
                    placed = ShipUtils.getInstance().placeShip(board.getBoard(), x, y, length, horizontal);
                }
            }
        }
        board.displayBoard();
    }
}

