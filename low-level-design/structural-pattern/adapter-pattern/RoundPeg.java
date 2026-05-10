public class RoundPeg implements Peg{

    int radius;

    public RoundPeg(int radius){
        this.radius = radius;
    }

    @Override
    public int getRadius(){
        return this.radius;
    }
}
