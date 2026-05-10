public class Demo {
    public static void main(String[] args) {

        String[] colors = {"Red", "Green", "Blue"};

        for (int i = 0; i < 6; i++) {
            Shape circle = ShapeFactory.getCircle(colors[i % 3]);
            circle.draw(i * 10, i * 10);
        }
    }
}
