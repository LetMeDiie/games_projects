package com.letmedie.snakeGame.gameController;

import com.letmedie.snakeGame.gameLogic.GameLogic;
import com.letmedie.snakeGame.gameInterface.GameView;
import javax.swing.*;

public class GameController {
    private final GameLogic gameLogic;
    private final GameView gameView;
    private Timer gameTimer;

    public GameController(GameLogic gameLogic, GameView gameView) {
        this.gameLogic = gameLogic;
        this.gameView = gameView;
        setupInputHandler();
        setupFrame();
        startGame();
    }

    private void setupInputHandler() {
        InputHandler inputHandler = new InputHandler(gameLogic);
        gameView.addKeyListener(inputHandler);
        gameView.setFocusable(true);
    }

    private void startGame() {
        gameLogic.startGame();
        gameTimer = new Timer(200, e -> {
            gameLogic.moveSnake();
            if (!gameLogic.isGameActive()) {
                stopGame();
            }
        });
        gameTimer.start();
    }

    private void stopGame() {
        gameView.setGameOverDisplayed(false);
    }

    private void  setupFrame() {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(gameView);
        frame.pack();
        frame.setVisible(true);
        gameView.setFrame(frame);
    }
}
