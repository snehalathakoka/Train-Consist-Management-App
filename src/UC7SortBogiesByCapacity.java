import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UC7SortBogiesByCapacity {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator) ");
        System.out.println("==========================================\n");

        List<TrainBogie> bogies = new ArrayList<>();
        bogies.add(new TrainBogie("Sleeper", 72));
        bogies.add(new TrainBogie("AC Chair", 56));
        bogies.add(new TrainBogie("First Class", 24));
        bogies.add(new TrainBogie("General", 90));

        System.out.println("Before Sorting:");
        for (TrainBogie b : bogies) {
            System.out.println(b);
        }

        // FIX: Use getSeatCapacity() instead of .capacity
        bogies.sort(Comparator.comparingInt(TrainBogie::getSeatCapacity));

        System.out.println("\nAfter Sorting by Capacity:");
        for (TrainBogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("\nUC7 sorting completed...");
    }
}

