package com.letmedie.snakeGame.gameLogic;

import com.letmedie.snakeGame.GameObjects.GameFacade;
import com.letmedie.snakeGame.common.SnakeDirection;

public class SnakeGameLogic implements GameLogic {
    GameFacade gameFacade;
    public boolean gameActive;

    public SnakeGameLogic(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
        this.gameActive=false;
    }

    @Override
    public void startGame(){
        gameFacade.setInitialPositionApple();
        this.gameActive=true;
    }

    @Override
    public void moveSnake(){
        if(!gameActive) return;

        gameFacade.moveSnake();

        if(!gameFacade.isAliveSnake()) {
            gameActive=false;
            return;
        }

        if(gameFacade.snakeEatApple()) {
            gameFacade.relocateApple();
            gameFacade.addPointScore();
        }
    }

    @Override
    public void  changeDirection(SnakeDirection snakeDirection){
        gameFacade.changeDirectionSnake(snakeDirection);
    }

    @Override
    public boolean isGameActive() {
        return gameActive;
    }
}
