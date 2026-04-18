package snakeFoodGame;

public class Board {
    
    private int width;
    private int height;

    public Board(int width, int height){
        this.width = width;
        this.height = height;
    }

    public boolean isValid(Position position){
        return position.getRow() >= 0 && position.getRow() < height && position.getCol() >= 0 && position.getCol() < width;
    }

}
