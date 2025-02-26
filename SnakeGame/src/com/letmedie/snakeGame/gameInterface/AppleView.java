package com.letmedie.snakeGame.gameInterface;

import com.letmedie.snakeGame.GameObjects.GameData;
import com.letmedie.snakeGame.common.GameConstants;
import com.letmedie.snakeGame.common.Point;

import java.awt.*;

public class AppleView implements GameObjectsView {
    @Override
    public void display(GameData gameData, Graphics graphics) {
        Point point = gameData.getApplePosition();
        graphics.setColor(Color.RED);
        graphics.fillOval(point.getX() * 20, point.getY() * 20 + GameConstants.PADDING, 20, 20);
    }
}
