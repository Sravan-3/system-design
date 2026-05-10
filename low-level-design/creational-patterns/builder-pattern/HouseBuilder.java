public class HouseBuilder {

    private int windows;
    private int doors;
    private int plants;
    private boolean garage;
    private boolean swimmingPool;
    private boolean fence;

    // Fluent setters
    public HouseBuilder windows(int windows) {
        this.windows = windows;
        return this;
    }

    public HouseBuilder doors(int doors) {
        this.doors = doors;
        return this;
    }

    public HouseBuilder plants(int plants) {
        this.plants = plants;
        return this;
    }

    public HouseBuilder garage(boolean garage) {
        this.garage = garage;
        return this;
    }

    public HouseBuilder swimmingPool(boolean swimmingPool) {
        this.swimmingPool = swimmingPool;
        return this;
    }

    public HouseBuilder fence(boolean fence) {
        this.fence = fence;
        return this;
    }

    // Build method
    public House build() {
        return new House(this);
    }

    // Getters used by House
    int getWindows() { return windows; }
    int getDoors() { return doors; }
    int getPlants() { return plants; }
    boolean hasGarage() { return garage; }
    boolean hasSwimmingPool() { return swimmingPool; }
    boolean hasFence() { return fence; }
}
