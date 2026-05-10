package chessGame;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col){
        if (row < 0 || row > 8 || col < 0 || col > 8){
            throw new IllegalArgumentException("Invaild board position");
        }

        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
