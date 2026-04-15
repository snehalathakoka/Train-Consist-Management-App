import java.util.*;
import java.util.function.Predicate;

class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }
}

public class UC12TrainSafetyCheck {
    public static void main(String[] args) {

        // Create list of goods bogies
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("CyLindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));
        bogies.add(new GoodsBogie("CyLindrical", "Coal")); // Invalid case

        // Print Header
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies\n");

        // Print Bogies
        System.out.println("Goods Bogies in Train:");
        bogies.forEach(b ->
                System.out.println(b.getType() + " -> " + b.getCargo())
        );

        // Safety Rule
        Predicate<GoodsBogie> safetyRule = b ->
                !b.getType().equalsIgnoreCase("Cylindrical") ||
                        b.getCargo().equalsIgnoreCase("Petroleum");

        // Validation using Stream
        boolean isSafe = bogies.stream().allMatch(safetyRule);

        // Print Result
        System.out.println("\nSafety Compliance Status: " + isSafe);

        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        // Completion Message
        System.out.println("\nUC12 safety validation completed ...");
    }
}