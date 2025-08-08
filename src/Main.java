public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 20, "BSIT", 85.0f, 90.0f, 88.0f);
        Student s2 = new Student("Bob", 19, "BSCS", 92.0f, 95.0f, 89.0f);
        Student s3 = new Student("Charlie", 21, "BSIT", 65.0f, 70.0f, 68.0f);

        Student[] students = { s1, s2, s3 };
        int passingCount = 0;

        for (Student stdnts : students) {
            stdnts.displayInfo();
            if (stdnts.isPassing()) {
                passingCount++;
            }
        }

        System.out.println("Summary: " + passingCount + " out of " +
                students.length + " students are passing.");
    }
}
