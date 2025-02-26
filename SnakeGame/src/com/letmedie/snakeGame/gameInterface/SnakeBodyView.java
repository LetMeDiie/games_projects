package com.letmedie.snakeGame.gameInterface;

import com.letmedie.snakeGame.GameObjects.GameData;
import com.letmedie.snakeGame.common.GameConstants;
import com.letmedie.snakeGame.common.Point;


import java.awt.*;
import java.util.LinkedList;

public class SnakeBodyView implements GameObjectsView{


    @Override
    public void display(GameData gameData,Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        LinkedList<Point> snakeBody = gameData.getSnakeBody();
        for (Point point : snakeBody) {
            graphics.fillRect(point.getX() * GameConstants.CELL_SIZE, point.getY() * GameConstants.CELL_SIZE + GameConstants.PADDING, GameConstants.CELL_SIZE, GameConstants.CELL_SIZE);
        }
    }
}

