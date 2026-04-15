import java.util.ArrayList;
import java.util.List;

// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// MAIN CLASS
public class UC15SafeCargoAssignment {

    public static void main(String[] args) {

        List<GoodsBogieUC13> train = new ArrayList<>();

        GoodsBogieUC13 b1 = new GoodsBogieUC13("Rectangular", "Coal", 80);
        GoodsBogieUC13 b2 = new GoodsBogieUC13("Cylindrical", "Petroleum", 90);

        train.add(b1);
        train.add(b2);

        // SAFE + UNSAFE OPERATIONS
        assignCargo(b1, "Coal");         // safe
        assignCargo(b1, "Petroleum");    // unsafe
        assignCargo(b2, "Petroleum");    // safe

        System.out.println("\nFinal Train Status:");
        for (GoodsBogieUC13 b : train) {
            System.out.println(b.getType() + " -> " + b.getCargo());
        }

        System.out.println("\nUC15 execution completed safely.");
    }

    // SAFE METHOD USING try-catch-finally
    public static void assignCargo(GoodsBogieUC13 bogie, String cargo) {

        try {
            System.out.println("Assigning " + cargo + " to " + bogie.getType());

            if (bogie.getType().equalsIgnoreCase("Rectangular")
                    && cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe: Petroleum cannot be assigned to Rectangular bogie!"
                );
            }

            System.out.println("Cargo assigned successfully.");

        } catch (CargoSafetyException e) {

            System.out.println("Exception caught: " + e.getMessage());

        } finally {

            System.out.println("Operation completed for " + bogie.getType() + "\n");
        }
    }
}