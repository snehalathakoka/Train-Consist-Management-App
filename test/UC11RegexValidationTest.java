import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC11RegexValidationTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(UC11ValidateTrainData.validateTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(UC11ValidateTrainData.validateTrainID("TRAIN12"));
        assertFalse(UC11ValidateTrainData.validateTrainID("TRN12A"));
        assertFalse(UC11ValidateTrainData.validateTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(UC11ValidateTrainData.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UC11ValidateTrainData.validateCargoCode("PET-ab")); // Lowercase
        assertFalse(UC11ValidateTrainData.validateCargoCode("PET123")); // Numbers
        assertFalse(UC11ValidateTrainData.validateCargoCode("AB-PET")); // Wrong order
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UC11ValidateTrainData.validateTrainID("TRN-123"));   // 3 digits
        assertFalse(UC11ValidateTrainData.validateTrainID("TRN-12345")); // 5 digits
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UC11ValidateTrainData.validateCargoCode("PET-A1"));
        assertFalse(UC11ValidateTrainData.validateCargoCode("PET-ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(UC11ValidateTrainData.validateTrainID(""));
        assertFalse(UC11ValidateTrainData.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(UC11ValidateTrainData.validateTrainID("TRN-1234Extra"));
        assertFalse(UC11ValidateTrainData.validateCargoCode("PET-ABC"));
    }
}
