package board.cell;
//the class is responsible for the basic behavior of all cells on the playing field
//The result of the hit depends on the cell, etc.
public abstract class Cell {
    protected boolean wasAttacked;
    public boolean attackCell(){
        System.out.println(getAttackResult());
        boolean bool = upDateCell();
        return bool;
    }

    protected abstract boolean upDateCell();
    protected abstract String getAttackResult();
    public abstract boolean canPlaceShipNextTo();
    public abstract int getPointOfCell();
}
