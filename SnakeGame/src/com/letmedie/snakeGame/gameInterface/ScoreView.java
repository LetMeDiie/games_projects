package com.letmedie.snakeGame.gameInterface;
import com.letmedie.snakeGame.GameObjects.GameData;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ScoreView implements GameObjectsView {
    public void display(GameData gameData,Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + gameData.getScore(), 10, 30);
    }
}
