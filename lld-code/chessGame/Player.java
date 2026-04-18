package chessGame;

public class Player {

    private String name;
    private Color color;

    public Player(String name, Color color){

        this.name = name;
        this.color = color;

    }

    public Color getColor(){
        return color;
    }

    public String getName(){
        return name;
    }
}
