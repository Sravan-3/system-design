public class House {

    private final int windows;
    private final int doors;
    private final int plants;
    private final boolean garage;
    private final boolean swimmingPool;
    private final boolean fence;

    
    House(HouseBuilder builder) {
        this.windows = builder.getWindows();
        this.doors = builder.getDoors();
        this.plants = builder.getPlants();
        this.garage = builder.hasGarage();
        this.swimmingPool = builder.hasSwimmingPool();
        this.fence = builder.hasFence();
    }

    public void print() {
        System.out.printf(
            "Windows: %d, Doors: %d, Plants: %d, Garage: %b, Pool: %b, Fence: %b%n",
            windows, doors, plants, garage, swimmingPool, fence
        );
    }
}
