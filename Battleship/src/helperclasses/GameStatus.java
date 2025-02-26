package helperclasses;

public class GameStatus {
    private static GameStatus instance;
    private boolean gameStarted;
    private GameStatus() {
        this.gameStarted = false;
    }

    public static GameStatus getInstance() {
        if (instance == null) {
            instance = new GameStatus();
        }
        return instance;
    }

    public void startGame() {
        this.gameStarted = true;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }
}
