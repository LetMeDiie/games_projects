package com.letmedie.snakeGame.common;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }

        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public String toString() {
        return getX()+" "+getY();
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}
