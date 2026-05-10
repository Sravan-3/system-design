class Demo{

    public static void main(String[] args) {
        House house = new HouseBuilder().windows(1).build();
        house.print();
    }
}