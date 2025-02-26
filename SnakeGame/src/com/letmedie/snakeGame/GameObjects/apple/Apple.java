package com.letmedie.snakeGame.GameObjects.apple;

import com.letmedie.snakeGame.GameObjects.snake.Snake;
import com.letmedie.snakeGame.common.GameConstants;
import com.letmedie.snakeGame.common.Point;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Apple {
    private Point position;
    protected Random random;

    public Apple() {
        this.random = new Random();

    }

    public Point getPosition() {
        return position;
    }

    public void relocate(Snake snake) {
        this.position = generateNewPosition(snake);
    }

    public void setInitialPosition(Snake snake) {
        this.position = generateNewPosition(snake);
    }

    public abstract boolean growsSnakeFruit();

    public abstract int pointsForFruit();

    private Point generateNewPosition(Snake snake) {
        LinkedList<Point> snakeBody = snake.getBody();
        Point snakeHead = snake.getHead();
        List<Point> possiblePositions = new ArrayList<>();

        for (int x = 0; x < GameConstants.fieldWidth; x++) {
            for (int y = 0; y < GameConstants.fieldHeight; y++) {
                Point point = new Point(x, y);
                if (!snakeBody.contains(point) && !point.equals(snakeHead)) {
                    possiblePositions.add(point);
                }
            }
        }

        if (!possiblePositions.isEmpty()) {
            return possiblePositions.get(random.nextInt(possiblePositions.size()));
        } else {
            throw new IllegalStateException("Нет доступных позиций для нового яблока.");
        }
    }
}