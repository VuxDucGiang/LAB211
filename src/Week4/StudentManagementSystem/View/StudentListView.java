package Week4.StudentManagementSystem.View;

import Week4.StudentManagementSystem.Model.Student;
import Week4.StudentManagementSystem.Model.StudentList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StudentListView {

    private StudentList studentList;

    public StudentListView(StudentList studentList) {
        this.studentList = studentList;
    }

    public void createNewStudent() {
        String studentID;
        String studentName;
        String semester;
        String courseName;

        while (true) {
            System.out.println("Enter Student ID: ");
            studentID = DataInput.inputString().trim();
            if (studentList.isStudentIDDulicated(studentID)) {
                System.out.println("Student with this ID is already exists. Please enter another ID.");
            } else {
                break;
            }
        }
        System.out.println("Enter Student Name: ");
        studentName = DataInput.inputString().trim();
        System.out.println("Enter Semester: ");
        semester = DataInput.inputString().trim();
        System.out.println("Enter Course Name: ");
        courseName = DataInput.inputString().trim();

        Student student = new Student(studentID, studentName, semester, courseName);
        studentList.getStudentList().add(student);
        System.out.println("Student Added Successfully");
    }

    public void findAndsort() {
        String[] fAndSoptions = {
            "Find",
            "Sort"
        };
        Menu<String> findAndsortMenu = new Menu<>("Find & Sort Options", fAndSoptions) {
            @Override
            public void execute(int option) {
                switch (option) {
                    case 1 ->
                        findStudent();
                    case 2 ->
                        sortStudent();
                    default ->
                        System.out.println("Invalid option. Exiting search menu.");
                }
            }
        };

        findAndsortMenu.run();
    }

    private void findStudent() {
        System.out.println("Enter the ID of the Student to search: ");
        String studentID = DataInput.inputString().trim();

        boolean found = false;
        for (Student student : studentList.getStudentList()) {
            if (student.getStudentID().equalsIgnoreCase(studentID)) {
                System.out.println(student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The Student with ID '" + studentID + "' not found.");
        }
    }

    private void sortStudent() {
    String[] sortOptions = {
        "Sort by Student ID",
        "Sort by Student Name",
        "Sort by Semester"
    };

    Menu<String> sortMenu = new Menu<>("Sort Options", sortOptions) {
        @Override
        public void execute(int option) {
            switch (option) {
                case 1 -> sortByStudentID();
                case 2 -> sortByStudentName();
                case 3 -> sortBySemester();
                default -> System.out.println("Invalid option. Exiting sort menu.");
            }
        }
    };

    sortMenu.run();
}


private void sortByStudentID() {
    Collections.sort(studentList.getStudentList(), Comparator.comparing(Student::getStudentID));
    System.out.println("Sorted by Student ID:");
    displayStudentList();
}


private void sortByStudentName() {
    Collections.sort(studentList.getStudentList(), Comparator.comparing(Student::getStudentName));
    System.out.println("Sorted by Student Name:");
    displayStudentList();
}

private void sortBySemester() {
    Collections.sort(studentList.getStudentList(), Comparator.comparing(Student::getSemester));
    System.out.println("Sorted by Semester:");
    displayStudentList();
}

private void displayStudentList() {
    for (Student student : studentList.getStudentList()) {
        System.out.println(student);
    }
}

public void updateAndDeleteStudent() {
    System.out.println("Enter the ID of the Student to search: ");
    String studentID = DataInput.inputString().trim();

    for (Student student : studentList.getStudentList()) {
        if (student.getStudentID().equalsIgnoreCase(studentID)) {
            System.out.println(student);

            System.out.println("Do you want to Update (U) or Delete (D) this student? (Press any other key to cancel)");
            String choice = DataInput.inputString().trim().toUpperCase();

            switch (choice) {
                case "U":
                    updateStudent(student);
                    break;
                case "D":
                    deleteStudent(student);
                    break;
                default:
                    System.out.println("Action canceled.");
            }
            return; 
        }
    }
    System.out.println("The Student with ID '" + studentID + "' not found.");
}
private void updateStudent(Student student) {
    System.out.println("Enter new Student Name (press Enter to keep current: " + student.getStudentName() + "): ");
    String newName = DataInput.inputString().trim();
    if (!newName.isEmpty()) {
        student.setStudentName(newName);
    }

    System.out.println("Enter new Semester (press Enter to keep current: " + student.getSemester() + "): ");
    String newSemester = DataInput.inputString().trim();
    if (!newSemester.isEmpty()) {
        student.setSemester(newSemester);
    }

    System.out.println("Enter new Course Name (press Enter to keep current: " + student.getCourseName() + "): ");
    String newCourse = DataInput.inputString().trim();
    if (!newCourse.isEmpty()) {
        student.setCourseName(newCourse);
    }

    System.out.println("Student updated successfully!");
}
private void deleteStudent(Student student) {
    studentList.getStudentList().remove(student);
    System.out.println("Student deleted successfully!");
}

public void reportStudentCourses() {
    HashMap<String, HashMap<String, Integer>> reportData = new HashMap<>();

    for (Student student : studentList.getStudentList()) {
        String studentName = student.getStudentName();
        String courseName = student.getCourseName();

        reportData.putIfAbsent(studentName, new HashMap<>());

        HashMap<String, Integer> courses = reportData.get(studentName);
        courses.put(courseName, courses.getOrDefault(courseName, 0) + 1);
    }

    System.out.println("\n=== Student Course Report ===");
    for (Map.Entry<String, HashMap<String, Integer>> entry : reportData.entrySet()) {
        String studentName = entry.getKey();
        HashMap<String, Integer> courses = entry.getValue();

        for (Map.Entry<String, Integer> courseEntry : courses.entrySet()) {
            String courseName = courseEntry.getKey();
            int totalCourses = courseEntry.getValue();

            System.out.println(studentName + " | " + courseName + " | " + totalCourses);
        }
    }
}


}
