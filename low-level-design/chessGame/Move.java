package chessGame;

public class Move {

    private Position to;
    private Position from;

    public Move(Position to, Position from){
        this.to = to;
        this.from = from;
    }

    public Position getTo() {
        return to;
    }

    public Position getFrom() {
        return from;
    }

}
