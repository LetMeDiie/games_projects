package com.letmedie.snakeGame;

import com.letmedie.snakeGame.GameObjects.GameData;
import com.letmedie.snakeGame.GameObjects.GameFacade;
import com.letmedie.snakeGame.GameObjects.apple.*;
import com.letmedie.snakeGame.GameObjects.score.Score;
import com.letmedie.snakeGame.GameObjects.snake.*;
import com.letmedie.snakeGame.gameController.GameController;
import com.letmedie.snakeGame.gameInterface.*;
import com.letmedie.snakeGame.gameLogic.GameLogic;
import com.letmedie.snakeGame.gameLogic.SnakeGameLogic;

import java.awt.*;

public class main {
    public static void main(String[] args) {
        Snake snake = new StandardSnake();
        Apple apple = new SimpleApple();
        Score score = new Score();

        GameData gameData = new GameData();
        GameFacade gameFacade = new GameFacade(snake, apple, score, gameData);
        GameLogic gameLogic = new SnakeGameLogic(gameFacade);

        GameObjectsView[] gameObjectsView = new GameObjectsView[5];
        gameObjectsView[0] = new GameFieldView();
        gameObjectsView[1] = new AppleView();
        gameObjectsView[2] = new SnakeBodyView();
        gameObjectsView[3] = new SnakeHeadView();
        gameObjectsView[4] = new ScoreView();

        GameView gameView = new GameView(gameData, gameObjectsView);
        gameData.addObserver(gameView);

        GameController gameController = new GameController(gameLogic, gameView);
    }
}


