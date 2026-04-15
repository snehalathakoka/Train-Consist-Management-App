import java.util.*;
import java.util.stream.*;

class GoodsBogieUC13 {
    private String type;
    private String cargo;

    public GoodsBogieUC13(String type, String cargo) {
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

public class UC13TrainPerformanceComparison {
    public static void main(String[] args) {

        List<GoodsBogieUC13> bogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0) {
                bogies.add(new GoodsBogieUC13("Cylindrical", "Petroleum"));
            } else {
                bogies.add(new GoodsBogieUC13("Open", "Coal"));
            }
        }

        long startLoop = System.nanoTime();

        List<GoodsBogieUC13> loopResult = new ArrayList<>();
        for (GoodsBogieUC13 b : bogies) {
            if (b.getType().equalsIgnoreCase("Cylindrical")) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        long startStream = System.nanoTime();

        List<GoodsBogieUC13> streamResult = bogies.stream()
                .filter(b -> b.getType().equalsIgnoreCase("Cylindrical"))
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        System.out.println("UC13 - Performance Comparison (Loops vs Streams)\n");
        System.out.println("Total Bogies: " + bogies.size());

        System.out.println("\nLoop Time: " + loopTime);
        System.out.println("Stream Time: " + streamTime);

        if (loopTime < streamTime) {
            System.out.println("\nLoop is faster.");
        } else {
            System.out.println("\nStream is faster.");
        }
    }
}