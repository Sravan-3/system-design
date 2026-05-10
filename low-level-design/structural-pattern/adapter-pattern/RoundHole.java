public class RoundHole{

    int radius;

    public RoundHole(int radius){
        this.radius = radius;
    }

    public int getRadius(){
        return this.radius;
    }

    public boolean fits(Peg peg){
        return this.radius >= peg.getRadius();
    }
    
}
