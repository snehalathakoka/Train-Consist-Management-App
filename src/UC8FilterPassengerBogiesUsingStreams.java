import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UC8FilterPassengerBogiesUsingStreams {

    public static void main(String[] args) {

        List<TrainBogie> bogies = new ArrayList<>();

        bogies.add(new TrainBogie("Sleeper", 72));
        bogies.add(new TrainBogie("AC Chair", 56));
        bogies.add(new TrainBogie("First Class", 24));
        bogies.add(new TrainBogie("General", 90));

        List<TrainBogie> filteredBogies = bogies.stream()
                .filter(b -> b.getSeatCapacity() > 60)
                .collect(Collectors.toList());

        filteredBogies.forEach(System.out::println);
    }
}