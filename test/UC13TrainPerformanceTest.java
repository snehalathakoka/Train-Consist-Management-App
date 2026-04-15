import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class UC13TrainPerformanceTest {

    // helper method to create dataset
    private List<GoodsBogieUC13> createDataset() {
        List<GoodsBogieUC13> bogies = new ArrayList<>();

        bogies.add(new GoodsBogieUC13("Cylindrical", "Petroleum", 80));
        bogies.add(new GoodsBogieUC13("Open", "Coal", 50));
        bogies.add(new GoodsBogieUC13("Cylindrical", "Oil", 90));
        bogies.add(new GoodsBogieUC13("Open", "Grain", 40));

        return bogies;
    }

    // ================= LOOP LOGIC =================
    private List<GoodsBogieUC13> loopFilter(List<GoodsBogieUC13> bogies) {
        List<GoodsBogieUC13> result = new ArrayList<>();

        for (GoodsBogieUC13 b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // ================= STREAM LOGIC =================
    private List<GoodsBogieUC13> streamFilter(List<GoodsBogieUC13> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    // ✅ testLoopFilteringLogic()
    @Test
    public void testLoopFilteringLogic() {
        List<GoodsBogieUC13> bogies = createDataset();

        List<GoodsBogieUC13> result = loopFilter(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    // ✅ testStreamFilteringLogic()
    @Test
    public void testStreamFilteringLogic() {
        List<GoodsBogieUC13> bogies = createDataset();

        List<GoodsBogieUC13> result = streamFilter(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    // ✅ testLoopAndStreamResultsMatch()
    @Test
    public void testLoopAndStreamResultsMatch() {
        List<GoodsBogieUC13> bogies = createDataset();

        List<GoodsBogieUC13> loopResult = loopFilter(bogies);
        List<GoodsBogieUC13> streamResult = streamFilter(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    // ✅ testExecutionTimeMeasurement()
    @Test
    public void testExecutionTimeMeasurement() {
        List<GoodsBogieUC13> bogies = createDataset();

        long start = System.nanoTime();
        loopFilter(bogies);
        long end = System.nanoTime();

        long time = end - start;

        assertTrue(time > 0);
    }

    // ✅ testLargeDatasetProcessing()
    @Test
    public void testLargeDatasetProcessing() {
        List<GoodsBogieUC13> bogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            bogies.add(new GoodsBogieUC13("Cylindrical", "Cargo", i % 100));
        }

        List<GoodsBogieUC13> result = streamFilter(bogies);

        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}