public class Course {
    private String courseName;
    private String[] students = new String[4];
    private int numberOfStudents; // starts at 0

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(String student) {
        // array full, so make a bigger one and copy everyone over
        if (numberOfStudents == students.length) {
            String[] bigger = new String[students.length * 2];
            for (int i = 0; i < numberOfStudents; i++) {
                bigger[i] = students[i];
            }
            students = bigger;
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                // shift the rest one step left to close the gap
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[numberOfStudents - 1] = null;
                numberOfStudents--;
                return;
            }
        }
    }

    // only the enrolled students, no empty slots
    public String[] getStudents() {
        String[] enrolled = new String[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            enrolled[i] = students[i];
        }
        return enrolled;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}
