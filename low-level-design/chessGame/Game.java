package chessGame;

public class Game {

    private Board board;
    private Player white;
    private Player black;
    private Player currentPlayer;

    public Game(Player white, Player black) {
        this.board = new Board();
        this.white = white;
        this.black = black;
        this.currentPlayer = white;
    }

    public boolean makeMove(Move move) {

        Piece piece = board.getPiece(move.getFrom());

        if(piece == null) {
            throw new IllegalStateException("No piece at source position");
        }

        if(piece.getColor() != currentPlayer.getColor()) {
            throw new IllegalStateException("Not your turn");
        }

        if(!piece.isValidMove(board, move.getFrom(), move.getTo())) {
            return false;
        }

        board.setPiece(move.getTo(), piece);
        board.setPiece(move.getFrom(), null);

        switchTurn();
        return true;
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == white) ? black : white;
    }
}