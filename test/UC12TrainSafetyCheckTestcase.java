import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class UC12TrainSafetyCheckTest {

    boolean isSafe(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b ->
                !b.getType().equalsIgnoreCase("Cylindrical") ||
                        b.getCargo().equalsIgnoreCase("Petroleum")
        );
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );
        assertTrue(isSafe(bogies));
    }

    @Test
    void testSafety_InvalidCylindrical() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(isSafe(bogies));
    }

    @Test
    void testSafety_EmptyList() {
        List<GoodsBogie> bogies = new ArrayList<>();
        assertTrue(isSafe(bogies));
    }
}