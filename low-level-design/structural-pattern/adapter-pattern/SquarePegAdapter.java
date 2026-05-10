import java.lang.Math;

public class SquarePegAdapter implements Peg {

    SqaurePeg sqaurePeg;

    public SquarePegAdapter(SqaurePeg sqaurePeg){
        this.sqaurePeg = sqaurePeg;
    }

    @Override
    public int getRadius(){
        return sqaurePeg.getWidth() * (int) Math.sqrt(2.0) / 2;
    }
}
