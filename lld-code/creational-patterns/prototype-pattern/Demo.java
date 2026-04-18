public class Demo {
    public static void main(String[] args) {
        Shape s1 = new Circle(6);
        Shape s2 = new Rectangle(1, 3);

        Shape s3 = s2.clone();
        Shape s4 = s3.clone();
        Shape s5 = s1.clone();

        s1.printShape();
        s2.printShape();
        s3.printShape();
        s4.printShape();
        s5.printShape();

    }
}
