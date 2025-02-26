package com.letmedie.snakeGame.GameObjects.apple;

public class SimpleApple extends Apple {
    @Override
    public boolean growsSnakeFruit() {
        return true;
    }

    @Override
    public int pointsForFruit() {
        return random.nextInt(3)+1;
    }
}
