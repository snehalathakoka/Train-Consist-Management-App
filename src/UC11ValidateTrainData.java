import java.util.regex.*;
import java.util.Scanner;

public class UC11ValidateTrainData {

    public static boolean validateTrainID(String trainID) {
        String regex = "TRN-\\d{4}";
        return Pattern.compile(regex).matcher(trainID).matches();
    }

    public static boolean validateCargoCode(String cargoCode) {
        String regex = "PET-[A-Z]{2}";
        return Pattern.compile(regex).matcher(cargoCode).matches();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC11: Train Data Validation ===");

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String tId = sc.nextLine();
        System.out.println("Train ID Valid: " + validateTrainID(tId));

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cCode = sc.nextLine();
        System.out.println("Cargo Code Valid: " + validateCargoCode(cCode));

        sc.close();
    }
}