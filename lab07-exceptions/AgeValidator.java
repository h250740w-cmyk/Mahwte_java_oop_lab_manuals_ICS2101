public class AgeValidator {
    // 'throws' is mandatory because the exception is checked
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException(age);
        }
        System.out.println("Age " + age + " is valid");
    }

    public static void main(String[] args) {
        int[] tests = {25, 0, 120, -5, 200};
        for (int age : tests) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {      // the compiler FORCES us to handle it
                System.out.println("Rejected: " + e.getMessage());
            }
        }
    }
}
