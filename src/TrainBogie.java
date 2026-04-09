public class TrainBogie {
    private String name;
    private int capacity;

    public TrainBogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getSeatCapacity() {
        return capacity;
    }

    public String toString() {
        return name;
    }
}
