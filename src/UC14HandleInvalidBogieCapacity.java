import java.util.ArrayList;
import java.util.List;

// Custom Exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie Class
class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {

        if (capacity <= 0) {
            throw new InvalidCapacityException(
                    "Invalid capacity: " + capacity + ". Capacity must be greater than 0."
            );
        }

        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "PassengerBogie{type='" + type + "', capacity=" + capacity + "}";
    }
}

// MAIN CLASS
public class UC14HandleInvalidBogieCapacity {

    public static void main(String[] args) {

        List<PassengerBogie> train = new ArrayList<>();

        try {
            System.out.println("Adding valid bogies...");

            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            PassengerBogie b2 = new PassengerBogie("AC Chair", 50);

            train.add(b1);
            train.add(b2);

            System.out.println("Valid bogies added successfully.");

            System.out.println("\nTrying to add invalid bogie...");

            PassengerBogie b3 = new PassengerBogie("First Class", 0); // invalid
            train.add(b3);

        } catch (InvalidCapacityException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("\nFinal Train Consist:");

        for (PassengerBogie b : train) {
            System.out.println(b);
        }

        System.out.println("\nUC14 execution completed successfully.");
    }
}