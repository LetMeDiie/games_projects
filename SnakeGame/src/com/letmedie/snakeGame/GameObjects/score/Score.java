package com.letmedie.snakeGame.GameObjects.score;

public class Score {
    private int score;

    public Score() {
        this.score = 0;
    }

    public void addScore(int score){
        if(score>0) {
            this.score+=score;
        }
    }

    public int getScore() {
        return score;
    }
}
