class Circle implements Shape {
    private final String color; // intrinsic (shared)

    public Circle(String color) {
        this.color = color;
        System.out.println("Creating circle of color: " + color);
    }

    @Override
    public void draw(int x, int y) { // extrinsic
        System.out.println("Drawing " + color + " circle at (" + x + ", " + y + ")");
    }
}
