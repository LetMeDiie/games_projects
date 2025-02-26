package board.shipplacment;

import board.Board;
import board.cell.Cell;
import helperclasses.GameConfig;

import java.util.Scanner;
/**
 * This class implements the ShipPlacementLogic interface for manually placing ships by the user.
 */
public class ManualShipPlacement implements ShipPlacementLogic {
    Scanner scanner; // Scanner for reading user input

    /**
     * Constructor initializes a Scanner for reading data from the console.
     */
    public ManualShipPlacement() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Method to place ships on the board manually based on user input.
     * @param board The game board object on which ships are being placed
     */
    @Override
    public void placeShip(Board board) {
        Cell[][] field = board.getBoard(); // Retrieve the game board from the board object

        // Iterate over each ship length and count from GameConfig
        for (int i = 0; i < GameConfig.SHIP_LENGTHS.length; i++) {
            int length = GameConfig.SHIP_LENGTHS[i];
            int count = GameConfig.SHIP_COUNTS[i];

            // Place 'count' number of ships of length 'length'
            for (int j = 0; j < count; j++) {
                boolean placed = false;
                while (!placed) {
                    // Prompt the user to enter starting coordinates of the ship and orientation
                    System.out.println("Enter the starting coordinates of the ship of length " + length + " (format: x y horizontal[true/false]): ");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    boolean horizontal = scanner.nextBoolean();

                    // Attempt to place the ship on the board
                    placed = ShipUtils.getInstance().placeShip(field, x, y, length, horizontal);

                    if (!placed) {
                        System.out.println("Invalid placement, please try again.");
                    }
                }
                board.displayBoard();
            }
        }
        // Close the scanner to release resources
        scanner.close();
    }
}