package Week4.StudentManagementSystem.Controller;

import Week4.StudentManagementSystem.Model.StudentList;
import Week4.StudentManagementSystem.View.Menu;
import Week4.StudentManagementSystem.View.StudentListView;

public class StudentManagementSystem {
    StudentList studentList = new StudentList();
    StudentListView studentListView = new StudentListView(studentList);
    
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.studentList.loadFromFile("src/Week4/StudentManagementSystem/View/student.txt");
                String[] options = {
            "Display All",
              "Create New Student",
              "Find and Sort",
              "Update and Delete",
              "Report",
              
              
        };

        Menu<String> menu = new Menu<>("\nStudent Management System", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> sms.studentList.displayAll();
                    case 2 -> sms.studentListView.createNewStudent();
                    case 3 -> sms.studentListView.findAndsort();
                    case 4 -> sms.studentListView.updateAndDeleteStudent();
                    case 5 -> sms.studentListView.reportStudentCourses();
                    default -> {
                        System.out.println("Exiting the system.");
                        System.exit(0);
                    }
                }
            }
        };
        menu.run();
    }
}
