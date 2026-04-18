public class Demo {
    public static void main(String[] args) {

        BigBox b1 = new BigBox();

        SmallBox s1 = new SmallBox();
        MediumBox m1 = new MediumBox();
        Receipt r1 = new Receipt();

        b1.addIteam(s1);
        b1.addIteam(m1);
        b1.addIteam(r1);
    
        Hammer h1 = new Hammer();

        s1.addIteam(h1);

        SmallBox s2 = new SmallBox();
        SmallBox s3 = new SmallBox();

        m1.addIteam(s2);
        m1.addIteam(s3);

        Phone p1 = new Phone();
        Headphones h2 = new Headphones();
        s2.addIteam(p1);
        s2.addIteam(h2);

        Charger c1 = new Charger();
        s3.addIteam(c1);

        System.out.println(b1.getPrice());
    
    }
}
