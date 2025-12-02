import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    // ===================== checkName Tests =====================

    @Test
    void testCheckNameWithValidName() {
        assertTrue(Utils.checkName("Alice"));
    }

    @Test
    void testCheckNameWithNull() {
        assertFalse(Utils.checkName(null));
    }

    @Test
    void testCheckNameWithEmptyString() {
        assertFalse(Utils.checkName(""));
    }

    @Test
    void testCheckNameWithWhitespace() {
        // Single space is technically a valid non-empty string
        assertTrue(Utils.checkName(" "));
    }

    @Test
    void testCheckNameWithLongName() {
        assertTrue(Utils.checkName("A very long student name with spaces"));
    }

    @Test
    void testCheckNameWithSingleCharacter() {
        assertTrue(Utils.checkName("A"));
    }

    @Test
    void testCheckNameWithNumbers() {
        assertTrue(Utils.checkName("Student123"));
    }

    @Test
    void testCheckNameWithSpecialCharacters() {
        assertTrue(Utils.checkName("O'Connor"));
    }

    // ===================== isValidAge Tests =====================

    @Test
    void testIsValidAgeWithValidAge() {
        assertTrue(Utils.isValidAge(20));
    }

    @Test
    void testIsValidAgeWithZero() {
        assertTrue(Utils.isValidAge(0));
    }

    @Test
    void testIsValidAgeWithNegative() {
        assertFalse(Utils.isValidAge(-1));
    }

    @Test
    void testIsValidAgeWithLargeNegative() {
        assertFalse(Utils.isValidAge(-100));
    }

    @Test
    void testIsValidAgeWithMaxValid() {
        assertTrue(Utils.isValidAge(120));
    }

    @Test
    void testIsValidAgeAboveMax() {
        assertFalse(Utils.isValidAge(121));
    }

    @Test
    void testIsValidAgeWayAboveMax() {
        assertFalse(Utils.isValidAge(200));
    }

    @Test
    void testIsValidAgeWithTypicalStudentAge() {
        assertTrue(Utils.isValidAge(18));
        assertTrue(Utils.isValidAge(22));
        assertTrue(Utils.isValidAge(25));
    }

    @Test
    void testIsValidAgeBoundaryValues() {
        // Test boundary values
        assertFalse(Utils.isValidAge(-1));  // Just below minimum
        assertTrue(Utils.isValidAge(0));     // Minimum valid
        assertTrue(Utils.isValidAge(1));     // Just above minimum
        assertTrue(Utils.isValidAge(119));   // Just below maximum
        assertTrue(Utils.isValidAge(120));   // Maximum valid
        assertFalse(Utils.isValidAge(121));  // Just above maximum
    }
}

