package board.shipplacment;

import board.cell.Cell;
import board.cell.Ship;
import board.cell.ShipCell;
import helperclasses.GameConfig;
/**
 * Utility class for managing ship placement on a game board.
 * This class provides methods to place ships on a given board,
 * ensuring validity of the placement based on game rules.
 * It employs a singleton pattern to ensure there is only one
 * instance of ShipUtils throughout the application.
 */
public class ShipUtils {

     // Singleton instance of ShipUtils
     private static ShipUtils shipUtils = new ShipUtils();

     /**
      * Returns the singleton instance of ShipUtils.
      * @return Singleton instance of ShipUtils
      */
     public static ShipUtils getInstance() {
          return shipUtils;
     }

     // Private constructor to enforce singleton pattern
     private ShipUtils() {}

     /**
      * Attempts to place a ship on the board starting at the specified coordinates.
      * @param board The game board represented as a 2D array of cells
      * @param x The starting x-coordinate for placing the ship
      * @param y The starting y-coordinate for placing the ship
      * @param length The length of the ship to place
      * @param horizontal Flag indicating whether to place the ship horizontally (true) or vertically (false)
      * @return true if the ship was successfully placed, false otherwise
      */
     public boolean placeShip(Cell[][] board, int x, int y, int length, boolean horizontal) {
          // Check if the placement is valid
          if (!isValidPlacement(board, x, y, length, horizontal)) {
               return false;
          }

          // Create a new Ship object with the specified length
          Ship ship = new Ship(length);

          // Place the ship cells on the board
          if (horizontal) {
               // Place the ship horizontally
               for (int i = 0; i < length; i++) {
                    board[x][y + i] = new ShipCell(ship);
               }
          } else {
               // Place the ship vertically
               for (int i = 0; i < length; i++) {
                    board[x + i][y] = new ShipCell(ship);
               }
          }

          return true;
     }


     /**
      * Checks if a ship can be placed at the specified location without conflicts.
      *
      * @param board The game board, a 2D array of Cell objects.
      * @param x The starting x-coordinate for the ship.
      * @param y The starting y-coordinate for the ship.
      * @param length The length of the ship.
      * @param horizontal True if the ship is to be placed horizontally, false if vertically.
      * @return True if the placement is valid, false otherwise.
      */
     private boolean isValidPlacement(Cell[][] board, int x, int y, int length, boolean horizontal) {
          // Calculate the boundaries for the ship and surrounding cells
          int startX = x - 1;
          int endX = horizontal ? x + 1 : x + length;
          int startY = y - 1;
          int endY = horizontal ? y + length : y + 1;

          // Check for out of bounds placement
          if (horizontal) {
               if (y + length > GameConfig.BOARD_SIZE) return false;
          } else {
               if (x + length > GameConfig.BOARD_SIZE) return false;
          }

          // Check for collisions with other ships and ensure surrounding cells are empty
          for (int i = Math.max(startX, 0); i <= Math.min(endX, GameConfig.BOARD_SIZE-1); i++) {
               for (int j = Math.max(startY, 0); j <= Math.min(endY, GameConfig.BOARD_SIZE-1); j++) {
                    if (!board[i][j].canPlaceShipNextTo()) return false;
               }
          }
          return true;
     }
}
