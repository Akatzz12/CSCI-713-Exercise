import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService service;

    @BeforeEach
    void setUp() {
        service = new StudentService();
    }

    @Test
    void testAddStudent() {
        Student s1 = new Student("Alice", 20, 3.5);
        service.addStudent(s1);
        
        // Verify student was added by checking top student
        assertEquals("Alice", service.getTopStudent().getName());
    }

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
        assertEquals(3.9, top.getGpa());
    }

    @Test
    void testGetTopStudentWithSingleStudent() {
        Student s1 = new Student("Alice", 20, 3.5);
        service.addStudent(s1);

        Student top = service.getTopStudent();
        assertEquals("Alice", top.getName());
    }

    @Test
    void testGetTopStudentWithEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            service.getTopStudent();
        });
    }

    @Test
    void testGetTopStudentWithEqualGpa() {
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.5);

        service.addStudent(s1);
        service.addStudent(s2);

        Student top = service.getTopStudent();
        // First student with highest GPA should be returned
        assertEquals("Alice", top.getName());
    }

    @Test
    void testCalculateAverageGpaWithMultipleStudents() {
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.5));

        double avg = service.calculateAverageGpa();
        assertEquals(3.5, avg, 0.001);
    }

    @Test
    void testCalculateAverageGpaWithDifferentGpas() {
        service.addStudent(new Student("Alice", 20, 3.0));
        service.addStudent(new Student("Bob", 22, 4.0));

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
        service.addStudent(new Student("Alice", 20, 3.7));

        double avg = service.calculateAverageGpa();
        assertEquals(3.7, avg, 0.001);
    }

    @Test
    void testRemoveStudentByName() {
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.9));
        service.addStudent(new Student("Charlie", 19, 3.2));

        service.removeStudentByName("Bob");

        // After removal, top student should be Alice
        Student top = service.getTopStudent();
        assertEquals("Alice", top.getName());
    }

    @Test
    void testRemoveStudentByNameNotFound() {
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.9));

        // Should not throw exception when name not found
        service.removeStudentByName("Charlie");

        // List should remain unchanged
        assertEquals(3.9, service.getTopStudent().getGpa());
    }

    @Test
    void testRemoveStudentByNameFromEmptyList() {
        // Should not throw exception
        service.removeStudentByName("Alice");
        assertEquals(0.0, service.calculateAverageGpa());
    }

    @Test
    void testRemoveAllStudentsWithSameName() {
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Alice", 22, 3.9));
        service.addStudent(new Student("Bob", 19, 3.2));

        service.removeStudentByName("Alice");

        // Only Bob should remain
        assertEquals("Bob", service.getTopStudent().getName());
        assertEquals(3.2, service.calculateAverageGpa(), 0.001);
    }
}
