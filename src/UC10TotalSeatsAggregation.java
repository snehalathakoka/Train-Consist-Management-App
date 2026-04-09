import java.util.*;

public class UC10TotalSeatsAggregation {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC10 - Count Total Seats (reduce) ");
        System.out.println("==========================================\n");

        List<TrainBogie> bogies = Arrays.asList(
                new TrainBogie("Sleeper", 72),
                new TrainBogie("AC Chair", 60),
                new TrainBogie("Sleeper", 72),
                new TrainBogie("First Class", 24),
                new TrainBogie("General", 90)
        );

        // UC10 Logic: Stream -> Map to Int -> Reduce (Sum)
        int totalSeats = bogies.stream()
                .map(TrainBogie::getSeatCapacity) // Extract numeric capacity
                .reduce(0, Integer::sum);         // Aggregate into a single total

        System.out.println("Bogies in Train:");
        bogies.forEach(System.out::println);

        System.out.println("\n------------------------------------------");
        System.out.println("Total Seating Capacity: " + totalSeats);
        System.out.println("------------------------------------------");
    }
}
