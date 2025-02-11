package Week4.PersonManagementSystem.View;

import Week4.PersonManagementSystem.Model.Student;
import Week4.PersonManagementSystem.Model.StudentList;
import Week4.PersonManagementSystem.Model.Teacher;
import Week4.PersonManagementSystem.Model.TeacherList;
import java.time.Year;
import java.util.Scanner;

public class PersonListView {

    private Scanner sc;
    private StudentList sl;
    private TeacherList tl;

    // Constructor để khởi tạo danh sách
    public PersonListView() {
        sl = new StudentList();
        tl = new TeacherList();
        sc = new Scanner(System.in);
    }

    public void loadFromFile() {
        sl.loadStudent();
        tl.loadTeacher();
    }

    public void teacherManagement() {
        String[] options = {
            "Input",
            "Print",
            "Exit"
        };

        Menu<String> menu = new Menu<>("\nTeacher Management", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 ->
                        createNewTeacher();
                    case 2 ->
                        tl.displayTeacher();

                    default ->
                        System.out.println("Invalid option.");
                }
            }
        };
        menu.run();
    }

    public void createNewTeacher() {
        Scanner sc = new Scanner(System.in);
        int currentYear = Year.now().getValue();

        String ID;
        do {
            System.out.print("Enter ID (6 characters): ");
            ID = sc.nextLine().trim();
        } while (ID.length() != 6);

        String fullName;
        do {
            System.out.print("Enter Full Name (letters and spaces only): ");
            fullName = sc.nextLine().trim();
        } while (!fullName.matches("[A-Za-z ]+"));

        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.nextLine().trim();

        String major;
        do {
            System.out.print("Enter Major (max 30 characters): ");
            major = sc.nextLine().trim();
        } while (major.length() > 30);

        int yearOfBirth;
        do {
            System.out.print("Enter Year of Birth (before " + currentYear + "): ");
            yearOfBirth = Integer.parseInt(sc.nextLine().trim());
        } while (yearOfBirth >= currentYear);

        int yearInProfession;
        do {
            System.out.print("Enter Years in Profession (0 to " + (currentYear - yearOfBirth - 1) + "): ");
            yearInProfession = Integer.parseInt(sc.nextLine().trim());
        } while (yearInProfession < 0 || yearInProfession >= (currentYear - yearOfBirth));

        String contractType;
        do {
            System.out.print("Enter Contract Type (long or short): ");
            contractType = sc.nextLine().trim().toLowerCase();
        } while (!contractType.equals("long") && !contractType.equals("short"));

        double salaryCoefficient;
        do {
            System.out.print("Enter Salary Coefficient (positive number): ");
            salaryCoefficient = Double.parseDouble(sc.nextLine().trim());
        } while (salaryCoefficient <= 0);

        Teacher teacher = new Teacher(ID, fullName, phoneNumber, major, yearOfBirth, yearInProfession, contractType, salaryCoefficient);
        tl.getTeacherLists().add(teacher);
        System.out.println("Teacher Added Successfully");

    }

    public void studentManagement() {
        String[] options = {
            "Input",
            "Print",
            "Exit"
        };

        Menu<String> menu = new Menu<>("\nStudent Management", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 ->
                        createNewStudent();
                    case 2 ->
                        sl.displayStudent();

                    default ->
                        System.out.println("Invalid option.");
                }
            }
        };
        menu.run();
    }

    public void createNewStudent() {
        int currentYear = Year.now().getValue();

        String ID;
        do {
            System.out.print("Enter ID (6 digits): ");
            ID = sc.nextLine().trim();
        } while (!ID.matches("\\d{6}"));
        String fullName;
        do {
            System.out.print("Enter Full Name (letters and spaces only): ");
            fullName = sc.nextLine().trim();
        } while (!fullName.matches("[A-Za-z ]+"));

        String phoneNumber;
        do {
            System.out.print("Enter Phone Number (12 digits): ");
            phoneNumber = sc.nextLine().trim();
        } while (!phoneNumber.matches("\\d{12}"));

        String major;
        do {
            System.out.print("Enter Major (max 30 characters): ");
            major = sc.nextLine().trim();
        } while (major.length() > 30);

        int yearOfBirth;
        do {
            System.out.print("Enter Year of Birth (before " + currentYear + "): ");
            yearOfBirth = Integer.parseInt(sc.nextLine().trim());
        } while (yearOfBirth >= currentYear);

        int yearOfAdmission;
        do {
            System.out.print("Enter Year of Admission (" + yearOfBirth + " - " + currentYear + "): ");
            yearOfAdmission = Integer.parseInt(sc.nextLine().trim());
        } while (yearOfAdmission < yearOfBirth || yearOfAdmission > currentYear);

        double entranceEnglishScore;
        do {
            System.out.print("Enter Entrance English Score (0 - 100): ");
            entranceEnglishScore = Double.parseDouble(sc.nextLine().trim());
        } while (entranceEnglishScore < 0 || entranceEnglishScore > 100);

        Student student = new Student(ID, fullName, phoneNumber, major, yearOfBirth, yearOfAdmission, entranceEnglishScore);
        sl.getStudentLists().add(student);
        System.out.println("Student Added Successfully");
    }

    public void personManagement() {
        String[] options = {
            "Search",
            "Display All",
            "Exit"
        };

        Menu<String> menu = new Menu<>("\nPerson Management", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 ->
                        searchPerson();
                    case 2 -> {
                        sl.displayStudent();
                        tl.displayTeacher();
                    }

                    default ->
                        System.out.println("Invalid option.");
                }
            }
        };
        menu.run();
    }

    public void searchPerson() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        Teacher foundTeacher = tl.searchTeacherByName(name);
        Student foundStudent = sl.searchStudentByName(name);

        if (foundTeacher != null) {
            System.out.println("Found Teacher: " + foundTeacher);
        }
        if (foundStudent != null) {
            System.out.println("Found Student: " + foundStudent);
        }
        if (foundTeacher == null && foundStudent == null) {
            System.out.println("No person found with the given name.");
        }
    }
}
