package com.letmedie.snakeGame.GameObjects;

import com.letmedie.snakeGame.GameObjects.apple.*;
import com.letmedie.snakeGame.GameObjects.score.Score;
import com.letmedie.snakeGame.GameObjects.snake.*;
import com.letmedie.snakeGame.common.Point;
import com.letmedie.snakeGame.common.SnakeDirection;

public class GameFacade {
    private Snake snake;
    private Apple apple;
    private Score score;

    private GameData gameData;

    public GameFacade(Snake snake, Apple apple, Score score, GameData gameData) {
        this.snake = snake;
        this.apple = apple;
        this.score = score;
        this.gameData = gameData;
        updateGameData();
    }

    // Snake methods
    public void moveSnake() {
        if (snake != null) {
            snake.move(getPositionApple());
            updateGameData();
        }
    }
    public SnakeDirection direction(){
        return snake.getDirection();
    }

    public void changeDirectionSnake(SnakeDirection snakeDirection) {
        if (snake != null) {
            snake.setDirection(snakeDirection);
        }
    }

    public boolean isAliveSnake() {
        return (snake != null) && snake.isAlive();
    }



    // Apple methods
    public Point getPositionApple() {
        return (apple != null) ? apple.getPosition() : null;
    }

    public void relocateApple() {
        if (apple != null && snake != null) {
            apple.relocate(snake);
            updateGameData();
        }
    }

    public void setInitialPositionApple() {
        if (apple != null && snake != null) {
            apple.setInitialPosition(snake);
            updateGameData();
        }
    }

    public boolean isGrowsSnakeApple() {
        return (apple != null) && apple.growsSnakeFruit();
    }

//Apple and Snake
    public boolean snakeEatApple(){
        Point snakeHead = snake.getHead();
        Point applePoint= apple.getPosition();
        return snakeHead.equals(applePoint);
    }



    // Score methods
    public void addPointScore() {
        if (apple != null && score != null) {
            score.addScore(apple.pointsForFruit());
            updateGameData();
        }
    }

    public int getScore() {
        return (score != null) ? score.getScore() : 0;
    }

    private void updateGameData() {
        gameData.setSnakeHead(snake.getHead());
        gameData.setSnakeBody(snake.getBody());
        gameData.setApplePosition(apple.getPosition());
        gameData.setScore(score.getScore());
        gameData.setSnakeIsAlive(snake.isAlive());
        gameData.notifyObservers();
    }
}
