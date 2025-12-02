
public class Utils {

    // Validates that name is not null or empty
    public static boolean checkName(String name) {
        return name != null && !name.isEmpty();
    }

    // Validates age is within reasonable range (0-120)
    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 120;
    }
}
