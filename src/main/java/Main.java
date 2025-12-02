
public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();

        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.9);
        Student s3 = new Student("Charlie", 19, 3.2);

        service.addStudent(s1);
        service.addStudent(s2);
        service.addStudent(s3);

        // Display top student (handles null case)
        Student topStudent = service.getTopStudent();
        if (topStudent != null) {
            System.out.println("Top Student: " + topStudent.getName());
        }

        System.out.println("Average GPA: " + service.calculateAverageGpa());

        // Use removeStudentByName method
        System.out.println("Removing Charlie...");
        boolean removed = service.removeStudentByName("Charlie");
        System.out.println("Charlie removed: " + removed);

        System.out.println("Average GPA after removal: " + service.calculateAverageGpa());
    }
}
