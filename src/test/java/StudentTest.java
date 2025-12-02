import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    // ===================== Constructor Tests =====================

    @Test
    void testStudentConstructor() {
        Student student = new Student("Alice", 20, 3.5);
        
        assertEquals("Alice", student.getName());
        assertEquals(20, student.age);
        assertEquals(3.5, student.getGpa(), 0.001);
    }

    // ===================== getName Tests =====================

    @Test
    void testGetName() {
        Student student = new Student("Bob", 22, 3.9);
        assertEquals("Bob", student.getName());
    }

    // ===================== setAge Tests =====================

    @Test
    void testSetAgeWithValidAge() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(25);
        assertEquals(25, student.age);
    }

    @Test
    void testSetAgeWithNegativeAge() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(-5);
        assertEquals(0, student.age);  // Should be set to 0 for negative values
    }

    @Test
    void testSetAgeWithZero() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(0);
        assertEquals(0, student.age);
    }

    // ===================== getGpa and setGpa Tests =====================

    @Test
    void testGetGpa() {
        Student student = new Student("Alice", 20, 3.5);
        assertEquals(3.5, student.getGpa(), 0.001);
    }

    @Test
    void testSetGpa() {
        Student student = new Student("Alice", 20, 3.5);
        student.setGpa(4.0);
        assertEquals(4.0, student.getGpa(), 0.001);
    }

    @Test
    void testSetGpaWithZero() {
        Student student = new Student("Alice", 20, 3.5);
        student.setGpa(0.0);
        assertEquals(0.0, student.getGpa(), 0.001);
    }

    // ===================== printStudentInfo Tests =====================

    @Test
    void testPrintStudentInfo() {
        Student student = new Student("Alice", 20, 3.5);
        // Just verify it doesn't throw an exception
        assertDoesNotThrow(() -> student.printStudentInfo());
    }

    // ===================== Direct Field Access Tests =====================

    @Test
    void testDirectFieldAccess() {
        Student student = new Student("Alice", 20, 3.5);
        
        // Test direct field access (public fields)
        assertEquals("Alice", student.name);
        assertEquals(20, student.age);
        assertEquals(3.5, student.gpa, 0.001);
    }

    @Test
    void testDirectFieldModification() {
        Student student = new Student("Alice", 20, 3.5);
        
        // Test direct field modification
        student.name = "Bob";
        student.age = 25;
        student.gpa = 4.0;
        
        assertEquals("Bob", student.name);
        assertEquals(25, student.age);
        assertEquals(4.0, student.gpa, 0.001);
    }
}

