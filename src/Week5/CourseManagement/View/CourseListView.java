package Week5.CourseManagement.View;

import Week5.CourseManagement.Model.OfflineCourseList;
import Week5.CourseManagement.Model.OnlineCourse;
import Week5.CourseManagement.Model.OnlineCourseList;
import Week5.CourseManagement.View.Menu;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CourseListView {

    private Scanner sc;
    private OfflineCourseList ofcl;
    private OnlineCourseList oncl;

    public CourseListView() {
        ofcl = new OfflineCourseList();
        oncl = new OnlineCourseList();
        sc = new Scanner(System.in);
    }

    public void loadFromFile() {
        ofcl.loadOfflineCourse();
        oncl.loadOnlineCourse();
    }

    public void addCourse() {
        String[] options = {
            "Offline Course",
            "Online Course",};

        Menu<String> menu = new Menu<>("\nAdding Course", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 ->
                        addOfflineCourse();
                    case 2 ->
                        addOnlineCourse();
                    default ->
                        System.out.println("Invalid option.");
                }
            }
        };
        menu.run();
    }

    public void addOfflineCourse (){ 
        
    }

    public void addOnlineCourse() {
        System.out.println("Enter Course ID: ");
        String courseID = DataInput.inputString();
        System.out.println("Enter Course Name: ");
        String courseName = DataInput.inputString();
        System.out.println("Enter Credits: ");
        int credits = sc.nextInt();
        System.out.println("Enter Platform: ");
        String platform = DataInput.inputString();
        System.out.println("Enter Instructors: ");
        String instructor = DataInput.inputString();
        System.out.println("Enter Note: ");
        String note = DataInput.inputString();
        OnlineCourse onlineCourse = new OnlineCourse(courseID, courseName, credits, platform, instructor, note);
        oncl.getOnlineCourseList().add(onlineCourse);
        System.out.println("Online Course Added Successfully");
    }

    public void updateCourse() {

    }

    private void displayAllCourse() {
        ofcl.displayOfflineCourse();
        oncl.displayOnlineCourse();
    }

    public void printCourse() {
        String[] options = {
            "Print All",
            "Print Online Course",
            "Print Offline Course",};

        Menu<String> menu = new Menu<>("\nAdding Course", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 ->
                        displayAllCourse();
                    case 2 ->
                        oncl.displayOnlineCourse();
                    case 3 ->
                        ofcl.displayOfflineCourse();
                    default ->
                        System.out.println("Invalid option.");
                }
            }
        };
        menu.run();
    }

    public void searchInformationByName() {

    }
}
