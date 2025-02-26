package game;

import board.Board;

public class Main {
    public static void main(String[] args) {
        PlayerInitializer playerInitializer = new PlayerInitializer();
        Player player1 = playerInitializer.createPlayer();
        Player player2 = playerInitializer.createPlayer();
        Game game = new Game(player1, player2);
        game.startGame();
    }
}