public class Demo {
    public static void main(String[] args) {

        RoundHole roundHole = new RoundHole(5);

        Peg roundPeg = new RoundPeg(3);
        Peg sqaurePeg = new SquarePegAdapter(new SqaurePeg(5));

        System.out.println(roundHole.fits(roundPeg));
        System.out.println(roundHole.fits(sqaurePeg));
    }
}