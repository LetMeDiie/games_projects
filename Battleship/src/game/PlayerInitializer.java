package game;
import java.util.Scanner;
import board.Board;
import board.shipplacment.ShipPlacementLogic;
import helperclasses.ShipPlacementType;

/**
 * PlayerInitializer handles the initialization of players in the game,
 * including allowing them to choose their preferred ship placement strategy.
 * It encapsulates the interaction where players select how they want to place their ships.
 */
public class PlayerInitializer {
    private Scanner scanner;

    public PlayerInitializer() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Creates a player with the specified ship placement strategy chosen by the user.
     *
     * @return The created Player object.
     */
    public Player createPlayer() {
        System.out.println("Please enter the name of the player:");
        String name = scanner.nextLine();

        ShipPlacementLogic shipPlacementLogic = null;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Choose your ship placement method:");
            for (ShipPlacementType type : ShipPlacementType.values()) {
                System.out.println(type.getId() + ". " + type.getName());
            }
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                for (ShipPlacementType type : ShipPlacementType.values()) {
                    if (choice == type.getId()) {
                        shipPlacementLogic = type.createShipPlacementLogic();
                        validInput = true;
                        break;
                    }
                }
                if (!validInput) {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        Board board = new Board();
        shipPlacementLogic.placeShip(board);
        Player player = new Player(name, board);
        return player;
    }
}
