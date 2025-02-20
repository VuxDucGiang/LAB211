package Week5.CourseManagement.Controller;

import Week5.CourseManagement.View.CourseListView;
import Week5.CourseManagement.View.Menu;

public class CourseManagementSystem {

    CourseListView clv = new CourseListView();

    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();
        cms.clv.loadFromFile();

        String[] options = {
            "Add Online Course / Offline Course",
            "Update Course",
            "Print All / Online Course / Offline Course",
            "Search Information Base On Course Name",};

        Menu<String> menu = new Menu<>("\nCourse Management", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 ->
                        cms.clv.addCourse();
                    case 2 ->
                        cms.clv.updateCourse();
                    case 3 ->
                        cms.clv.printCourse();
                    case 4 ->
                        cms.clv.searchInformationByName();
                    default ->
                        System.out.println("Invalid option. Please try again.");
                }
            }
        };
        menu.run();
    }
}
