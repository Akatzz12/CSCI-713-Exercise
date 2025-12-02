import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    // Tests for checkName method
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
    void testCheckNameWithSingleCharacter() {
        assertTrue(Utils.checkName("A"));
    }

    @Test
    void testCheckNameWithSpaces() {
        assertTrue(Utils.checkName("John Doe"));
    }

    // Tests for isValidAge method
    @Test
    void testIsValidAgeWithPositiveAge() {
        assertTrue(Utils.isValidAge(25));
    }

    @Test
    void testIsValidAgeWithZero() {
        assertTrue(Utils.isValidAge(0));
    }

    @Test
    void testIsValidAgeWithNegativeAge() {
        assertFalse(Utils.isValidAge(-1));
    }

    @Test
    void testIsValidAgeWithLargeNegative() {
        assertFalse(Utils.isValidAge(-100));
    }

    @Test
    void testIsValidAgeWithLargePositive() {
        assertTrue(Utils.isValidAge(150));
    }

    @Test
    void testIsValidAgeWithBoundary() {
        assertTrue(Utils.isValidAge(1));
        assertFalse(Utils.isValidAge(-1));
    }
}

