package com.letmedie.snakeGame.gameInterface;

import com.letmedie.snakeGame.GameObjects.GameData;
import com.letmedie.snakeGame.common.GameConstants;
import com.letmedie.snakeGame.common.Observer;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel implements Observer {
    private GameData gameData;
    private GameObjectsView[] gameObjectsViews;
    private JFrame frame;
    private boolean gameOverDisplayed;

    public GameView(GameData gameData, GameObjectsView[] gameObjectsViews) {
        this.gameData = gameData;
        this.gameObjectsViews = gameObjectsViews;
        this.gameOverDisplayed = false;
        setPreferredSize(new Dimension(
                GameConstants.fieldWidth * GameConstants.CELL_SIZE,
                GameConstants.fieldHeight * GameConstants.CELL_SIZE + GameConstants.PADDING
        ));
    }

    @Override
    public void update() {
        repaint();
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GameObjectsView gameObjectsView : gameObjectsViews) {
            gameObjectsView.display(gameData, g);
        }
        if (!gameData.snakeIsAlive() && !gameOverDisplayed) {
            showGameOverDialog();
            gameOverDisplayed = true;
        }
    }


    public void setGameOverDisplayed(boolean gameOverDisplayed) {
        this.gameOverDisplayed = gameOverDisplayed;
    }

    private void showGameOverDialog() {
        SwingUtilities.invokeLater(() -> new GameOverDialog(gameData.getScore()));
    }
}
