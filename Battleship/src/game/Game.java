package game;

import helperclasses.GameStatus;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents a Battleship game between two players.
 */
public class Game {
    private Player attackingPlayer;
    private Player defendingPlayer;
    private Scanner scanner;

    /**
     * Constructs a Game object with two players.
     *
     * @param attackingPlayer The player who attacks first.
     * @param defendingPlayer The player who defends.
     */
    public Game(Player attackingPlayer, Player defendingPlayer) {
        this.attackingPlayer = attackingPlayer;
        this.defendingPlayer = defendingPlayer;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the Battleship game.
     */
    public void startGame() {
        System.out.println("Welcome to Battleship!");
        GameStatus.getInstance().startGame();
        playGame();
    }

    /**
     * Main game loop where players take turns attacking.
     */
    private void playGame() {
        boolean makeMove = true;
        while (makeMove) {
            System.out.println(attackingPlayer.getName() + "'s turn to attack.");
            System.out.println("Opponent's board:");
            defendingPlayer.getBoard().displayBoard();
            System.out.println("Enter target coordinates (x y): ");
            int targetX = -1;
            int targetY = -1;
            try {
                targetX = scanner.nextInt();
                targetY = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers.");
                scanner.nextLine(); // Clear scanner buffer
                continue; // Retry input
            }

            // Check if coordinates are within valid range
            if (targetX < 0 || targetX >= defendingPlayer.getBoard().getBoardLength() ||
                    targetY < 0 || targetY >= defendingPlayer.getBoard().getBoardLength()) {
                System.out.println("Invalid coordinates. Please enter valid coordinates.");
                continue; // Retry input
            }

            makeMove = attackingPlayer.makeMove(defendingPlayer,targetX, targetY);
            if (!defendingPlayer.hasShipsRemaining()) {
                finishGame();
                return;
            }
            if(!makeMove) {
                swapPlayers();
                makeMove=true;
            }
        }
    }

    /**
     * Finishes the game and declares the winner.
     */
    private void finishGame() {
        System.out.println(attackingPlayer.getName() + " has won the game!");
        System.out.println("Thanks for playing Battleship! Goodbye.");
        scanner.close();
    }

    /**
     * Swaps the attacking and defending players.
     */
    private void swapPlayers() {
        Player temp = attackingPlayer;
        attackingPlayer = defendingPlayer;
        defendingPlayer = temp;

    }
}
