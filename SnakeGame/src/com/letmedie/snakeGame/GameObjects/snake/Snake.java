package com.letmedie.snakeGame.GameObjects.snake;

import com.letmedie.snakeGame.common.Point;
import com.letmedie.snakeGame.common.SnakeDirection;
import com.letmedie.snakeGame.common.GameConstants;

import java.util.LinkedList;

public abstract class Snake {
    private SnakeDirection direction;
    protected boolean isAlive;
    protected LinkedList<Point> body;
    protected Point head;

    public Snake() {
        this.direction = SnakeDirection.RIGHT;
        this.isAlive = true;
        this.body = new LinkedList<>();
        this.head = new Point(GameConstants.fieldWidth / 2, GameConstants.fieldWidth / 2);
    }

    public void move(Point apple) {
        Point newHead = newHeadPoint();
        // Проверка выхода за границы доски
        if (newHead.getX() < 0 || newHead.getX() >= GameConstants.fieldWidth ||
                newHead.getY() < 0 || newHead.getY() >= GameConstants.fieldHeight) {
            headCollisions(); // Обработка выхода за границы
        }
        if(!isAlive)return;
        // Проверка на столкновение с собственным телом
        if (body.contains(newHead)) {
            isAlive = false;
            return; // Выход, если змея мертва
        }
        body.add(head);
        // Обновление позиции головы и тела
        head = newHead; // Обновляем голову змеи
        if (!head.equals(apple)) {
            body.removeFirst(); // Удаление последнего сегмента, если змея не растет
        }
    }


    protected abstract void headCollisions();

    public void setDirection(SnakeDirection newDirection) {
        if ((direction == SnakeDirection.UP && newDirection != SnakeDirection.DOWN) ||
                (direction == SnakeDirection.DOWN && newDirection != SnakeDirection.UP) ||
                (direction == SnakeDirection.LEFT && newDirection != SnakeDirection.RIGHT) ||
                (direction == SnakeDirection.RIGHT && newDirection != SnakeDirection.LEFT)) {
            direction = newDirection;
        }
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public LinkedList<Point> getBody() {
        return body;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Point getHead() {
        return head;
    }

    private Point newHeadPoint() {
        switch (direction) {
            case UP:
                return new Point(head.getX(), head.getY() - 1);
            case DOWN:
                return new Point(head.getX(), head.getY() + 1);
            case LEFT:
                return new Point(head.getX() - 1, head.getY());
            case RIGHT:
                return new Point(head.getX() + 1, head.getY());
            default:
                throw new IllegalArgumentException();
        }
    }
}
