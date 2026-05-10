package chessGame;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Position from, Position to) {

        int direction = (color == Color.WHITE)? -1 : 1;

        int rowDiff = to.getRow() - from.getRow();
        int colDiff = Math.abs(from.getCol() - to.getCol());

        if(colDiff == 0 && rowDiff == direction){
            return board.getPiece(to) == null;
        }

        if(colDiff == 1 && rowDiff == direction){
            Piece target = board.getPiece(to);
            return target != null && target.getColor() != this.color;
        }

        return false;
    }
}
