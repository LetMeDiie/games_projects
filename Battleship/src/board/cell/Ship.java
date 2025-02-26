package board.cell;

public class Ship {
    private int size;
    private int hits;

    public Ship(int size) {
        this.size = size;
        this.hits = 0;
    }

    public void hit() {
        hits++;
    }
    public boolean isAliveShip() {
        return hits < size;
    }

    @Override
    public String toString() {
        return "S";
    }
}
