import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService service;

    @BeforeEach
    void setUp() {
        service = new StudentService();
    }

    // ===================== addStudent Tests =====================

    @Test
    void testAddStudent() {
        Student s1 = new Student("Alice", 20, 3.5);
        service.addStudent(s1);
        
        // Verify student was added by checking average GPA
        assertEquals(3.5, service.calculateAverageGpa(), 0.001);
    }

    @Test
    void testAddMultipleStudents() {
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.9));
        service.addStudent(new Student("Charlie", 19, 3.2));
        
        // Average of 3.5, 3.9, 3.2 = 10.6 / 3 = 3.533...
        assertEquals(3.533, service.calculateAverageGpa(), 0.01);
    }

    // ===================== getTopStudent Tests =====================

    @Test
    void testGetTopStudentWithMultipleStudents() {
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.9);
        Student s3 = new Student("Charlie", 19, 3.2);

        service.addStudent(s1);
        service.addStudent(s2);
        service.addStudent(s3);

        Student top = service.getTopStudent();
        assertEquals("Bob", top.getName());
        assertEquals(3.9, top.getGpa(), 0.001);
    }

    @Test
    void testGetTopStudentWithEmptyList() {
        // Should return null when no students
        assertNull(service.getTopStudent());
    }

    @Test
    void testGetTopStudentWithSingleStudent() {
        Student s1 = new Student("Alice", 20, 3.5);
        service.addStudent(s1);

        Student top = service.getTopStudent();
        assertEquals("Alice", top.getName());
    }

    @Test
    void testGetTopStudentWithEqualGpas() {
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.5));

        Student top = service.getTopStudent();
        // Should return first one with highest GPA (Alice, since both equal)
        assertNotNull(top);
        assertEquals(3.5, top.getGpa(), 0.001);
    }

    @Test
    void testGetTopStudentWhenFirstHasHighestGpa() {
        service.addStudent(new Student("Alice", 20, 4.0));
        service.addStudent(new Student("Bob", 22, 3.5));
        service.addStudent(new Student("Charlie", 19, 3.2));

        Student top = service.getTopStudent();
        assertEquals("Alice", top.getName());
    }

    @Test
    void testGetTopStudentWhenLastHasHighestGpa() {
        service.addStudent(new Student("Alice", 20, 3.2));
        service.addStudent(new Student("Bob", 22, 3.5));
        service.addStudent(new Student("Charlie", 19, 4.0));

        Student top = service.getTopStudent();
        assertEquals("Charlie", top.getName());
    }

    // ===================== calculateAverageGpa Tests =====================

    @Test
    void testCalculateAverageGpaWithStudents() {
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.5));

        double avg = service.calculateAverageGpa();
        assertEquals(3.5, avg, 0.001);
    }

    @Test
    void testCalculateAverageGpaWithEmptyList() {
        double avg = service.calculateAverageGpa();
        assertEquals(0.0, avg, 0.001);
    }

    @Test
    void testCalculateAverageGpaWithSingleStudent() {
        service.addStudent(new Student("Alice", 20, 3.8));
        assertEquals(3.8, service.calculateAverageGpa(), 0.001);
    }

    @Test
    void testCalculateAverageGpaWithDifferentValues() {
        service.addStudent(new Student("Alice", 20, 4.0));
        service.addStudent(new Student("Bob", 22, 3.0));
        
        // Average of 4.0 and 3.0 = 3.5
        assertEquals(3.5, service.calculateAverageGpa(), 0.001);
    }

    // ===================== removeStudentByName Tests =====================

    @Test
    void testRemoveStudentByNameSuccess() {
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.9));

        boolean removed = service.removeStudentByName("Alice");
        
        assertTrue(removed);
        // Only Bob should remain
        assertEquals(3.9, service.calculateAverageGpa(), 0.001);
    }

    @Test
    void testRemoveStudentByNameNotFound() {
        service.addStudent(new Student("Alice", 20, 3.5));

        boolean removed = service.removeStudentByName("NonExistent");
        
        assertFalse(removed);
        // Alice should still be there
        assertEquals(3.5, service.calculateAverageGpa(), 0.001);
    }

    @Test
    void testRemoveStudentByNameFromEmptyList() {
        boolean removed = service.removeStudentByName("Alice");
        assertFalse(removed);
    }

    @Test
    void testRemoveStudentByNameRemovesCorrectStudent() {
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.9));
        service.addStudent(new Student("Charlie", 19, 3.2));

        service.removeStudentByName("Bob");

        // Average of Alice (3.5) and Charlie (3.2) = 3.35
        assertEquals(3.35, service.calculateAverageGpa(), 0.001);
    }

    @Test
    void testRemoveAllStudents() {
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.9));

        service.removeStudentByName("Alice");
        service.removeStudentByName("Bob");

        assertEquals(0.0, service.calculateAverageGpa(), 0.001);
        assertNull(service.getTopStudent());
    }
}
