import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Constructor;

class UtilsTest {

    // Tests for checkName method - covering all branches
    @Test
    void testCheckNameWithValidName() {
        assertTrue(Utils.checkName("Alice"));
    }

    @Test
    void testCheckNameWithNull() {
        // Tests: name != null (false) -> short-circuit -> return false
        assertFalse(Utils.checkName(null));
    }

    @Test
    void testCheckNameWithEmptyString() {
        // Tests: name != null (true) && name.length() > 0 (false) -> return false
        assertFalse(Utils.checkName(""));
    }

    @Test
    void testCheckNameWithSingleCharacter() {
        // Tests: name != null (true) && name.length() > 0 (true) -> return true
        assertTrue(Utils.checkName("A"));
    }

    @Test
    void testCheckNameWithSpaces() {
        assertTrue(Utils.checkName("John Doe"));
    }

    @Test
    void testCheckNameWithWhitespaceOnly() {
        // Whitespace has length > 0, so returns true
        assertTrue(Utils.checkName(" "));
    }

    // Tests for isValidAge method - covering all branches
    @Test
    void testIsValidAgeWithPositiveAge() {
        // Tests: age < 0 (false) -> return true
        assertTrue(Utils.isValidAge(25));
    }

    @Test
    void testIsValidAgeWithZero() {
        // Tests: age < 0 (false) -> return true (boundary)
        assertTrue(Utils.isValidAge(0));
    }

    @Test
    void testIsValidAgeWithNegativeAge() {
        // Tests: age < 0 (true) -> return false
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
    void testIsValidAgeWithMinInteger() {
        // Edge case: minimum integer value
        assertFalse(Utils.isValidAge(Integer.MIN_VALUE));
    }

    @Test
    void testIsValidAgeWithMaxInteger() {
        // Edge case: maximum integer value
        assertTrue(Utils.isValidAge(Integer.MAX_VALUE));
    }

    @Test
    void testCheckNameReturnsTrue() {
        // Explicitly verify true return path
        boolean result = Utils.checkName("Test");
        assertTrue(result);
    }

    @Test
    void testCheckNameReturnsFalse() {
        // Explicitly verify false return path (else branch)
        boolean result = Utils.checkName(null);
        assertFalse(result);
        
        result = Utils.checkName("");
        assertFalse(result);
    }

    @Test
    void testIsValidAgeReturnsTrue() {
        // Explicitly verify true return path (else branch)
        boolean result = Utils.isValidAge(1);
        assertTrue(result);
    }

    @Test
    void testIsValidAgeReturnsFalse() {
        // Explicitly verify false return path
        boolean result = Utils.isValidAge(-1);
        assertFalse(result);
    }

    @Test
    void testPrivateConstructor() throws Exception {
        // Test private constructor for coverage
        Constructor<Utils> constructor = Utils.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Utils utils = constructor.newInstance();
        assertNotNull(utils);
    }
}
