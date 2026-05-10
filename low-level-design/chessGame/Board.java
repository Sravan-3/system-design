package chessGame;

public class Board {

    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
    }

    public Piece getPiece(Position pos) {
        return board[pos.getRow()][pos.getCol()];
    }

    public void setPiece(Position pos, Piece piece) {
        board[pos.getRow()][pos.getCol()] = piece;
    }

}
