package com.letmedie.snakeGame.gameLogic;

import com.letmedie.snakeGame.common.SnakeDirection;

public interface GameLogic {
    public void moveSnake();
    public void startGame();
    public void changeDirection(SnakeDirection snakeDirection);
    public boolean isGameActive();
}
