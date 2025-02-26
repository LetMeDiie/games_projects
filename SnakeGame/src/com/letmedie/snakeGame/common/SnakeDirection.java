package com.letmedie.snakeGame.common;

public enum SnakeDirection{
    UP, DOWN, LEFT, RIGHT;

    public static SnakeDirection fromKey(char key) {
        switch (Character.toUpperCase(key)) {
            case 'W':
                return UP;
            case 'S':
                return DOWN;
            case 'A':
                return LEFT;
            case 'D':
                return RIGHT;
            default:
                throw new IllegalArgumentException("Invalid key: " + key);
        }
    }
}
