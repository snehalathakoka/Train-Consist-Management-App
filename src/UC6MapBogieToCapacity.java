import java.util.HashMap;
import java.util.Map;

public class UC6MapBogieToCapacity {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC6 - Map Bogie to Capacity ");
        System.out.println("==========================================\n");


        Map<String, Integer> bogieCapacity = new HashMap<>();


        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);
        bogieCapacity.put("First Class", 24);
        bogieCapacity.put("General", 90);

        System.out.println("Bogie Capacity Mapping:");


        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() + " | Capacity: " + entry.getValue() + " seats");
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}