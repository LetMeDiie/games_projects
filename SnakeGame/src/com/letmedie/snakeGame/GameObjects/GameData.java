package com.letmedie.snakeGame.GameObjects;

import com.letmedie.snakeGame.common.Observer;
import com.letmedie.snakeGame.common.Point;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameData {
    private Point snakeHead;
    private LinkedList<Point> snakeBody;
    private Point applePosition;
    private int score;
    boolean snakeIsAlive;

    private List<Observer> observers;

    public GameData() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public Point getSnakeHead() {
        return snakeHead;
    }
    public void setSnakeHead(Point snakeHead) {
        this.snakeHead = snakeHead;
        notifyObservers();
    }

    public LinkedList<Point> getSnakeBody() {
        return snakeBody;
    }
    public boolean snakeIsAlive(){
        return  snakeIsAlive;
    }

    public void setSnakeIsAlive(boolean snakeIsAlive) {
        this.snakeIsAlive = snakeIsAlive;
    }
    public void setSnakeBody(LinkedList<Point> snakeBody) {
        this.snakeBody = snakeBody;
        notifyObservers();
    }

    public Point getApplePosition() {
        return applePosition;
    }
    public void setApplePosition(Point applePosition) {
        this.applePosition = applePosition;
        notifyObservers();
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
        notifyObservers();
    }
}
