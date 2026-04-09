import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class UC8FilterPassengerBogiesTestcases {

    private List<TrainBogie> getSampleBogies() {
        return Arrays.asList(
                new TrainBogie("Sleeper", 72),
                new TrainBogie("AC Chair", 60),
                new TrainBogie("Sleeper", 80),
                new TrainBogie("First Class", 40),
                new TrainBogie("AC Chair", 75)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<TrainBogie> result = getSampleBogies().stream()
                .filter(b -> b.getSeatCapacity() > 70)
                .collect(Collectors.toList());

        assertTrue(result.stream().allMatch(b -> b.getSeatCapacity() > 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<TrainBogie> result = getSampleBogies().stream()
                .filter(b -> b.getSeatCapacity() > 70)
                .collect(Collectors.toList());

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<TrainBogie> bogies = Arrays.asList(
                new TrainBogie("Sleeper", 50),
                new TrainBogie("AC Chair", 60)
        );

        List<TrainBogie> result = bogies.stream()
                .filter(b -> b.getSeatCapacity() > 70)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<TrainBogie> bogies = new ArrayList<>();

        List<TrainBogie> result = bogies.stream()
                .filter(b -> b.getSeatCapacity() > 70)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<TrainBogie> bogies = new ArrayList<>(getSampleBogies());

        bogies.stream()
                .filter(b -> b.getSeatCapacity() > 70)
                .collect(Collectors.toList());

        assertEquals(5, bogies.size());
    }
}