/** Lab 3 - Basic 1 and 2: private fields, validated setter, derived grade (not stored). */
public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        setName(name);
        setMarks(marks);
    }

    public String getName() { return name; }
    public int getMarks()   { return marks; }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name required");
        }
        this.name = name.trim();
    }

    // Reject anything outside 0..100
    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100, got " + marks);
        }
        this.marks = marks;
    }

    // Computed from marks every time, so it can never get out of sync
    public String getGrade() {
        if (marks >= 70) return "A";
        if (marks >= 60) return "B";
        if (marks >= 50) return "C";
        return "F";
    }

    public static void main(String[] args) {
        Student s = new Student("Neema", 74);
        System.out.println(s.getName() + " marks=" + s.getMarks() + " grade=" + s.getGrade());

        s.setMarks(55);
        System.out.println("After update: grade=" + s.getGrade());

        try {
            s.setMarks(120);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
        System.out.println("Marks still " + s.getMarks());
    }
}
