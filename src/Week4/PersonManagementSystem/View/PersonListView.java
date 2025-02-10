package Week4.PersonManagementSystem.View;

import Week4.PersonManagementSystem.Model.Student;
import Week4.PersonManagementSystem.Model.StudentList;
import Week4.PersonManagementSystem.Model.Teacher;
import Week4.PersonManagementSystem.Model.TeacherList;
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
        System.out.print("Enter ID: ");
        String ID = sc.nextLine().trim();
        System.out.print("Enter Full Name: ");
        String fullName = sc.nextLine().trim();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.nextLine().trim();
        System.out.print("Enter Major: ");
        String major = sc.nextLine().trim();
        System.out.print("Enter Year of Birth: ");
        int yearOfBirth = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Years in Profession: ");
        int yearInProfession = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Contract Type: ");
        String contractType = sc.nextLine().trim();
        System.out.print("Enter Salary Coefficient: ");
        double salaryCoefficient = Double.parseDouble(sc.nextLine().trim());

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
         System.out.print("Enter ID: ");
        String ID = sc.nextLine().trim();
        System.out.print("Enter Full Name: ");
        String fullName = sc.nextLine().trim();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.nextLine().trim();
        System.out.print("Enter Major: ");
        String major = sc.nextLine().trim();
        System.out.print("Enter Year of Birth: ");
        int yearOfBirth = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Years Of Addmission: ");
        int yearOfAdmission = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Entrance English Score: ");
        double entranceEnglishScore = Double.parseDouble(sc.nextLine());

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
