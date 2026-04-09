import java.util.*;
import java.util.stream.Collectors;

public class UC9GroupBogiesByType {
    public static void main(String[] args) {
        List<TrainBogie> bogies = Arrays.asList(
                new TrainBogie("Sleeper", 72),
                new TrainBogie("AC Chair", 60),
                new TrainBogie("Sleeper", 72),
                new TrainBogie("First Class", 24)
        );

        Map<String, List<TrainBogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(TrainBogie::getName));

        grouped.forEach((type, list) -> System.out.println(type + " -> " + list));
    }
}
