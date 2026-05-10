package snakeFoodGame;

public class Position {

    private int row;
    private int col;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == this){
            return true;
        }

        if (!(obj instanceof Position)){
            return false;
        }

        Position p = (Position) obj;

        return p.getRow() == row && p.getCol() == col;

    }

    @Override
    public int hashCode() {
        return row * 31 + col;
    }

}
