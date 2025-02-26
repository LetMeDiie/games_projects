package game;

import board.Board;
/**
 * Represents a player in the Battleship game.
 */
public class Player {
    private String name;
    private Board board;

    /**
     * Constructs a player with a specified name and board.
     * @param name The name of the player.
     * @param board The board associated with the player.
     */
    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    /**
     * Makes a move in the game by attacking a specific cell on the opponent's board.
     * @param targetX The x-coordinate of the cell to attack.
     * @param targetY The y-coordinate of the cell to attack.
     * @return True if the attack was successful (hit a ship), false otherwise (missed).
     */
    public boolean makeMove(Player player,int targetX, int targetY) {
        if (targetX < 0 || targetX >= board.getBoardLength() || targetY < 0 || targetY >= board.getBoardLength()) {
            System.out.println("Invalid coordinates. Please choose coordinates within the board range.");
            return false;
        }
        boolean hit = player.getBoard().upDateCell(targetX,targetY);
        return hit;
    }
    /**
     * Checks if the player still has ships remaining on their board.
     * @return True if the player has ships remaining, false otherwise.
     */
    public boolean hasShipsRemaining() {
        return board.hasShips();
    }
    /**
     * Retrieves the player's board.
     * @return The board associated with the player.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Retrieves the name of the player.
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }
}
