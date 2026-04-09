import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class UC10TotalSeatsTest {

    // Helper method to simulate the UC10 logic
    private int calculateTotalSeats(List<TrainBogie> bogies) {
        return bogies.stream()
                .map(TrainBogie::getSeatCapacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<TrainBogie> bogies = Arrays.asList(
                new TrainBogie("Sleeper", 72),
                new TrainBogie("AC", 60)
        );
        assertEquals(132, calculateTotalSeats(bogies), "The computed total should equal the sum of all bogie capacities.");
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<TrainBogie> bogies = Arrays.asList(
                new TrainBogie("Sleeper", 72),
                new TrainBogie("General", 90),
                new TrainBogie("AC", 60)
        );
        assertEquals(222, calculateTotalSeats(bogies), "All bogie capacities should contribute to the final total.");
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<TrainBogie> bogies = Collections.singletonList(new TrainBogie("First Class", 24));
        assertEquals(24, calculateTotalSeats(bogies), "Total seating capacity should match the capacity of the single bogie.");
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<TrainBogie> bogies = new ArrayList<>();
        assertEquals(0, calculateTotalSeats(bogies), "Aggregation on an empty list should return the identity value 0.");
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        TrainBogie bogie = new TrainBogie("Sleeper", 72);
        List<TrainBogie> bogies = Collections.singletonList(bogie);
        int total = calculateTotalSeats(bogies);

        assertEquals(bogie.getSeatCapacity(), total, "The capacity used in aggregation must match the bogie data.");
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<TrainBogie> bogies = Arrays.asList(
                new TrainBogie("S1", 10),
                new TrainBogie("S2", 10),
                new TrainBogie("S3", 10)
        );
        assertEquals(30, calculateTotalSeats(bogies), "The total must reflect every single bogie in the collection.");
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainBogie> bogies = new ArrayList<>(Arrays.asList(
                new TrainBogie("Sleeper", 72),
                new TrainBogie("AC", 60)
        ));
        List<TrainBogie> originalCopy = new ArrayList<>(bogies);

        calculateTotalSeats(bogies); // Perform aggregation

        assertEquals(originalCopy.size(), bogies.size(), "Original list size should remain the same.");
        assertEquals(originalCopy, bogies, "Original list contents should remain unchanged.");
    }
}
