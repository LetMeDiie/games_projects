package board;

import board.cell.Cell;
import board.cell.WaterCell;
import board.shipplacment.ShipPlacementLogic;
import helperclasses.GameConfig;

/**
 * Represents the game board where cells are managed.
 * The board controls the state and actions of individual cells,
 */
public class Board {
     private Cell[][] board;         // 2D array to hold cells representing the board
     private int boardLength = GameConfig.BOARD_SIZE;  // Length of one side of the square board
     private int remainingShips = GameConfig.TOTAL_SHIP_CELLS;  // Total number of ship cells initially

     /**
      * Constructor to initialize the board with empty water cells.
      * Populates the board with WaterCell objects.
      */
     public Board() {
          board = new Cell[boardLength][boardLength]; // Initialize the board array correctly
          // Populate the board with new WaterCell objects
          for (int i = 0; i < boardLength; i++) {
               for (int j = 0; j < boardLength; j++) {
                    board[i][j] = new WaterCell();
               }
          }
     }

     /**
      * Displays the current state of the board in the console.
      * Each cell is represented by its toString() output.
      */
     public void displayBoard() {
          for (int i = 0; i < boardLength; i++) {
               for (int j = 0; j < boardLength; j++) {
                    System.out.print("|" + board[i][j].toString());
               }
               System.out.println("|"); // End of each row
          }
     }

     /**
      * Attacks the cell at the specified coordinates and updates the board state.
      * Decrements the remaining ship count if the attack hits a ship cell.
      * @param x The x-coordinate of the cell to attack.
      * @param y The y-coordinate of the cell to attack.
      * @return true if the attack hits a ship cell, false otherwise.
      */
     public boolean upDateCell(int x, int y) {
          boolean hit = board[x][y].attackCell(); // Attack the cell and check if it's a hit
          if (hit) {
               remainingShips-=board[x][y].getPointOfCell();
               // if cell has ship -1
               // else - 0
          }
          return hit; // Return true if the attack hit a  cell, false otherwise
     }

     /**
      * Checks if there are remaining ship cells on the board.
      * @return true if there are remaining ship cells, false otherwise.
      */
     public boolean hasShips() {
          return remainingShips > 0;
     }

     /**
      * Getter for retrieving the current state of the board.
      * @return The 2D array of cells representing the board.
      */
     public Cell[][] getBoard() {
          return board;
     }

     public int getBoardLength() {
          return boardLength;
     }
}